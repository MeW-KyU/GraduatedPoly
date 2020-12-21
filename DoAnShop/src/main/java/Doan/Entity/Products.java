package Doan.Entity;

public class Products {
	private String product_Code;
	private String name_Product;
	private Double price;
	private String description;
	private String image;
	private String categories_Code;
	private String size;

	public Products() {
		super();
	}

	public String getProduct_Code() {
		return product_Code;
	}

	public void setProduct_Code(String product_Code) {
		this.product_Code = product_Code;
	}

	public String getName_Product() {
		return name_Product;
	}

	public void setName_Product(String name_Product) {
		this.name_Product = name_Product;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCategories_Code() {
		return categories_Code;
	}

	public void setCategories_Code(String categories_Code) {
		this.categories_Code = categories_Code;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
