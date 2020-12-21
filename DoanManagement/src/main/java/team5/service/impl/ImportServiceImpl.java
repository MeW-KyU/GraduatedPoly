package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.ImportDAO;
import team5.model.Import;
import team5.service.ImportService;

@Service
public class ImportServiceImpl implements ImportService{

	@Autowired
	ImportDAO importDAO;
	
	/**
	 * Gọi insert từ lớp DAO
	 */
	public void insertImport(Import importt,String nameu) {
		importDAO.insertImport(importt,nameu);
	}

	/**
	 * Gọi edit từ lớp DAO
	 */
	public void editImport(Import importt,String nameu) {
		importDAO.editImport(importt,nameu);
	}

	/**
	 * Gọi delete từ lớp DAO
	 */
	public void deleteImport(Import importt,String nameu) {
		importDAO.deleteImport(importt,nameu);
	}

	/**
	 * Lấy Code từ lớp DAO
	 */
	public Import getImport_Code(Integer import_Code) {
		return importDAO.getImport_Code(import_Code);
	}

	/**
	 * Lấy List<Import> từ lớp DAO
	 */
	public List<Import> getListImport() {
		return importDAO.getListImport();
	}

	/**
	 * Tìm kiếm thông tin nhập kho theo mã code, ngày nhập và tên thông tin nhập kho
	 */
	public List<Import> searchByImp(String search) {
		return importDAO.searchByImp(search);
	}

	/**
	 * Phân trang cho thông tin nhập kho
	 */
	public List<Import> loadImpPage(String page) {
		return importDAO.loadImpPage(page);
	}

	public int getRowImp() {
		return importDAO.getRowImp();
	}
}
