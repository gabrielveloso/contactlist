package contactList.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import contactList.model.Contact;
import contactList.model.User;
import contactList.repository.ContactRepository;
import contactList.repository.UserRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	//add contact in user's list	
	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public ResponseEntity<?>  postContact(@PathVariable Long userId, @RequestBody Contact bodyJson) {	
		
		User finded = this.userRepository.findOne(userId);		
		contactRepository.save(new Contact(finded, bodyJson.getName(), bodyJson.getPhoneHome()));		
		return new ResponseEntity<String>("work", HttpStatus.OK);
    	
    }
	
	 @RequestMapping("/search")
	    public Contact getContact(@RequestParam(value="id") Long id) {
	        return this.contactRepository.findOne(id);
	    }

	
	
	
}
