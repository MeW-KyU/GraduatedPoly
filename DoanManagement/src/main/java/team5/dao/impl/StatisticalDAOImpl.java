package team5.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.StatisticalDAO;
import team5.model.Account;
import team5.model.Customer;
import team5.model.Date_Yead;
import team5.model.History;
import team5.model.Invoice;
import team5.model.Merchandise;
import team5.model.Product;
import team5.model.Revenue;
import team5.model.Staff;
import team5.model.TopProduct;

@Repository
public class StatisticalDAOImpl implements StatisticalDAO {

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public int countAccount() {
		Session session = sessionFactory.openSession();
		List<Account> list = session.createQuery("FROM Account").list();
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public int countCustomer() {
		Session session = sessionFactory.openSession();
		List<Customer> list = session.createQuery("FROM Customer").list();
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public int countStaff() {
		Session session = sessionFactory.openSession();
		List<Staff> list = session.createQuery("FROM Staff").list();
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public int countProduct() {
		Session session = sessionFactory.openSession();
		List<Product> list = session.createQuery("FROM Product").list();
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public int countMerchandise() {
		Session session = sessionFactory.openSession();
		List<Merchandise> list = session.createQuery("FROM Merchandise").list();
		return list.size();
	}
	
	@SuppressWarnings("unchecked")
	public int countInvoice() {
		Session session = sessionFactory.openSession();
		List<Invoice> list = session.createQuery("FROM Invoice").list();
		return list.size();
	}

	@SuppressWarnings("unchecked")
	public List<Date_Yead> listYears() {
		Session session = sessionFactory.openSession();
		String sql = "DELETE FROM Date_Yead";
		Query query = session.createSQLQuery(sql);
		int result = query.executeUpdate();
		String sql1 = "INSERT INTO Date_Yead(yead) SELECT year(Date_sale) FROM Invoice group by YEAR(Date_sale)";
		Query query1 = session.createSQLQuery(sql1);
		int result1 = query1.executeUpdate();
		List<Date_Yead> list = session.createQuery("FROM Date_Yead group by yead order by yead DESC").list();
		System.out.println(result+result1);
		return list;
	}

	public List<List<Map<Object, Object>>> getCanvasjsChartDataHD(String yearSale) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "DELETE FROM Revenue";
		Query query = session.createSQLQuery(sql);
		int result = query.executeUpdate();
		String sql1 = "INSERT INTO Revenue(Total, Month_sale, Year_sale) SELECT sum(Total),MONTH(Date_sale),YEAR(Date_sale) FROM Invoice group by YEAR(Date_sale) ,MONTH(Date_sale)";
		Query query1 = session.createSQLQuery(sql1);
		int result1 = query1.executeUpdate();
		System.out.println(result+result1);
		Map<Object, Object> map = null;
		List<List<Map<Object, Object>>> list = new ArrayList<List<Map<Object, Object>>>();
		List<Map<Object, Object>> dataPoints1 = new ArrayList<Map<Object, Object>>();
		for (int i = 1; i < 13; i++) {
			List<Revenue> listRevenue = session
					.createQuery("FROM Revenue where Month_sale= :monthSale and Year_sale= :yearSale")
					.setParameter("monthSale", i).setParameter("yearSale", yearSale).list();
			map = new HashMap<Object, Object>();
			if (listRevenue.size() == 0) {
				map.put("x", i);
				map.put("y", 0);
				dataPoints1.add(map);
			} else {
				for (int count = 0; count < listRevenue.size(); count++) {
					map.put("x", i);
					map.put("y", listRevenue.get(count).getTotal());
					dataPoints1.add(map);
				}
			}
		}
		list.add(dataPoints1);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<TopProduct> idTop() {
		Session session = sessionFactory.openSession();
		String sql = "DELETE FROM TopProduct";
		Query query = session.createSQLQuery(sql);
		int result = query.executeUpdate();
		String sql1 = "INSERT INTO TopProduct(amount,product_Code) SELECT sum(di.amount), p.product_Code FROM DetailInvoice di, Product p where di.product_Code=p.product_Code group by p.product_Code order by COUNT(p.product_Code)";
		Query query1 = session.createSQLQuery(sql1);
		int result1 = query1.executeUpdate(); 
		System.out.println(result+result1);
		List<TopProduct> list = session.createQuery("FROM TopProduct order by Amount desc ").setMaxResults(3).list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<History> listHistory() {
		Session session = sessionFactory.openSession();
		List<History> list = session.createQuery("FROM History order by dayAct desc").list();
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List<History> loadHisPage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM History order by dayAct desc");
		int result = 0;
		if (page.equals("1")) {
			result = 0;
		} else {
			String temp = String.valueOf(page) + "0";
			result = Integer.parseInt(temp) - 5;
		}
		query.setFirstResult(result);
		query.setMaxResults(5);
		return query.list();
	}

	@SuppressWarnings({ "unchecked", "unused" })
	public int getRowHis() {
		Session session = sessionFactory.getCurrentSession();
		List<History> list = session.createQuery("FROM History order by dayAct desc").list();
		int i = 0;
		for (History his : list) {
			i++;
		}
		return i;
	}

}
