package team5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Revenue", schema = "dbo", catalog = "Doan")
public class Revenue implements java.io.Serializable {

	private static final long serialVersionUID = -7697032234521892336L;
	
	@NotNull
	private int id;
	private int Month_sale;
	private int Year_sale;
	private float Total;

	public Revenue() {
	}

	public Revenue(int id,int Month_sale,int Year_sale,float Total) {
		super();
		this.id = id;
		this.Month_sale = Month_sale;
		this.Year_sale = Year_sale;
		this.Total = Total;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 50)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "Month_sale", nullable = false)
	public int getMonth_sale() {
		return Month_sale;
	}

	public void setMonth_sale(int month_sale) {
		Month_sale = month_sale;
	}
	@Column(name = "Year_sale", nullable = false)
	public int getYear_sale() {
		return Year_sale;
	}

	public void setYear_sale(int year_sale) {
		Year_sale = year_sale;
	}
	@Column(name = "Total", nullable = false)
	public float getTotal() {
		return Total;
	}

	public void setTotal(float total) {
		Total = total;
	}
	
	
	
}
