package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.DetailInvoiceDAO;
import team5.model.DetailInvoice;

@Repository
public class DetailInvoiceDAOImpl implements DetailInvoiceDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	/*
	 * Sửa hoá đơn chi tiết
	 * 
	 * @param invoice
	 */
	public void editDetailInvoice(DetailInvoice invoice,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(invoice);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Edit DetailInvoice',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}
	
	/*
	 * Xoá hoá đơn chi tiết
	 * 
	 * @param invoice
	 */
	public void deleteDetailInvoice(DetailInvoice invoice,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(invoice);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Delete DetailInvoice',GETDATE(),'danger')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}
	
	/*
	 * Lấy mã hoá đơn
	 * 
	 * @param id
	 * @return
	 */
	public DetailInvoice getIDDetailInvoice (Integer id) {
		Session session = sessionFactory.getCurrentSession();
		DetailInvoice invoice = (DetailInvoice) session.get(DetailInvoice.class, id);
		return invoice;
	}
	
	/*
	 * Lấy tất cả hoá đơn
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DetailInvoice> getListDetailInvoice() {
		Session session = sessionFactory.getCurrentSession();
		List<DetailInvoice> list = session.createQuery("FROM DetailInvoice").list();
		return list;
	}
	
	/*
	 * Tìm kiếm
	 * 
	 * @param search
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DetailInvoice> searchDetailInvoice(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<DetailInvoice> list = session.createQuery("FROM DetailInvoice WHERE Total LIKE '%" + search + "%'").list();
		return list;
	}
	
	/*
	 * Phân trang
	 * 
	 * @param page
	 * @return
	 */
	@SuppressWarnings({ "unused", "unchecked" })
	public List<DetailInvoice> loadDetailInvoicePage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM DetailInvoice");
		int result = 0;
		if (page.equals("1")) {
			result = 0;
		} else {
			String temp = String.valueOf(page) + "0";
			result = Integer.parseInt(temp);
		}
		query.setFirstResult(result);
		query.setMaxResults(10);
		return query.list();
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	public int getRowDetailInvoice() {
		Session session = sessionFactory.getCurrentSession();
		List<DetailInvoice> list = session.createQuery("FROM DetailInvoice").list();
		int i = 0;
		for (DetailInvoice invoice : list) {
			i++;
		}
		return i;
	}
}
