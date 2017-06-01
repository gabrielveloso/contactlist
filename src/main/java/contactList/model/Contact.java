package contactList.model;

import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Contact {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long Id;
	private String nameContact;
	private ArrayList<String> phoneHome;
	@ManyToOne
	private User user;
	
	public Contact(){
		
	}
		
	public Contact(User user, String name, ArrayList<String> phones){
		this.user = user;
		this.nameContact = name;
		this.phoneHome = phones;
	}
	
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return nameContact;
	}
	public void setName(String name) {
		this.nameContact = name;
	}
	public ArrayList<String> getPhoneHome() {
		return phoneHome;
	}
	public void setPhoneHome(ArrayList<String> phoneHome) {
		this.phoneHome = phoneHome;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 
	

}
