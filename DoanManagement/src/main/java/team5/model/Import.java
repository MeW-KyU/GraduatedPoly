package team5.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Import", schema = "dbo", catalog = "Doan")
public class Import implements Serializable{

	private static final long serialVersionUID = 411449124079707409L;

	private Integer import_Code;
	private Date date_Import;
	private Merchandise merchandise;
	private float amount;
	private float unit_Price;
	private float total;
	
	public Import() {
	}

	public Import(Integer import_Code, Date date_Import, Merchandise merchandise, float amount, float unit_Price,
			float total) {
		this.import_Code = import_Code;
		this.date_Import = date_Import;
		this.merchandise = merchandise;
		this.amount = amount;
		this.unit_Price = unit_Price;
		this.total = total;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Import_Code", unique = true)
	public Integer getImport_Code() {
		return import_Code;
	}

	public void setImport_Code(Integer import_Code) {
		this.import_Code = import_Code;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "Date_Import")
	public Date getDate_Import() {
		return date_Import;
	}

	public void setDate_Import(Date date_Import) {
		this.date_Import = date_Import;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Merchandise_Code")
	public Merchandise getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(Merchandise merchandise) {
		this.merchandise = merchandise;
	}

	@Column(name = "Amount")
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column(name = "Unit_Price")
	public float getUnit_Price() {
		return unit_Price;
	}

	public void setUnit_Price(float unit_Price) {
		this.unit_Price = unit_Price;
	}

	@Column(name = "Total")
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
