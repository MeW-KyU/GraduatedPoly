package team5.service;

import java.util.List;

import team5.model.Merchandise;

public interface MerchandiseService {

	/**
	 * Thêm hàng hoá
	 * 
	 * @param merchandise
	 */
	public void insertMerchandise(Merchandise merchandise,String nameu);
	
	/**
	 * Sửa hàng hoá
	 * 
	 * @param merchandise
	 */
	public void editMerchandise(Merchandise merchandise,String nameu);
	
	/**
	 * Xoá hàng hoá
	 * 
	 * @param merchandise
	 */
	public void deleteMerchandise(Merchandise merchandise,String nameu);
	
	/**
	 * Load Merchandise Code
	 * 
	 * @param merchandise
	 * @return
	 */
	public Merchandise getMerchandise_Code(String merchandise_Code);
	
	/**
	 * Kiểm tra mã hàng hoá đã tồn tại chưa
	 * 
	 * @param merchandise
	 * @return
	 */
	public int checkIdMerchandise_Code(String merchandise_Code);
	
	/**
	 * Load danh sách hàng hoá
	 * 
	 * @return
	 */
	public List<Merchandise> getListMerchandise();
	
	/**
	 * Tìm kiếm theo hàng hoá
	 * 
	 * @param search
	 * @return
	 */
	public List<Merchandise> searchByMer(String search);
	
	/**
	 * Phân trang hàng hoá
	 * 
	 * @param page
	 * @return
	 */
	public List<Merchandise> loadMerPage(String page);
	
	public int getRowMer();
}
