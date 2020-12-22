package Doan.Dao;

import org.springframework.stereotype.Repository;

import Doan.Entity.BillDetail;
import Doan.Entity.Bills;

@Repository
public class BillsDao extends BaseDao {

	public int AddBills(Bills bill) {
		StringBuffer sql = new StringBuffer();
		sql.append(
				"INSERT INTO Invoice(Date_Sale, Customer_Code, Name_Mask, Phone_Mask, Email_Mask, Address_Mask, Amount, Total, Note, Status) VALUES("
						+ "getdate()" + ", '"+bill.getUsername()+"', '" + bill.getName() + "', '" + bill.getPhone() + "', '" + bill.getEmail()
						+ "', '" + bill.getAddress() + "', '" + bill.getQuanty() + "', '" + bill.getTotal() + "', '"
						+ bill.getNote() + "', '2');");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};

	public long GetIDLastBills() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT MAX(Invoice_Code) FROM Invoice");
		long id = _jdbcTemplate.queryForObject(sql.toString(), new Object[] {}, Long.class);
		return id;
	};

	public int AddBillsDetail(BillDetail billDetail) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO DetailInvoice(Product_Code, Invoice_Code, Amount, Total) VALUES('"
				+ billDetail.getProduct_Code() + "', " + billDetail.getId_bills() + ", " + billDetail.getQuanty() + ", "
				+ billDetail.getTotal() + ")");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	};

}
