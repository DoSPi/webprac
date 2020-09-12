package entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
@Entity
@Table(name="client")
public class Client{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="client_id")
    private long client_id;
    @Column (name="name", nullable = false, length = 64)
    private String name;
    @Column(name="address", nullable = true, length = 256)
    private String address;
    @Column(name="email", nullable = true, length = 64)
    private String email;
    @Column(name="phone_number", nullable = true, length = 32)
    private String phone_number;
    public Client(String name, String address, String email, String phone_number) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.phone_number = phone_number;
	}
    public Client() {
    	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public long getClient_id() {
		return client_id;
	}
	public void setClient_id(long client_id) {
		this.client_id = client_id;
	}
    
}
