package team5.dao;

import java.util.List;

import team5.model.Product;

public interface ProductDAO {

	// ==> Quản lí sản phẩm
	
	/**
	 * Thêm sản phẩm
	 * 
	 * @param product
	 */
	public void insertProduct(Product product,String nameu);

	
	/**
	 * Sửa sản phẩm
	 * 
	 * @param product
	 */
	public void editProduct(Product product,String nameu);

	/**
	 * Xóa sản phẩm
	 * 
	 * @param product
	 */
	public void deleteProduct(Product product,String nameu);

	/**
	 * Load Product Code
	 * 
	 * @param product
	 * @return
	 */
	public Product getProduct_Code(String product_Code);

	/**
	 * Kiểm tra mã sản phẩm đã tồn tại chưa
	 * 
	 * @param product
	 * @return
	 */
	public int checkIdProduct_Code(String product_Code);

	/**
	 * Lấy danh sách sản phẩm
	 * 
	 * @return
	 */
	public List<Product> getListProduct();

	/**
	 * Tìm kiếm theo sản phẩm
	 * 
	 * @param search
	 * @return
	 */
	public List<Product> searchByProd(String search);

	/**
	 * Phân trang sản phẩm
	 * 
	 * @param page
	 * @return
	 */
	public List<Product> loadProdPage(String page);
	
	public int getRowProd();

}
