package team5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "Customer", schema = "dbo", catalog = "Doan")
public class Customer implements java.io.Serializable{

	private static final long serialVersionUID = 953497111141829539L;

	@NotNull
	private String customer_Code;
	private String password;
	private String name_Customer;
	private String phone_Customer;
	@Email
	private String email_Customer;
	private String address_Customer;
	public Customer() {
	}
	public Customer(String customer_Code, String password, String name_Customer, String phone_Customer,
			String email_Customer, String address_Customer) {
		this.customer_Code = customer_Code;
		this.password = password;
		this.name_Customer = name_Customer;
		this.phone_Customer = phone_Customer;
		this.email_Customer = email_Customer;
		this.address_Customer = address_Customer;
	}
	
	@Id
	
	@Column(name = "Customer_Code", unique = true, nullable = false, length = 20)
	public String getCustomer_Code() {
		return customer_Code;
	}
	public void setCustomer_Code(String customer_Code) {
		this.customer_Code = customer_Code;
	}
	
	@Column(name = "Password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name = "Name_Customer", nullable = false, length = 50)
	public String getName_Customer() {
		return name_Customer;
	}
	public void setName_Customer(String name_Customer) {
		this.name_Customer = name_Customer;
	}
	
	@Column(name = "Phone_Customer", nullable = false, length = 15)
	public String getPhone_Customer() {
		return phone_Customer;
	}
	public void setPhone_Customer(String phone_Customer) {
		this.phone_Customer = phone_Customer;
	}
	
	@Column(name = "Email_Customer", nullable = false, length = 50)
	public String getEmail_Customer() {
		return email_Customer;
	}
	public void setEmail_Customer(String email_Customer) {
		this.email_Customer = email_Customer;
	}
	
	@Column(name = "Address_Customer", nullable = false, length = 200)
	public String getAddress_Customer() {
		return address_Customer;
	}
	public void setAddress_Customer(String address_Customer) {
		this.address_Customer = address_Customer;
	}
	
}
