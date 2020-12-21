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
@Table(name = "Export", schema = "dbo", catalog = "Doan")
public class Export implements Serializable{

	private static final long serialVersionUID = 2761646889283884839L;

	private Integer export_Code;
	private Date date_Export;
	private Merchandise merchandise;
	private float amount;
	
	public Export() {
	}

	public Export(Integer export_Code, Date date_Export, Merchandise merchandise, float amount) {
		super();
		this.export_Code = export_Code;
		this.date_Export = date_Export;
		this.merchandise = merchandise;
		this.amount = amount;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Export_Code", unique = true)
	public Integer getExport_Code() {
		return export_Code;
	}

	public void setExport_Code(Integer export_Code) {
		this.export_Code = export_Code;
	}

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "Date_Export")
	public Date getDate_Export() {
		return date_Export;
	}

	public void setDate_Export(Date date_Export) {
		this.date_Export = date_Export;
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
	
}
