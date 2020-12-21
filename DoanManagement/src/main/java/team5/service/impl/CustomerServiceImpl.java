package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.CustomerDAO;
import team5.model.Customer;
import team5.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDAO customerDAO;

	/**
	 * Gọi insert từ lớp DAO
	 */
	public void insertCustomer(Customer customer,String nameu) {
		customerDAO.insertCustomer(customer,nameu);
	}

	/**
	 * Gọi edit từ lớp DAO
	 */
	public void editCustomer(Customer customer,String nameu) {
		customerDAO.editCustomer(customer,nameu);
	}

	/**
	 * Gọi delete từ lớp DAO
	 */
	public void deleteCustomer(Customer customer,String nameu) {
		customerDAO.deleteCustomer(customer,nameu);
		
	}

	/**
	 * Lấy Code từ lớp DAO
	 */
	public Customer getCustomer_Code(String customer_Code) {
		return customerDAO.getCustomer_Code(customer_Code);
	}

	/**
	 * Kiểm tra Customer_Code
	 * 
	 * @param customer_Code
	 * @return
	 */
	public int checkIdCustomer_Code(String customer_Code) {
		return customerDAO.checkIdCustomer_Code(customer_Code);
	}

	/**
	 * Lấy List<Customer> từ lớp DAO
	 */
	public List<Customer> getListCustomer() {
		return customerDAO.getListCustomer();
	}

	/**
	 * Tìm kiếm khách hàng theo mã code và tên khách hàng
	 */
	public List<Customer> searchByCus(String search) {
		return customerDAO.searchByCus(search);
	}

	/**
	 * Phân trang cho khách hàng
	 */
	public List<Customer> loadCusPage(String page) {
		return customerDAO.loadCusPage(page);
	}

	public int getRowCus() {
		return customerDAO.getRowCus();
	}
}
