package team5.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Categories",schema="dbo", catalog = "Doan")
public class Categories implements java.io.Serializable{

	private static final long serialVersionUID = -4447747515387926775L;

	private String categories_Code;
	private String name_Categories;
	private Set<Product> products = new HashSet<Product>(0);
	
	public Categories() {
	}

	public Categories(String categories_Code, String name_Categories, Set<Product> products) {
		this.categories_Code = categories_Code;
		this.name_Categories = name_Categories;
		this.products = products;
	}


	@Id
	@Column(name = "Categories_Code", unique = true, nullable = false)
	public String getCategories_Code() {
		return categories_Code;
	}

	public void setCategories_Code(String categories_Code) {
		this.categories_Code = categories_Code;
	}

	@Column(name = "Name_Categories", nullable = false)
	public String getName_Categories() {
		return name_Categories;
	}

	public void setName_Categories(String name_Categories) {
		this.name_Categories = name_Categories;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categories")
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
