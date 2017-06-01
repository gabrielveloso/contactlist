package contactList.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;



@Entity
public class User{

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	private int age;
	@OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="usuario_id")
	private List<Contact> list;	
	
	
	protected User(){
		
	}
	
	public User(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public User(String name, int age, ArrayList<Contact> list){
		this.name = name;
		this.age = age;
		this.list = list;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	 
	 @Override
	    public String toString() {		 
		 	return "Person [pId=" + id + ", personName=" + name + ", personAge=" + age + "]";
	        
	    }

	public List<Contact> getList() {
		return this.list;
	}

	public void setList(ArrayList<Contact> list) {
		this.list = list;
	}

}
