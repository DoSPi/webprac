package entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
@Table(name="department")
public class Department{
    @Id
    @Column(name ="department_id")
    private int department_id;
    @Column (name="name", length = 64, nullable = false)
    private String name;
    @Column(name="address", length = 256, nullable = false)
    private String address;
	public Department(String name, String address) {
		this.name = name;
		this.address = address;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
    
}
