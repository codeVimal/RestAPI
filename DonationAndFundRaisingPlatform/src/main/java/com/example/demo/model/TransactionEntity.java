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

@Entity
public class TransactionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int transaction_id;
    private String firstName;
    private String lastName;
	private String email;
	private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
	private DonationEntity d;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
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
		this.password = password;
	}
	public DonationEntity getD() {
		return d;
	}
	public void setD(DonationEntity d) {
		this.d = d;
	}
	public TransactionEntity(int transaction_id, String firstName, String lastName, String email, String password,
			DonationEntity d) {
		super();
		this.transaction_id = transaction_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.d = d;
	}
	public TransactionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
