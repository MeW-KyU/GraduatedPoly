package team5.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DetailInvoice", schema = "dbo", catalog = "Doan")
public class DetailInvoice implements Serializable{

	private static final long serialVersionUID = 9002129010311469646L;

	private Integer id;
	private Invoice invoice;
	private Product product;
	private float amount;
	private float total;
	
	public DetailInvoice() {
	}

	public DetailInvoice(Integer id, Invoice invoice, Product product, float amount, float total) {
		this.id = id;
		this.invoice = invoice;
		this.product = product;
		this.amount = amount;
		this.total = total;
	}

	@Id
	@GeneratedValue
	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Invoice_Code", nullable = false)
	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Product_Code", nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Column(name = "Amount")
	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column(name = "Total")
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}
	
}
