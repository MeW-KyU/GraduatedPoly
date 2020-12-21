package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.InvoiceDAO;
import team5.model.DetailInvoice;
import team5.model.Invoice;

@Repository
public class InvoiceDAOImpl implements InvoiceDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	/*
	 * Sửa đơn hàng
	 * 
	 * @param invoice
	 */
	public void editInvoice(Invoice invoice,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(invoice);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Edit Invoice',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}
	
	/*
	 * Lấy ID
	 * 
	 * @param id
	 * @return
	 */
	public Invoice getInvoice_Code(Integer invoice_Code) {
		Session session = sessionFactory.getCurrentSession();
		Invoice invoice = (Invoice) session.get(Invoice.class, invoice_Code);
		return invoice;
	}
	
	/*
	 * Lấy tất cả các danh sách hoá đơn
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Invoice> getListInvoice() {
		Session session = sessionFactory.getCurrentSession();
		List<Invoice> list = session.createQuery("FROM Invoice").list();
		return list;
	}
	
	/*
	 * Tìm kiếm
	 * 
	 * @param search
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Invoice> searchInvoice(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Invoice> list = session.createQuery("FROM Invoice WHERE Invoice_Code LIKE '%" + search + "%'").list();
		return list;
	}
	
	/*
	 * Lọc trạng thái
	 * 
	 * @param filter
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Invoice> filterStatus(String filter) {
		Session session = sessionFactory.getCurrentSession();
		List<Invoice> list = session.createQuery("FROM Invoice WHERE Status LIKE '%" + filter + "%'").list();
		return list;
	}
	
	/*
	 * Phân trang
	 * 
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Invoice> loadInvoicePage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Invoice");
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
	
	@SuppressWarnings({ "unused", "unchecked" })
	public int getRowInvoice() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Invoice");
		List<Invoice> list = session.createQuery("FROM Invoice").list();
		int i = 0;
		for (Invoice invoice : list) {
			i++;
		}
		return i;
	}
	
	/*
	 * Lấy danh sách đơn hàng chi tiết thông qua id đơn hàng
	 * 
	 * @param invoice_Code
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<DetailInvoice> getListDetailInvoiceByID(Integer invoice_Code) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM DetailInvoice WHERE invoice.invoice_Code = '" + invoice_Code + "'");
		return query.list();
	}
}
