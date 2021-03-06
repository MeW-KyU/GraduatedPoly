package team5.dao;

import java.util.List;

import team5.model.Customer;

public interface CustomerDAO {

	// ==> Quản lí khách hàng
	
	/**
	 * Thêm khách hàng
	 * 
	 * @param customer
	 */
	public void insertCustomer(Customer customer,String nameu);
	
	/**
	 * Sửa khách hàng
	 * 
	 * @param customer
	 */
	public void editCustomer(Customer customer,String nameu);
	
	/**
	 * Xoá khách hàng
	 * 
	 * @param customer
	 */
	public void deleteCustomer(Customer customer,String nameu);
	
	/**
	 * Load Customer Code
	 * 
	 * @param customer
	 * @return
	 */
	public Customer getCustomer_Code(String customer_Code);
	
	/**
	 * Kiểm tra mã khách hàng đăng nhập đã tồn tại chưa
	 * 
	 * @param customer
	 * @return
	 */
	public int checkIdCustomer_Code(String customer_Code);
	
	/**
	 * Load danh sách khách hàng
	 * 
	 * @return
	 */
	public List<Customer> getListCustomer();
	
	/**
	 * Tìm kiếm theo khách hàng
	 * 
	 * @param search
	 * @return
	 */
	public List<Customer> searchByCus(String search);
	
	/**
	 * Phân trang khách hàng
	 * 
	 * @param page
	 * @return
	 */
	public List<Customer> loadCusPage(String page);
	
	public int getRowCus();
}
