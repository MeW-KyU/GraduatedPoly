package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.MerchandiseDAO;
import team5.model.Merchandise;
import team5.service.MerchandiseService;

@Service
public class MerchandiseServiceImpl implements MerchandiseService{

	@Autowired
	MerchandiseDAO merchandiseDAO;
	
	/**
	 * Gọi insert từ lớp DAO
	 */
	public void insertMerchandise(Merchandise merchandise,String nameu) {
		merchandiseDAO.insertMerchandise(merchandise, nameu);
	}

	/**
	 * Gọi edit từ lớp DAO
	 */
	public void editMerchandise(Merchandise merchandise,String nameu) {
		merchandiseDAO.editMerchandise(merchandise, nameu);
	}

	/**
	 * Gọi delete từ lớp DAO
	 */
	public void deleteMerchandise(Merchandise merchandise,String nameu) {
		merchandiseDAO.deleteMerchandise(merchandise, nameu);
	}

	/**
	 * Lấy Code từ lớp DAO
	 */
	public Merchandise getMerchandise_Code(String merchandise_Code) {
		return merchandiseDAO.getMerchandise_Code(merchandise_Code);
	}

	/**
	 * Kiểm tra Merchandise_Code
	 * 
	 * @param merchandise_Code
	 * @return
	 */
	public int checkIdMerchandise_Code(String merchandise_Code) {
		return merchandiseDAO.checkIdMerchandise_Code(merchandise_Code);
	}

	/**
	 * Lấy List<Merchandise> từ lớp DAO
	 */
	public List<Merchandise> getListMerchandise() {
		return merchandiseDAO.getListMerchandise();
	}

	/**
	 * Tìm kiếm hàng hoá theo mã code và tên hàng hoá
	 */
	public List<Merchandise> searchByMer(String search) {
		return merchandiseDAO.searchByMer(search);
	}

	/**
	 * Phân trang cho hàng hoá
	 */
	public List<Merchandise> loadMerPage(String page) {
		return merchandiseDAO.loadMerPage(page);
	}

	public int getRowMer() {
		return merchandiseDAO.getRowMer();
	}
}
