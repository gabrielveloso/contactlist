package contactList.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	 DataSource dataSource;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	  http.authorizeRequests().antMatchers("/", "/**").permitAll().and()
          .authorizeRequests().antMatchers("/console/**").permitAll();

    	  http.csrf().disable();
    	  http.headers().frameOptions().disable();
    	/*http.csrf().disable();
    	
    	http
    		.authorizeRequests()
    		.antMatchers("/*", "/").permitAll();
        /*http
            .authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();*/
    	
    	http.
		httpBasic()
		.and().logout()
		.and().authorizeRequests()
		.antMatchers("/bower_components/**", "/index.html", "/home.html", "/js/**", "/console", "/").permitAll()
		.anyRequest().authenticated();
		/*.and()
		.formLogin().loginPage("/#!/login")
		.usernameParameter("username").passwordParameter("password");*/

    	http.csrf().disable();
    	
		/*.and()
		.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());*/
    }

   /* @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER");
    }*/
    
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth.jdbcAuthentication().dataSource(dataSource)
     .usersByUsernameQuery(
      "select username,password, enabled from users where username= ?")
     .authoritiesByUsernameQuery(
      "select username, role from user_roles where username= ?");
    } 
    
}