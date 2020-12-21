package team5.dao;

import java.util.List;

import team5.model.Invoice;
import team5.model.DetailInvoice;

public interface InvoiceDAO {

	// ==> Quản lí hoá đơn
	
	/*
	 * Sửa đơn hàng
	 * 
	 * @param invoice
	 */
	public void editInvoice(Invoice invoice,String nameu);
	
	/*
	 * Lấy ID
	 * 
	 * @param id
	 * @return
	 */
	public Invoice getInvoice_Code(Integer invoice_Code);
	
	/*
	 * Lấy tất cả các danh sách hoá đơn
	 * 
	 * @return
	 */
	public List<Invoice> getListInvoice();
	
	/*
	 * Tìm kiếm
	 * 
	 * @param search
	 * @return
	 */
	public List<Invoice> searchInvoice(String search);
	
	/*
	 * Lọc trạng thái
	 * 
	 * @param filter
	 * @return
	 */
	public List<Invoice> filterStatus(String filter);
	
	/*
	 * Phân trang
	 * 
	 * @param page
	 * @return
	 */
	public List<Invoice> loadInvoicePage(String page);
	
	public int getRowInvoice();
	
	/*
	 * Lấy danh sách đơn hàng chi tiết thông qua id đơn hàng
	 * 
	 * @param id
	 * @return
	 */
	public List<DetailInvoice> getListDetailInvoiceByID(Integer invoice_Code);
}
