package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.ProductDAO;
import team5.model.Product;
import team5.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDAO productDAO;
	
	/**
	 * Gọi insert từ lớp DAO
	 */
	public void insertProduct(Product product,String nameu) {
		productDAO.insertProduct(product, nameu);
	}

	/**
	 * Gọi edit từ lớp DAO
	 */
	public void editProduct(Product product,String nameu) {
		productDAO.editProduct(product, nameu);
	}

	/**
	 * Gọi delete từ lớp DAO
	 */
	public void deleteProduct(Product product,String nameu) {
		productDAO.deleteProduct(product, nameu);
	}

	/**
	 * Lấy Code từ lớp DAO
	 */
	public Product getProduct_Code(String product_Code) {
		return productDAO.getProduct_Code(product_Code);
	}

	/**
	 * Kiểm tra Product_Code
	 * 
	 * @param product_Code
	 * @return
	 */
	public int checkIdProduct_Code(String product_Code) {
		return productDAO.checkIdProduct_Code(product_Code);
	}

	/**
	 * Lấy List<Product> từ lớp DAO
	 */
	public List<Product> getListProduct() {
		return productDAO.getListProduct();
	}

	/**
	 * Tìm kiếm sản phẩm theo mã code và tên sản phẩm
	 */
	public List<Product> searchByProd(String search) {
		return productDAO.searchByProd(search);
	}

	/**
	 * Phân trang cho sản phẩm
	 */
	public List<Product> loadProdPage(String page) {
		return productDAO.loadProdPage(page);
	}

	public int getRowProd() {
		return productDAO.getRowProd();
	}
}
