package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.ExportDAO;
import team5.model.Export;

@Repository
public class ExportDAOImpl implements ExportDAO {

	@Autowired
	SessionFactory sessionFactory;

	/**
	 * Thêm thông tin xuất kho
	 */
	public void insertExport(Export export,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(export);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Export',GETDATE(),'success')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Sửa thông tin xuất kho
	 */
	public void editExport(Export export,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(export);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Export',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Xóa thông tin xuất kho
	 */
	public void deleteExport(Export export,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(export);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Export',GETDATE(),'danger')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Load Export Code
	 */
	public Export getExport_Code(Integer export_Code) {
		Session session = sessionFactory.getCurrentSession();
		Export export = (Export) session.get(Export.class, export_Code);
		return export;
	}

	/**
	 * Lấy danh sách thông tin xuất kho
	 */
	@SuppressWarnings("unchecked")
	public List<Export> getListExport() {
		Session session = sessionFactory.getCurrentSession();
		List<Export> list = session.createQuery("FROM Export").list();

		return list;
	}

	/**
	 * Tìm kiếm theo ID + Date + Name thông tin xuất kho
	 */
	@SuppressWarnings("unchecked")
	public List<Export> searchByExp(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Export> list = session.createQuery("FROM Export WHERE Export_Code Like '%" + search + "%'").list();
		return list;
	}

	/**
	 * Phân trang thông tin xuất kho
	 */
	@SuppressWarnings("unchecked")
	public List<Export> loadExpPage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Export");
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
	public int getRowExp() {
		Session session = sessionFactory.getCurrentSession();
		List<Export> list = session.createQuery("FROM Export").list();
		int i = 0;
		for (Export prod : list) {
			i++;
		}
		return i;
	}
}
