package contactList;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.boot.CommandLineRunner;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import contactList.model.User;
import contactList.model.Contact;
import contactList.repository.UserRepository;

@SpringBootApplication
public class ContactListApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(ContactListApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ContactListApplication.class, args);
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
