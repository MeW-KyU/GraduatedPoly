package team5.dao;

import java.util.List;

import team5.model.Export;

public interface ExportDAO {

	// ==> Quản lí thông tin xuất kho

	/**
	 * Thêm thông tin xuất kho
	 * 
	 * @param export
	 */
	public void insertExport(Export export,String nameu);

	/**
	 * Sửa thông tin xuất kho
	 * 
	 * @param export
	 */
	public void editExport(Export export,String nameu);

	/**
	 * Xóa thông tin xuất kho
	 * 
	 * @param export
	 */
	public void deleteExport(Export export,String nameu);

	/**
	 * Load Export Code
	 * 
	 * @param export
	 * @return
	 */
	public Export getExport_Code(Integer export_Code);

	/**
	 * Lấy danh sách thông tin xuất kho
	 * 
	 * @return
	 */
	public List<Export> getListExport();

	/**
	 * Tìm kiếm theo thông tin xuất kho
	 * 
	 * @param search
	 * @return
	 */
	public List<Export> searchByExp(String search);

	/**
	 * Phân trang thông tin xuất kho
	 * 
	 * @param page
	 * @return
	 */
	public List<Export> loadExpPage(String page);

	public int getRowExp();
}
