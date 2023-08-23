package com.example.demo.model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="donors")
public class DonorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donorId;
    private String firstName;
    private String lastName;
    private long phoneNumber;
    private String address;
    private Date registrationDate;
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public DonorEntity(int donorId, String firstName, String lastName, long phoneNumber, String address,
			Date registrationDate) {
		super();
		this.donorId = donorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.registrationDate = registrationDate;
	}
	public DonorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
