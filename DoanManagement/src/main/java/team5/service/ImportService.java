package team5.service;

import java.util.List;

import team5.model.Import;

public interface ImportService {

	/**
	 * Thêm thông tin nhập kho
	 * 
	 * @param importt
	 */
	public void insertImport(Import importt,String nameu);

	/**
	 * Sửa thông tin nhập kho
	 * 
	 * @param importt
	 */
	public void editImport(Import importt,String nameu);

	/**
	 * Xóa thông tin nhập kho
	 * 
	 * @param importt
	 */
	public void deleteImport(Import importt,String nameu);

	/**
	 * Load Import Code
	 * 
	 * @param importt
	 * @return
	 */
	public Import getImport_Code(Integer import_Code);

	/**
	 * Lấy danh sách thông tin nhập kho
	 * 
	 * @return
	 */
	public List<Import> getListImport();

	/**
	 * Tìm kiếm theo thông tin nhập kho
	 * 
	 * @param search
	 * @return
	 */
	public List<Import> searchByImp(String search);

	/**
	 * Phân trang thông tin nhập kho
	 * 
	 * @param page
	 * @return
	 */
	public List<Import> loadImpPage(String page);

	public int getRowImp();
}
