package entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import java.sql.Date;

import javax.persistence.Column;
@Entity
@Table(name="transaction")
public class Transaction{
    @Id
    @Column(name ="transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;
    @ManyToOne
    @JoinColumn(name = "account_id", nullable = true)
    private Account account;
    @Column (name="date", nullable = false)
    private Date date;
    @Column(name="value", nullable = false)
    private double value;
    @Column(name="details", nullable = true)
    private String details; 
	public Transaction( Date date, double value, String details) {
		this.date = date;
		this.value = value;
		this.details = details;
	}
	public long getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
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
	
    
}