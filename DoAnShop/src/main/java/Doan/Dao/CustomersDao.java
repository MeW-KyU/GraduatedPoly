package Doan.Dao;

import org.springframework.stereotype.Repository;

import Doan.Entity.Customers;
import Doan.Entity.MapperCustomer;
import Doan.Entity.MapperProducts;
import Doan.Entity.Products;

@Repository
public class CustomersDao extends BaseDao {
	public int AddAccount(Customers customer) {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO Customer VALUES(N'" + customer.getUsername() + "', '" + customer.getPassword() + "', N'"
				+ customer.getName() + "', " + customer.getPhone() + ", '" + customer.getEmail() + "', N'"
				+ customer.getAddress() + "');");
		int insert = _jdbcTemplate.update(sql.toString());
		return insert;
	}
	
	public Customers GetCustomerByAcc(Customers customer) {
		String sql = "SELECT * FROM Customer WHERE Customer_Code = '"+customer.getUsername()+"'";
		Customers result = _jdbcTemplate.queryForObject(sql, new MapperCustomer());
		return result;
	}
}
