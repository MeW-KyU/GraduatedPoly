package Doan.Entity;

public class Bills {
	private long id;
	private String username;
	private String phone;
	private String name;
	private String email;
	private String address;
	private double total;
	private int quanty;
	private String note;

	public Bills() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(Object object) {
		this.total = (double) object;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(Object object) {
		this.quanty = (int) object;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	

}
