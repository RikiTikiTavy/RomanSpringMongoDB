package roman.model;

import java.security.NoSuchAlgorithmException;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	@Id
	private String id;

	private String name;

	private String lastName;

	private String dateOfBirth;

	private String email;

	private String password;

	public User() {
		super();
	}

	public User(String id, String name, String lastName, String dateOfBirth, String email, String password) {

		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.password = password;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = PasswordEncryptor.hash256(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
