package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.ImportDAO;
import team5.model.Import;

@Repository

public class ImportDAOImpl implements ImportDAO {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Thêm thông tin nhập kho
	 */
	public void insertImport(Import importt,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(importt);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Import',GETDATE(),'success')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Sửa thông tin nhập kho
	 */
	public void editImport(Import importt,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(importt);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Import',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Xóa thông tin nhập kho
	 */
	public void deleteImport(Import importt,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(importt);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Import',GETDATE(),'danger')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Load Import Code
	 */
	public Import getImport_Code(Integer import_Code) {
		Session session = sessionFactory.getCurrentSession();
		Import importt = (Import) session.get(Import.class, import_Code);
		return importt;
	}

	/**
	 * Lấy danh sách thông tin nhập kho
	 */
	@SuppressWarnings("unchecked")
	public List<Import> getListImport() {
		Session session = sessionFactory.getCurrentSession();
		List<Import> list = session.createQuery("FROM Import").list();

		return list;
	}

	/**
	 * Tìm kiếm theo ID + Date + Name thông tin nhập kho
	 */
	@SuppressWarnings("unchecked")
	public List<Import> searchByImp(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Import> list = session.createQuery("FROM Import WHERE Import_Code Like '%" + search + "%'").list();
		return list;
	}

	/**
	 * Phân trang thông tin nhập kho
	 */
	@SuppressWarnings("unchecked")
	public List<Import> loadImpPage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Import");
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
	public int getRowImp() {
		Session session = sessionFactory.getCurrentSession();
		List<Import> list = session.createQuery("FROM Import").list();
		int i = 0;
		for (Import prod : list) {
			i++;
		}
		return i;
	}
}
