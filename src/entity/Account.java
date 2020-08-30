package entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import java.sql.Date;

import javax.persistence.Column;
@Entity
@Table(name="account")
public class Account{
    @Id
    @Column(name ="account_id")
    private int account_id;
    @Column(name ="client_id")
    private int client_id;
    @Column(name ="balance")
    private double balance;
    @Column(name ="type_id")
    private int type_id;
    @Column(name ="department_id")
    private int department_id;
    @Column(name ="payment_account_id")
    private int payment_account_id;
    @Column(name = "date")
    private Date date;
    @Column(name = "closed")
    private boolean closed;
    public Account(){
        
    }
}
