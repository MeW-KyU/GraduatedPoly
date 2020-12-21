package team5.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import team5.dao.ProductDAO;
import team5.model.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	/**
	 * Thêm sản phẩm
	 */
	public void insertProduct(Product product,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.save(product);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Insert Product',GETDATE(),'success')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Sửa sản phẩm
	 */
	public void editProduct(Product product,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.update(product);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Edit Product',GETDATE(),'warning')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Xóa sản phẩm
	 */
	public void deleteProduct(Product product,String nameu) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(product);
		String sql1 = "insert into History(name,nameAct,dayAct,typeAct) values('"+nameu+"',N'Delete Product',GETDATE(),'danger')";
		Query query = session.createSQLQuery(sql1);
		int result = query.executeUpdate();
		System.out.println(result);
	}

	/**
	 * Load Product Code
	 */
	public Product getProduct_Code(String product_Code) {
		Session session = sessionFactory.getCurrentSession();
		Product product = (Product) session.get(Product.class, product_Code);
		return product;
	}

	/**
	 * Kiểm tra mã sản phẩm đã tồn tại chưa
	 */
	@SuppressWarnings("unchecked")
	public int checkIdProduct_Code(String product_Code) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("FROM Product WHERE Product_Code = '" + product_Code + "'").list();
		return list.size();
	}

	/**
	 * Lấy danh sách sản phẩm
	 */
	@SuppressWarnings("unchecked")
	public List<Product> getListProduct() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("FROM Product").list();
		
		return list;
	}

	/**
	 * Tìm kiếm theo ID + Name sản phẩm
	 */
	@SuppressWarnings("unchecked")
	public List<Product> searchByProd(String search) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session
				.createQuery("FROM Product WHERE Product_Code Like '%" + search + "%' OR Name_Product LIKE '%" + search + "%'")
				.list();
		return list;
	}

	/**
	 * Phân trang sản phẩm
	 */
	@SuppressWarnings("unchecked")
	public List<Product> loadProdPage(String page) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("FROM Product");
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
	public int getRowProd() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = session.createQuery("FROM Product").list();
		int i = 0;
		for (Product prod : list) {
			i++;
		}
		return i;
	}
}
