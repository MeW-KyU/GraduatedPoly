package team5.model;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Product", schema = "dbo", catalog = "Doan")
public class Product implements java.io.Serializable {
	
	private static final long serialVersionUID = -9140104141052588210L;

	@NotNull
	private String product_Code;
	private String name_Product;
	private int unit;
	private float price;
	private String description;
	@Lob
	private byte[] image;
	private String base64Image; //Read image
	private Categories categories;
	private String size;
	private Set<DetailInvoice> invoiceDetails = new HashSet<DetailInvoice>();

	public Product() {
	}

	public Product(String product_Code, String name_Product, int unit, float price, String description, byte[] image,
			String base64Image, Categories categories, String size, Set<DetailInvoice> invoiceDetails) {
		this.product_Code = product_Code;
		this.name_Product = name_Product;
		this.unit = unit;
		this.price = price;
		this.description = description;
		this.image = image;
		this.categories = categories;
		this.size = size;
		this.invoiceDetails = invoiceDetails;
	}



	@Id

	@Column(name = "Product_Code", unique = true, nullable = false)
	public String getProduct_Code() {
		return product_Code;
	}

	public void setProduct_Code(String product_Code) {
		this.product_Code = product_Code;
	}

	@Column(name = "Name_Product")
	public String getName_Product() {
		return name_Product;
	}

	public void setName_Product(String name_Product) {
		this.name_Product = name_Product;
	}

	@Column(name = "Unit")
	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Column(name = "Price")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "Description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Image")
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.image);
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Categories_Code", nullable = false)
	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {
		this.categories = categories;
	}

	@Column(name = "Size")
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
	public Set<DetailInvoice> getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(Set<DetailInvoice> invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

}
