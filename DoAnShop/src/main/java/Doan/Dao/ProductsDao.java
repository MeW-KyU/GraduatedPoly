package Doan.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import Doan.Entity.MapperProducts;
import Doan.Entity.Products;

@Repository
public class ProductsDao extends BaseDao {
	
	//Query 6 products at random
	private String sqlProductIndex() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT TOP 6 * FROM Product ");
		sql.append("ORDER BY NEWID()");
		return sql.toString();
	}
	
	private StringBuffer sqlString() {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * FROM Product");
		return sql;
	}
	
	private String sqlProductsByID(String id) {
		StringBuffer sql = sqlString();
		sql.append(" WHERE 1 = 1");
		sql.append(" AND Categories_Code = '"+id+"'");
		return sql.toString();
	}
	
	//Show 6
	public List<Products> GetDataProducts() {
		String sql = sqlProductIndex();
		List<Products> list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	
	public List<Products> GetAllProductsByID(String id) {
		String sql = sqlProductsByID(id);
		List<Products> list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
	
	private String sqlProductByID(String id) {
		StringBuffer sql= sqlString();
		sql.append(" WHERE 1 = 1");
		sql.append(" AND Product_Code = '"+id+"'");
		return sql.toString();
	}
	
	public List<Products> GetProductByID(String id) {
		String sql = sqlProductByID(id);
		List<Products> listProduct = _jdbcTemplate.query(sql, new MapperProducts());
		return listProduct;
	}
	
	public Products FindProductsByID(String id) {
		String sql = sqlProductByID(id);
		Products listproduct = _jdbcTemplate.queryForObject(sql, new MapperProducts());
		return listproduct;
	}
	
	// Menu
	private String sqlMenu() {
		StringBuffer  sql = new StringBuffer();
		sql.append("SELECT * FROM Product ");
		return sql.toString();
	}
	
	// Show all product in menu
	public List<Products> GetAllProducts() {
		String sql = sqlMenu();
		List<Products> list = _jdbcTemplate.query(sql, new MapperProducts());
		return list;
	}
}
