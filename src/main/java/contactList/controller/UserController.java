package contactList.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import contactList.model.User;
import contactList.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {  

	
	@Autowired
	private UserRepository userRepository;
	
    @RequestMapping("/search")
    public User getUser(@RequestParam(value="nameUser") String name) {
        return userRepository.findByName(name);
    }
    
    @RequestMapping("/searchPath/{name}")
    public User getUser1(@PathVariable String name) {
        return userRepository.findByName(name);
    }
    
}