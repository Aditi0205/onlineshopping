package onlineshopping.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmailUs {
	private String name;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedBackId;
	private String email;
	private String subject;
	private String description;
	
	
	public EmailUs() {

	}
	
	
	
	public EmailUs(String name, String email, String subject, String description) {
		super();
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.description = description;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return "Feedback:"+subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "Name: "+name+"Email: "+email+"Subject: "+subject+"Description: "+description;
	}

}
