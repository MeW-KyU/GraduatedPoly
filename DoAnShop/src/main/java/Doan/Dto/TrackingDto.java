package Doan.Dto;

import java.sql.Date;

public class TrackingDto {
	private long Invoice_Code;
	private Date Date_Sale;
	private String Name_Product;
	private int Amount;
	private double Total;
	private int Status;
	private String Customer_Code;
	private String note;

	public TrackingDto() {
		super();
	}

	public long getInvoice_Code() {
		return Invoice_Code;
	}

	public void setInvoice_Code(long invoice_Code) {
		Invoice_Code = invoice_Code;
	}

	public Date getDate_Sale() {
		return Date_Sale;
	}

	public void setDate_Sale(Date date_Sale) {
		Date_Sale = date_Sale;
	}

	public String getName_Product() {
		return Name_Product;
	}

	public void setName_Product(String name_Product) {
		Name_Product = name_Product;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	public String getCustomer_Code() {
		return Customer_Code;
	}

	public void setCustomer_Code(String customer_Code) {
		Customer_Code = customer_Code;
	}

}
