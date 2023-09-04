package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
@Entity
public class DonationEntity {
	@Id
	@GeneratedValue
	private int donation_id;
	private int amount;
	private Date donation_date;
	private String status;
	public int getDonation_id() {
		return donation_id;
	}
	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getDonation_date() {
		return donation_date;
	}
	public void setDonation_date(Date donation_date) {
		this.donation_date = donation_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public DonationEntity(int donation_id, int amount, Date donation_date, String status) {
		super();
		this.donation_id = donation_id;
		this.amount = amount;
		this.donation_date = donation_date;
		this.status = status;
	}
	public DonationEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
