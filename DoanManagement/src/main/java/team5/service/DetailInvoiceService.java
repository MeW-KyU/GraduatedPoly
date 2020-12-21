package team5.service;

import java.util.List;

import team5.model.DetailInvoice;

public interface DetailInvoiceService {

	/*
	 * Sửa hoá đơn chi tiết
	 * 
	 * @param invoice
	 */
	public void editDetailInvoice(DetailInvoice detailInvoice,String nameu);

	/*
	 * Xoá hoá đơn chi tiết
	 * 
	 * @param invoice
	 */
	public void deleteDetailInvoice(DetailInvoice detailInvoice,String nameu);

	/*
	 * Lấy mã hoá đơn
	 * 
	 * @param id
	 * 
	 * @return
	 */
	public DetailInvoice getIDDetailInvoice(Integer id);

	/*
	 * Lấy tất cả hoá đơn
	 * 
	 * @return
	 */
	public List<DetailInvoice> getListDetailInvoice();

	/*
	 * Tìm kiếm
	 * 
	 * @param search
	 * 
	 * @return
	 */
	public List<DetailInvoice> searchDetailInvoice(String search);

	/*
	 * Phân trang
	 * 
	 * @param page
	 * 
	 * @return
	 */
	public List<DetailInvoice> loadDetailInvoicePage(String page);

	public int getRowDetailInvoice();
}
