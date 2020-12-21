package team5.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Staff", schema = "dbo", catalog = "Doan")
public class Staff implements java.io.Serializable {

	private static final long serialVersionUID = 2462749256939746398L;

	@NotNull
	private String staff_Code;
	private String name_Staff;
	private int position;
	private float salary;
	private int gender;
	private Date birthday;
	private String phone_Staff;
	@Email
	private String email_Staff;
	private String address_Staff;

	public Staff() {
	}

	public Staff(String staff_Code, String name_Staff, int position, float salary, int gender, Date birthday,
			String phone_Staff, String email_Staff, String address_Staff) {
		this.staff_Code = staff_Code;
		this.name_Staff = name_Staff;
		this.position = position;
		this.salary = salary;
		this.gender = gender;
		this.birthday = birthday;
		this.phone_Staff = phone_Staff;
		this.email_Staff = email_Staff;
		this.address_Staff = address_Staff;
	}

	@Id

	@Column(name = "Staff_Code", unique = true, nullable = false, length = 20)
	public String getStaff_Code() {
		return staff_Code;
	}

	public void setStaff_Code(String staff_Code) {
		this.staff_Code = staff_Code;
	}

	@Column(name = "Name_Staff", nullable = false)
	public String getName_Staff() {
		return name_Staff;
	}

	public void setName_Staff(String name_Staff) {
		this.name_Staff = name_Staff;
	}

	@Column(name = "Position", nullable = false)
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Column(name = "Salary", nullable = false)
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Column(name = "Gender")
	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "Birthday", nullable = false)
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "Phone_Staff", length = 15)
	public String getPhone_Staff() {
		return phone_Staff;
	}

	public void setPhone_Staff(String phone_Staff) {
		this.phone_Staff = phone_Staff;
	}

	@Column(name = "Email_Staff")
	public String getEmail_Staff() {
		return email_Staff;
	}

	public void setEmail_Staff(String email_Staff) {
		this.email_Staff = email_Staff;
	}

	@Column(name = "Address_Staff", length = 15)
	public String getAddress_Staff() {
		return address_Staff;
	}

	public void setAddress_Staff(String address_Staff) {
		this.address_Staff = address_Staff;
	}
}
