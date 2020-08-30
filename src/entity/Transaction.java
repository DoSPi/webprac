package entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.sql.Date;

import javax.persistence.Column;
@Entity
@Table(name="transaction")
public class Transaction{
    @Id
    @Column(name ="transaction_id")
    private int transaction_id;
    @Column (name="date")
    private Date date;
    @Column(name="value")
    private double value;
    @Column(name="details")
    private String details; 
    public Transaction(){
        
    }
}