package entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
@Table(name="type")
public class Type{
    @Id
    @Column(name ="type_id")
    private int type_id;
    @Column (name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="loan_max")
    private double loan_max;
    @Column(name="loan_period")
    private int loan_period;
    @Column(name="profitability")
    private double profitability;
    @Column(name="payment_period")
    private int payment_period;
    @Column(name="add_max")
    private double add_max;
    @Column(name="sub_max")
    private double sub_max;
    
    public Type(){
        
    }
}
