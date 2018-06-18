package org.talcrafts.customer.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Objects;

//import org.hibernate.validator.constraints.Email;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String firstname;

	@Column(nullable = false)
	@Email
	private String email;

	@Column(nullable = false)
	private String street;

	@Column(nullable = false)
	private String city;

	public Customer() {
		super();
		id = 0l;
	}

	public Customer(String firstname, String name, String email, String street,
			String city) {
		super();
		this.name = name;
		this.firstname = firstname;
		this.email = email;
		this.street = street;
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return Objects.toString(this);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id,name);

	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Item){
			Customer other=(Customer)obj;
			return Objects.equals(id,other.id); 
		}
		return false;
	}

}
