package com.test.adressbook.contact;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.NotBlank;

@Embeddable
@Access(AccessType.FIELD)
public class Location {

	@Column
	@NotBlank(message = "Country cannot be empty")
	private String country;
	
	@Column
	@NotBlank(message = "City cannot be empty")
	private String city;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	
	
}
