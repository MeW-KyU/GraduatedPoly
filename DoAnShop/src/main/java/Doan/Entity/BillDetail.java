package Doan.Entity;

public class BillDetail {
	private long id;
	private String product_Code;
	private long id_bills;
	private int quanty;
	private double total;

	public BillDetail() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProduct_Code() {
		return product_Code;
	}

	public void setProduct_Code(String product_Code) {
		this.product_Code = product_Code;
	}

	public long getId_bills() {
		return id_bills;
	}

	public void setId_bills(long id_bills) {
		this.id_bills = id_bills;
	}

	public int getQuanty() {
		return quanty;
	}

	public void setQuanty(int quanty) {
		this.quanty = quanty;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
