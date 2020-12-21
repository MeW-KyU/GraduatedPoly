package team5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Account", schema = "dbo", catalog = "Doan")
public class Account implements java.io.Serializable {

	private static final long serialVersionUID = -7697032234521892336L;
	
	@NotNull
	private String username;
	private String password;
	private int access;

	public Account() {
	}

	public Account(String username, String password, int access) {
		super();
		this.username = username;
		this.password = password;
		this.access = access;
	}

	@Id

	@Column(name = "Username", unique = true, nullable = false, length = 50)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password", nullable = false, length = 50)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Access", nullable = false)
	public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}
}
