package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="donors")
public class DonorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int donorId;
    private long phoneNumber;
    private String address;
    private Date registrationDate;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn
	private List<DonationEntity> d;
    
	public int getDonorId() {
		return donorId;
	}
	public void setDonorId(int donorId) {
		this.donorId = donorId;
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
	public List<DonationEntity> getD() 
	{
		return d;
	}
	public void setD(List<DonationEntity> d) {
		this.d = d;
	}
	public DonorEntity(int donorId, long phoneNumber, String address, Date registrationDate, List<DonationEntity> d) {
		super();
		this.donorId = donorId;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.registrationDate = registrationDate;
		this.d = d;
	}
	public DonorEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
   
}
