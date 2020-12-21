package team5.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Merchandise", schema = "dbo", catalog = "Doan")
public class Merchandise implements java.io.Serializable {

	private static final long serialVersionUID = -8043481805583199659L;

	@NotNull
	private String merchandise_Code;
	private String name_Merchandise;
	private int unit;
	private float unit_Price;
	private double amount;
	private Set<Export> exports = new HashSet<Export>(0);
	private Set<Import> imports = new HashSet<Import>(0);

	public Merchandise() {
	}

	public Merchandise(String merchandise_Code, String name_Merchandise, int unit, float unit_Price, double amount,
			Set<Export> exports, Set<Import> imports) {
		this.merchandise_Code = merchandise_Code;
		this.name_Merchandise = name_Merchandise;
		this.unit = unit;
		this.unit_Price = unit_Price;
		this.amount = amount;
		this.exports = exports;
		this.imports = imports;
	}

	@Id

	@Column(name = "Merchandise_Code", unique = true, nullable = false, length = 20)
	public String getMerchandise_Code() {
		return merchandise_Code;
	}

	public void setMerchandise_Code(String merchandise_Code) {
		this.merchandise_Code = merchandise_Code;
	}

	@Column(name = "Name_Merchandise")
	public String getName_Merchandise() {
		return name_Merchandise;
	}

	public void setName_Merchandise(String name_Merchandise) {
		this.name_Merchandise = name_Merchandise;
	}

	@Column(name = "Unit")
	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Column(name = "Unit_Price")
	public float getUnit_Price() {
		return unit_Price;
	}

	public void setUnit_Price(float unit_Price) {
		this.unit_Price = unit_Price;
	}

	@Column(name = "Amount")
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "merchandise")
	public Set<Export> getExports() {
		return exports;
	}

	public void setExports(Set<Export> exports) {
		this.exports = exports;
	}
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "merchandise")
	public Set<Import> getImports() {
		return imports;
	}

	public void setImports(Set<Import> imports) {
		this.imports = imports;
	}
}
