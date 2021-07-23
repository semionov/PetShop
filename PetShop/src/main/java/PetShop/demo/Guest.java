package PetShop.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

//Creating class and attributes:
public class Guest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int id;
	public String name;
	public String surname;
	public int age;
	public String phoneNumber;
	public String email;
	public String password;
	

//Relationship type:
	@OneToMany (mappedBy = "guest" , cascade = CascadeType.ALL)
	public List<Pcr> pcr = new ArrayList<>();
	
	
//Constructor:	
	
	public Guest() {}
	
	public Guest(String name, String surname, int age, String phoneNumber, String email, String password) {
		super();
		//this.id = id; not necessary JPA's annotation "@id" has already created it.
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
	
	public Guest( String name, String surname, int age) {
		super();
		//this.id = id; not necessary JPA's annotation "@id" has already created it.
		//this.id = id;
		this.name = name;
		this.surname = surname;
		this.age = age;
	}
	

	
//Getters and Setters:	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber (String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pcr> getPcr() {
		return pcr;
	}
	
		public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


	//adding method:
	

	public void addPcr(Pcr pcr) {
		this.pcr.add(pcr);
		pcr.setGuest(this);
	}


	//ToString:	
	@Override
	public String toString() {
		return "Guest [id=" + id + ", name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + ", email=" + email +", pcr=" + pcr
				+ ", password=" + password + "]";
	}
	
}

