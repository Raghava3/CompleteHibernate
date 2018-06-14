package com.raghava.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="userdetails")
@Table(name="USER_DETAILS")
public class UserDetails {

	@Id
	@GeneratedValue(generator="abc")
	@GenericGenerator(name="abc",strategy="increment")
	private int userId;
	private String userName;
	
	@Embedded//saying that below is emmbedded
	private Address officeAddress;
	
//	There are two objectsof same.(office address and home address but when hibernate checks in the address there is only one type of variable so we have to explictley mention)
//	so to avoid the conflict we use @attributeoverrides 
	@Embedded
	@AttributeOverrides({
	@AttributeOverride(name="street",column=@Column(name="HomeStreet")),
	@AttributeOverride(name="city",column=@Column(name="Homecity")),
	@AttributeOverride(name="state",column=@Column(name="HomeState")),

	})
	private Address homeAddress;
	
	
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
