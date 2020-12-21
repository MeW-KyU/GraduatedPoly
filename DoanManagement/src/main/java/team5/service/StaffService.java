package team5.service;

import java.util.List;

import team5.model.Staff;

public interface StaffService {

	/**
	 * Thêm nhân viên
	 * 
	 * @param staff
	 */
	public void insertStaff(Staff staff,String nameu);
	
	/**
	 * Sửa nhân viên
	 * 
	 * @param staff
	 */
	public void editStaff(Staff staff,String nameu);
	
	/**
	 * Xoá nhân viên
	 * 
	 * @param staff
	 */
	public void deleteStaff(Staff staff,String nameu);
	
	/**
	 * Load Staff Code
	 * 
	 * @param staff
	 * @return
	 */
	public Staff getStaff_Code(String staff_Code);
	
	/**
	 * Kiểm tra mã nhân viên đã tồn tại chưa
	 * 
	 * @param staff
	 * @return
	 */
	public int checkIdStaff_Code(String staff_Code);
	
	/**
	 * Load danh sách nhân viên
	 * 
	 * @return
	 */
	public List<Staff> getListStaff();
	
	/**
	 * Tìm kiếm theo nhân viên
	 * 
	 * @param search
	 * @return
	 */
	public List<Staff> searchBySta(String search);
	
	/**
	 * Phân trang nhân viên
	 * 
	 * @param page
	 * @return
	 */
	public List<Staff> loadStaPage(String page);
	
	public int getRowSta();
}
