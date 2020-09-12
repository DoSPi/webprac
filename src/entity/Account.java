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
@Table(name="account")
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="account_id")
    private long account_id;
    @ManyToOne 
    @JoinColumn(name = "client_id", nullable = true)
    private Client client;
    @Column(name ="balance", nullable = false)
    private double balance;
    @ManyToOne
    @JoinColumn(name ="type_id", nullable = false)
    Type type;
    @ManyToOne
    @JoinColumn(name ="department_id", nullable = false)
    Department department;
    @ManyToOne
    @JoinColumn(name = "payment_account_id", nullable = false)
    Account payment_account;
    @Column(name = "date", nullable = false)
    private Date date;
    @Column(name = "closed", nullable = false)
    private boolean closed;
    public Account(Client client, double balance, Type type, Department department, Account payment_account, Date date, boolean closed){
        this.client = client;
        this.balance = balance;
        this.type = type;
        this.department = department;
        this.payment_account = payment_account;
        this.date =date;
        this.closed = closed;
        
    }
    public Account() {
    }
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Account getPayment_account() {
		return payment_account;
	}
	public void setPayment_account(Account payment_account) {
		this.payment_account = payment_account;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setClosed(boolean closed) {
		this.closed = closed;
	}
	public boolean isClosed() {
		return closed;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
	
}
