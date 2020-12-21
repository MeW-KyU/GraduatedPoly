package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.StaffDAO;
import team5.model.Staff;

@Repository
public class StaffDAOImpl implements StaffDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Thêm nhân viên
	 */
	public void insertStaff(Staff staff,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(staff);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Staff',GETDATE(),'success')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Sửa nhân viên
	 */
	public void editStaff(Staff staff,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(staff);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Edit Staff',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Xoá nhân viên
	 */
	public void deleteStaff(Staff staff,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(staff);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Delete Staff',GETDATE(),'danger')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Load Staff Code
	 */
	public Staff getStaff_Code(String staff_Code) {
		Session session = sessionFactory.getCurrentSession();
		Staff staff = (Staff) session.get(Staff.class, staff_Code);
		return staff;
	}

	/**
	 * Kiểm tra mã nhân viên đã tồn tại chưa
	 */
	@SuppressWarnings("unchecked")
	public int checkIdStaff_Code(String staff_Code) {
		Session session = sessionFactory.getCurrentSession();		
		List<Staff> list = session.createQuery("FROM Staff WHERE Staff_Code = '" + staff_Code + "'").list();
		return list.size();
	}

	/**
	 * Load danh sách nhân viên
	 */
	@SuppressWarnings("unchecked")
	public List<Staff> getListStaff() {
		Session session = sessionFactory.getCurrentSession();
		List<Staff> list = session.createQuery("FROM Staff").list();
		return list;
	}

	/**
	 * Tìm kiếm theo nhân viên
	 */
	@SuppressWarnings("unchecked")
	public List<Staff> searchBySta(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Staff> list = session
				.createQuery("FROM Staff WHERE Staff_Code Like '%" + search + "%' OR Name_Staff LIKE '%" + search + "%'")
				.list();
		return list;
	}
	
	/**
	 * Phân trang nhân viên
	 */
	@SuppressWarnings("unchecked")
	public List<Staff> loadStaPage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Staff");
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
	public int getRowSta() {
		Session session = sessionFactory.getCurrentSession();
		List<Staff> list = session.createQuery("FROM Staff").list();
		int i = 0;
		for (Staff sta : list) {
			i++;
		}
		return i;
	}

}
