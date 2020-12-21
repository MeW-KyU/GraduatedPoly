package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.MerchandiseDAO;
import team5.model.Merchandise;

@Repository
public class MerchandiseDAOImpl implements MerchandiseDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Thêm hàng hoá
	 */
	public void insertMerchandise(Merchandise merchandise,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(merchandise);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Merchandise',GETDATE(),'success')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Sửa hàng hoá
	 */
	public void editMerchandise(Merchandise merchandise,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(merchandise);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Edit Merchandise',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Xoá hàng hoá
	 */
	public void deleteMerchandise(Merchandise merchandise,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(merchandise);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Delete Merchandise',GETDATE(),'danger')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Load Merchandise Code
	 */
	public Merchandise getMerchandise_Code(String merchandise_Code) {
		Session session = sessionFactory.getCurrentSession();
		Merchandise merchandise = (Merchandise) session.get(Merchandise.class, merchandise_Code);
		return merchandise;
	}

	/**
	 * Kiểm tra mã hàng hoá đã tồn tại chưa
	 */
	@SuppressWarnings("unchecked")
	public int checkIdMerchandise_Code(String merchandise_Code) {
		Session session = sessionFactory.getCurrentSession();		
		List<Merchandise> list = session.createQuery("FROM Merchandise WHERE Merchandise_Code = '" + merchandise_Code + "'").list();
		return list.size();
	}

	/**
	 * Load danh sách hàng hoá
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> getListMerchandise() {
		Session session = sessionFactory.getCurrentSession();
		List<Merchandise> list = session.createQuery("FROM Merchandise").list();
		return list;
	}

	/**
	 * Tìm kiếm theo hàng hoá
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> searchByMer(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Merchandise> list = session
				.createQuery("FROM Merchandise WHERE Merchandise_Code Like '%" + search + "%' OR Name_Merchandise LIKE '%" + search + "%'")
				.list();
		return list;
	}
	
	/**
	 * Phân trang hàng hoá
	 */
	@SuppressWarnings("unchecked")
	public List<Merchandise> loadMerPage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Merchandise");
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
	public int getRowMer() {
		Session session = sessionFactory.getCurrentSession();
		List<Merchandise> list = session.createQuery("FROM Merchandise").list();
		int i = 0;
		for (Merchandise mer : list) {
			i++;
		}
		return i;
	}
}
