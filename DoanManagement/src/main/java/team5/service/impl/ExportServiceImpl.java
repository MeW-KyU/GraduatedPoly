package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.ExportDAO;
import team5.model.Export;
import team5.service.ExportService;

@Service
public class ExportServiceImpl implements ExportService{

	@Autowired
	ExportDAO exportDAO;
	
	/**
	 * Gọi insert từ lớp DAO
	 */
	public void insertExport(Export export,String nameu) {
		exportDAO.insertExport(export,nameu);
	}

	/**
	 * Gọi edit từ lớp DAO
	 */
	public void editExport(Export export,String nameu) {
		exportDAO.editExport(export,nameu);
	}

	/**
	 * Gọi delete từ lớp DAO
	 */
	public void deleteExport(Export export,String nameu) {
		exportDAO.deleteExport(export,nameu);
	}

	/**
	 * Lấy Code từ lớp DAO
	 */
	public Export getExport_Code(Integer export_Code) {
		return exportDAO.getExport_Code(export_Code);
	}

	/**
	 * Lấy List<Export> từ lớp DAO
	 */
	public List<Export> getListExport() {
		return exportDAO.getListExport();
	}

	/**
	 * Tìm kiếm thông tin xuất kho theo mã code, ngày xuất và tên thông tin xuất kho
	 */
	public List<Export> searchByExp(String search) {
		return exportDAO.searchByExp(search);
	}

	/**
	 * Phân trang cho thông tin xuất kho
	 */
	public List<Export> loadExpPage(String page) {
		return exportDAO.loadExpPage(page);
	}

	public int getRowExp() {
		return exportDAO.getRowExp();
	}
	
}
