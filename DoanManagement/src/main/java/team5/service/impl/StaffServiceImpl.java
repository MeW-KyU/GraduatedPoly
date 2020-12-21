package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.StaffDAO;
import team5.model.Staff;
import team5.service.StaffService;

@Service
public class StaffServiceImpl implements StaffService{

	@Autowired
	StaffDAO staffDAO;
	
	/**
	 * Gọi insert từ lớp DAO
	 */
	public void insertStaff(Staff staff,String nameu) {
		staffDAO.insertStaff(staff, nameu);
	}

	/**
	 * Gọi edit từ lớp DAO
	 */
	public void editStaff(Staff staff,String nameu) {
		staffDAO.editStaff(staff, nameu);
	}

	/**
	 * Gọi delete từ lớp DAO
	 */
	public void deleteStaff(Staff staff,String nameu) {
		staffDAO.deleteStaff(staff,nameu);
	}

	/**
	 * Lấy Code từ lớp DAO
	 */
	public Staff getStaff_Code(String staff_Code) {
		return staffDAO.getStaff_Code(staff_Code);
	}

	/**
	 * Kiểm tra Staff_Code
	 * 
	 * @param staff_Code
	 * @return
	 */
	public int checkIdStaff_Code(String staff_Code) {
		return staffDAO.checkIdStaff_Code(staff_Code);
	}

	/**
	 * Lấy List<Staff> từ lớp DAO
	 */
	public List<Staff> getListStaff() {
		return staffDAO.getListStaff();
	}

	/**
	 * Tìm kiếm nhân viên theo mã code và tên nhân viên
	 */
	public List<Staff> searchBySta(String search) {
		return staffDAO.searchBySta(search);
	}

	/**
	 * Phân trang cho nhân viên
	 */
	public List<Staff> loadStaPage(String page) {
		return staffDAO.loadStaPage(page);
	}

	public int getRowSta() {
		return staffDAO.getRowSta();
	}

}
