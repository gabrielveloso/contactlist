package contactList.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {
	@Id
	private String username;
	private String password;
	private long enabled;
	
	public Users() {
		
	}
	
	public Users(String username, String password, long ena) {
		this.username = username;
		this.password = password;
		this.enabled = ena;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long isEnabled() {
		return enabled;
	}

	public void setEnabled(long enabled) {
		this.enabled = enabled;
	}
}
