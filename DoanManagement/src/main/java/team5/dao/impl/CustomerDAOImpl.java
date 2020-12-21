package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.CustomerDAO;
import team5.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Thêm khách hàng
	 */
	public void insertCustomer(Customer customer,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(customer);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Customer',GETDATE(),'success')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Sửa khách hàng
	 */
	public void editCustomer(Customer customer,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(customer);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Edit Customer',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Xoá khách hàng
	 */
	public void deleteCustomer(Customer customer,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(customer);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Delete Customer',GETDATE(),'danger')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Load Customer Code
	 */
	public Customer getCustomer_Code(String customer_Code) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = (Customer) session.get(Customer.class, customer_Code);
		return customer;
	}

	/**
	 * Kiểm tra mã khách hàng đã tồn tại chưa
	 */
	@SuppressWarnings("unchecked")
	public int checkIdCustomer_Code(String customer_Code) {
		Session session = sessionFactory.getCurrentSession();		
		List<Customer> list = session.createQuery("FROM Customer WHERE Customer_Code = '" + customer_Code + "'").list();
		return list.size();
	}

	/**
	 * Load danh sách khách hàng
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> getListCustomer() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> list = session.createQuery("FROM Customer").list();
		return list;
	}

	/**
	 * Tìm kiếm theo khách hàng
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> searchByCus(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> list = session
				.createQuery("FROM Customer WHERE Customer_Code Like '%" + search + "%' OR Name_Customer LIKE '%" + search + "%'")
				.list();
		return list;
	}

	/**
	 * Phân trang khách hàng
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> loadCusPage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Customer");
		int result = 0;
		if (page.equals("1")) {
			result = 0;
		} else {
			String temp = String.valueOf(page) + "0";
			result = Integer.parseInt(temp) - 10;
		}
		query.setFirstResult(result);
		query.setMaxResults(10);
		return query.list();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public int getRowCus() {
		Session session = sessionFactory.getCurrentSession();
		List<Customer> list = session.createQuery("FROM Customer").list();
		int i = 0;
		for (Customer cus : list) {
			i++;
		}
		return i;
	}
	
}
