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
    @Column (name="name")
    private String name;
    @Column(name="address")
    private String address;
    public Department(){
        
    }
}
