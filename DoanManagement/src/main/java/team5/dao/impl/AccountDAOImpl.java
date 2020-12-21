package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.AccountDAO;
import team5.model.Account;

@Repository
public class AccountDAOImpl implements AccountDAO {

	@Autowired
	SessionFactory sessionFactory;

	// ==> Quản Lý Tài Khoản

	/**
	 * Thêm tài khoản
	 */
	public void insertAccount(Account account,String nameu) {
		Session session = sessionFactory.openSession();
		try {
			session.save(account);
			String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Account',GETDATE(),'success')";
			Query query = session.createSQLQuery(sql1);
			int result = query.executeUpdate();
			System.out.println(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

	}

	/**
	 * Sửa tài khoản
	 */
	public void editAccount(Account account,String nameu) {
		Session session = sessionFactory.openSession();
		try {
			session.update(account);
			String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Edit Account',GETDATE(),'warning')";
			Query query = session.createSQLQuery(sql1);
			int result = query.executeUpdate();
			System.out.println(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

	}

	/**
	 * Xóa tài khoản
	 */
	public void deleteAccount(Account account,String nameu) {
		Session session = sessionFactory.openSession();
		try {
			session.delete(account);
			String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Delete Account',GETDATE(),'danger')";
			Query query = session.createSQLQuery(sql1);
			int result = query.executeUpdate();
			System.out.println(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}

	}

	/**
	 * Lấy ID
	 */
	public Account getUsernameAccount(String username) {
		Session session = sessionFactory.openSession();
		try {
			Account account = (Account) session.get(Account.class, username);
			return account;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	/**
	 * Kiểm tra tên đăng nhập đã tồn tại chưa
	 */
	@SuppressWarnings("unchecked")
	public int checkIdUsername(String username) {
		Session session = sessionFactory.openSession();
		List<Account> list = session.createQuery("FROM Account WHERE Username = '" + username + "'").list();
		return list.size();
	}
	
	/**
	 * Kiểm tra mật khẩu có đúng không
	 */
	@SuppressWarnings("unchecked")
	public int checkPassword(String password) {
		Session session = sessionFactory.openSession();
		List<Account> list = session.createQuery("FROM Account WHERE Password = '" + password + "'").list();
		return list.size();
	}

	/**
	 * Lấy danh sách tài khoản
	 */
	@SuppressWarnings("unchecked")
	public List<Account> getListAccount() {
		Session session = sessionFactory.openSession();
		try {
			List<Account> list = session.createQuery("FROM Account").list();
			return list;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	// ==> Đăng Nhập

	/**
	 * Kiểm tra tên đăng nhập tồn tại không
	 */
	public boolean checkUsername(String Username) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Account where Username = :Username");
			query.setString("Username", Username);
			Account account = (Account) query.uniqueResult();
			return account != null;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return false;
	}

	/**
	 * Kiểm tra đăng nhập
	 */
	public Account loginAccount(String Username, String Password) {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Account where Username = :Username and Password = :Password");
			query.setString("Username", Username);
			query.setString("Password", Password);
			Account account = (Account) query.uniqueResult();
			return account;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.flush();
			session.close();
		}
		return null;
	}

	/**
	 * Tìm tài khoản
	 */
	@SuppressWarnings("unchecked")
	public List<Account> searchAccount(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Account> list = session.createQuery("FROM Account WHERE username LIKE '%" + search + "%'").list();
		return list;
	}

}
