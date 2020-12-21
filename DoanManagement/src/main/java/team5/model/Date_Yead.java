package team5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Date_Yead", schema = "dbo", catalog = "Doan")
public class Date_Yead implements java.io.Serializable {

	private static final long serialVersionUID = 953497111141829539L;

	@NotNull
	private int yead;
	
	

	public Date_Yead() {
	}

	public Date_Yead(int yead) {
		this.yead = yead;

	}

	@Id
	@Column(name = "yead", unique = true, nullable = false, length = 20)
	public int getYead() {
		return yead;
	}

	public void setYead(int yead) {
		this.yead = yead;
	}

	
//	private Integer year;
//	public Integer getYear() {
//		return year;
//	}
//
//	public void setYear(Integer year) {
//		this.year = year;
//	}

	
	
	

}
