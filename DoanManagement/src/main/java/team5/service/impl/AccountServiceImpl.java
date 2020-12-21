package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.AccountDAO;
import team5.model.Account;
import team5.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountDAO;

	/**
	 * Gọi insert từ lớp DAO
	 */
	public void insertAccount(Account account,String nameu) {
		accountDAO.insertAccount(account,nameu);

	}

	/**
	 * Gọi update từ lớp DAO
	 */
	public void editAccount(Account account,String nameu) {
		accountDAO.editAccount(account,nameu);

	}

	/**
	 * Gọi delete từ lớp DAO
	 */
	public void deleteAccount(Account account,String nameu) {
		accountDAO.deleteAccount(account,nameu);

	}

	/**
	 * Kiểm tra tên đăng nhập đã tồn tại chưa
	 */
	public int checkIdUsername(String username) {
		return accountDAO.checkIdUsername(username);
	}

	/**
	 * Kiểm tra tên đăng nhập đã tồn tại chưa
	 */
	public int checkPassword(String password) {
		return accountDAO.checkPassword(password);
	}

	/**
	 * Lấy IDAccount từ lớp DAO
	 */
	public Account getUsernameAccount(String username) {
		return accountDAO.getUsernameAccount(username);
	}

	/**
	 * Lấy List<Account> từ lớp DAO
	 */
	public List<Account> getListAccount() {
		return accountDAO.getListAccount();
	}

	/**
	 * Gọi phương thức check tên đăng nhập từ lớp DAO
	 */
	public boolean checkUsername(String Username) {
		return accountDAO.checkUsername(Username);
	}

	/**
	 * Gọi phương thức loginAccount từ lớp DAO
	 */
	public Account loginAccount(String Username, String Password) {
		return accountDAO.loginAccount(Username, Password);
	}

	/**
	 * Tìm kiếm tài khoản
	 */
	public List<Account> searchAccount(String search) {
		return accountDAO.searchAccount(search);
	}

}
