package team5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TopProduct", schema = "dbo", catalog = "Doan")
public class TopProduct implements java.io.Serializable {

	private static final long serialVersionUID = 953497111141829539L;

	@NotNull
	private int id;
	private int amount;
	private String product_Code;



	public TopProduct() {
		super();
	}

	public TopProduct(int id, int amount, String product_Code) {
		super();
		this.id = id;
		this.amount = amount;
		this.product_Code = product_Code;
	}
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 20)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "Amount", unique = true, nullable = false, length = 20)
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Column(name = "Product_Code", unique = true, nullable = false, length = 20)
	public String getProduct_Code() {
		return product_Code;
	}

	public void setProduct_Code(String product_Code) {
		this.product_Code = product_Code;
	}

	

}
