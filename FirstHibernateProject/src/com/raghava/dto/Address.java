package com.raghava.dto;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable          //if you don't want to create a new table for address we can use @Embeddable 
public class Address {
	
	@Column(name="officeStreet")
	private String street;
	@Column(name="officrCity")
	private String city;
	@Column(name="officeState")
	private String state;
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
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	
	
}
