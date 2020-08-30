package entity;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
@Table(name="client")
public class Client{
    @Id
    @Column(name ="client_id")
    private int client_id;
    @Column (name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="email")
    private String email;
    @Column(name="phone_number")
    private String phone_number;
    public Client(){
        
    }
}
