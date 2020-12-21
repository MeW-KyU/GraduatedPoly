package team5.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "History", schema = "dbo", catalog = "Doan")
public class History implements java.io.Serializable {

	private static final long serialVersionUID = 953497111141829539L;

	@NotNull
	private int id;

	private String name;
	private String nameAct;
	private Date dayAct;
	private String typeAct;

	public History(int id, String name, String nameAct, Date dayAct, String typeAct) {
		super();
		this.id = id;
		this.name = name;
		this.nameAct = nameAct;
		this.dayAct = dayAct;
		this.typeAct = typeAct;
	}

	public History() {
		super();
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 20)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "nameAct", nullable = false)
	public String getNameAct() {
		return nameAct;
	}

	public void setNameAct(String nameAct) {
		this.nameAct = nameAct;
	}

	@Column(name = "dayAct",nullable = false)
	public Date getDayAct() {
		return dayAct;
	}

	public void setDayAct(Date dayAct) {
		this.dayAct = dayAct;
	}

	@Column(name = "typeAct", nullable = false)
	public String getTypeAct() {
		return typeAct;
	}

	public void setTypeAct(String typeAct) {
		this.typeAct = typeAct;
	}

}
