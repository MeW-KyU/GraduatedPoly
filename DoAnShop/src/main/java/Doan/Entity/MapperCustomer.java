package Doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCustomer implements RowMapper<Customers>{

	public Customers mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customers customer = new Customers();
		customer.setUsername(rs.getString("Customer_Code"));
		customer.setPassword(rs.getString("Password"));
		customer.setName(rs.getString("Name_Customer"));
		customer.setPhone(rs.getString("Phone_Customer"));
		customer.setEmail(rs.getString("Email_Customer"));
		customer.setAddress(rs.getString("Address_Customer"));
		return customer;
	}
	
}
