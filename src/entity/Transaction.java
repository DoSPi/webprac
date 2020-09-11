package entity;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.Timestamp;

import javax.persistence.Column;
@Entity
@Table(name="transaction")
public class Transaction{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="transaction_id")
    private long transaction_id;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
    @Column (name="date", nullable = false)
    private java.sql.Timestamp date;
    @Column(name="value", nullable = false)
    private double value;
    @Column(name="details", nullable = true)
    private String details; 
	public Transaction( Account account,Timestamp date, double value, String details) {
		this.account = account;
		this.date = date;
		this.value = value;
		this.details = details;
	}
	public Transaction() {
		
	}
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
    
}