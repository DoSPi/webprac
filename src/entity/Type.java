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
    private long type_id;
    @Column (name="name", length = 64, nullable = false)
    private String name;
    @Column(name="loan_max", nullable = false)
    private double loan_max;
    @Column(name="loan_period", nullable = false)
    private int loan_period;
    @Column(name="profitability", nullable = false)
    private double profitability;
    @Column(name="payment_period", nullable = false)
    private int payment_period;
    @Column(name="add_max", nullable = false)
    private double add_max;
    @Column(name="sub_max", nullable = false)
    private double sub_max;
	public Type(String name, double loan_max, int loan_period, double profitability, int payment_period, double add_max,
			double sub_max) {
		this.name = name;
		this.loan_max = loan_max;
		this.loan_period = loan_period;
		this.profitability = profitability;
		this.payment_period = payment_period;
		this.add_max = add_max;
		this.sub_max = sub_max;
	}
	public long getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLoan_max() {
		return loan_max;
	}
	public void setLoan_max(double loan_max) {
		this.loan_max = loan_max;
	}
	public int getLoan_period() {
		return loan_period;
	}
	public void setLoan_period(int loan_period) {
		this.loan_period = loan_period;
	}
	public double getProfitability() {
		return profitability;
	}
	public void setProfitability(double profitability) {
		this.profitability = profitability;
	}
	public int getPayment_period() {
		return payment_period;
	}
	public void setPayment_period(int payment_period) {
		this.payment_period = payment_period;
	}
	public double getAdd_max() {
		return add_max;
	}
	public void setAdd_max(double add_max) {
		this.add_max = add_max;
	}
	public double getSub_max() {
		return sub_max;
	}
	public void setSub_max(double sub_max) {
		this.sub_max = sub_max;
	}  
}
