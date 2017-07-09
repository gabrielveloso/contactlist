package contactList;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import contactList.model.User;
import contactList.model.Contact;
import contactList.repository.UserRepository;

@SpringBootApplication
@RestController
public class ContactListApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(ContactListApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ContactListApplication.class, args);
	}
	
	/*@RequestMapping("/logar")
	  public Principal user(Principal user) {
	    return user;
	  }*/
	
	@RequestMapping("/logar")
	public ResponseEntity<?> authentication(HttpServletRequest request, 
			Principal user) {
		System.out.println("*** Usuário Logado: "+ user.getName() + " em "+ new Date());
		return new ResponseEntity<Principal>(user, HttpStatus.OK);
	}
	
	
	@Bean
	public CommandLineRunner demo(UserRepository repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new User("gabriel", 32));
			
			/*ArrayList<Contact> contacts = new ArrayList<>();
			Contact one = new Contact("mother", new ArrayList<>(Arrays.asList("000000", "5464556456")));
			contacts.add(one);			
			repository.save(new User("gabriel", 32, contacts));*/
			
			
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (User customer : repository.findAll()) {
				log.info(customer.toString());
			}
		};
		
		
	}
}
