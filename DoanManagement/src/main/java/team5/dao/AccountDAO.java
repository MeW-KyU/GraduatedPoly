package team5.dao;

import java.util.List;

import team5.model.Account;

public interface AccountDAO {

	// ==> Quản Lý Tài Khoản

	/**
	 * Thêm tài khoản
	 * 
	 * @param account
	 */
	public void insertAccount(Account account,String nameu);

	/**
	 * Sửa tài khoản
	 * 
	 * @param account
	 */
	public void editAccount(Account account,String nameu);

	/**
	 * Xóa tài khoản
	 * 
	 * @param account
	 */
	public void deleteAccount(Account account,String nameu);

	/**
	 * Load ID tài khoản
	 * 
	 * @param username
	 * @return
	 */
	public Account getUsernameAccount(String username);

	
	
	/**
	 * Kiểm tra tên đăng nhập tồn tại chưa
	 * 
	 * @param username
	 * @return
	 */
	public int checkIdUsername(String username);

	/**
	 * Kiểm tra mật khẩu có đúng không
	 * 
	 * @param password
	 * @return
	 */
	public int checkPassword(String password);

	/**
	 * Load danh sách tài khoản
	 * 
	 * @return
	 */
	public List<Account> getListAccount();

	// ==> Đăng Nhập

	/**
	 * Kiểm tra địa chỉ tên đăng nhập đã tồn tại hay chưa
	 * 
	 * @param Username
	 * @return
	 */
	public boolean checkUsername(String Username);

	/**
	 * Kiểm tra đăng nhập
	 * 
	 * @param Username
	 * @param Password
	 * @return
	 */
	public Account loginAccount(String Username, String Password);

	/**
	 * Tìm kiếm tài khoản
	 * 
	 * @param Username
	 * @return
	 */
	public List<Account> searchAccount(String search);
}
