package team5.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Invoice", schema = "dbo", catalog = "Doan")
public class Invoice implements Serializable{

	private static final long serialVersionUID = -1603199865207688180L;

	private Integer invoice_Code;
	private Date date_Sale;
	private String name_Mask;
	private String phone_Mask;
	@Email
	private String email_Mask;
	private String address_Mask;
	private float amount;
	private String note;
	private float total;
	private int status;
	private String customer_Code;
	private Set<DetailInvoice> detailInvoices = new HashSet<DetailInvoice>();
	
	public Invoice() {
	}

	public Invoice(Integer invoice_Code, Date date_Sale, String name_Mask, String phone_Mask, String email_Mask,
			String address_Mask, float amount, String note, float total, int status, String customer_Code, Set<DetailInvoice> detailInvoices) {
		this.invoice_Code = invoice_Code;
		this.date_Sale = date_Sale;
		this.name_Mask = name_Mask;
		this.phone_Mask = phone_Mask;
		this.email_Mask = email_Mask;
		this.address_Mask = address_Mask;
		this.amount = amount;
		this.note = note;
		this.total = total;
		this.status = status;
		this.customer_Code = customer_Code;
		this.detailInvoices = detailInvoices;
	}

	@Id
	@GeneratedValue
	@Column(name = "Invoice_Code", unique = true, nullable = false)
	public Integer getInvoice_Code() {
		return invoice_Code;
	}

	public void setInvoice_Code(Integer invoice_Code) {
		this.invoice_Code = invoice_Code;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "Date_Sale", nullable = false, length = 23)
	public Date getDate_Sale() {
		return date_Sale;
	}

	public void setDate_Sale(Date date_Sale) {
		this.date_Sale = date_Sale;
	}

	@Column(name = "Name_Mask")
	public String getName_Mask() {
		return name_Mask;
	}

	public void setName_Mask(String name_Mask) {
		this.name_Mask = name_Mask;
	}

	@Column(name = "Phone_Mask")
	public String getPhone_Mask() {
		return phone_Mask;
	}

	public void setPhone_Mask(String phone_Mask) {
		this.phone_Mask = phone_Mask;
	}

	@Column(name = "Email_Mask")
	public String getEmail_Mask() {
		return email_Mask;
	}

	public void setEmail_Mask(String email_Mask) {
		this.email_Mask = email_Mask;
	}

	@Column(name = "Address_Mask")
	public String getAddress_Mask() {
		return address_Mask;
	}

	public void setAddress_Mask(String address_Mask) {
		this.address_Mask = address_Mask;
	}
	
	@Column(name = "Amount")
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column(name = "Note")
	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "Total")
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Column(name = "Status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	@Column(name = "Customer_Code")
	public String getCustomer_Code() {
		return customer_Code;
	}

	public void setCustomer_Code(String customer_Code) {
		this.customer_Code = customer_Code;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "invoice")
	public Set<DetailInvoice> getDetailInvoices() {
		return detailInvoices;
	}

	public void setDetailInvoices(Set<DetailInvoice> detailInvoices) {
		this.detailInvoices = detailInvoices;
	}
	
}
