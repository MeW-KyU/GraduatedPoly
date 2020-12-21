package team5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.InvoiceDAO;
import team5.model.DetailInvoice;
import team5.model.Invoice;
import team5.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{

	@Autowired
	InvoiceDAO invoiceDAO;
	
	/*
	 * Sửa đơn hàng
	 * 
	 * @param invoice
	 */
	public void editInvoice(Invoice invoice,String nameu) {
		invoiceDAO.editInvoice(invoice, nameu);
	}
	
	/*
	 * Lấy ID
	 * 
	 * @param id
	 * @return
	 */
	public Invoice getInvoice_Code(Integer invoice_Code) {
		return invoiceDAO.getInvoice_Code(invoice_Code);
	}
	
	/*
	 * Lấy tất cả các danh sách hoá đơn
	 * 
	 * @return
	 */
	public List<Invoice> getListInvoice() {
		return invoiceDAO.getListInvoice();
	}
	
	/*
	 * Tìm kiếm
	 * 
	 * @param search
	 * @return
	 */
	public List<Invoice> searchInvoice(String search) {
		return invoiceDAO.searchInvoice(search);
	}
	
	/*
	 * Lọc trạng thái
	 * 
	 * @param filter
	 * @return
	 */
	public List<Invoice> filterStatus(String filter) {
		return invoiceDAO.filterStatus(filter);
	}
	
	/*
	 * Phân trang
	 * 
	 * @param page
	 * @return
	 */
	public List<Invoice> loadInvoicePage(String page) {
		return invoiceDAO.loadInvoicePage(page);
	}
	
	public int getRowInvoice() {
		return invoiceDAO.getRowInvoice();
	}
	
	/*
	 * Lấy danh sách đơn hàng chi tiết thông qua id đơn hàng
	 * 
	 * @param invoice_Code
	 * @return
	 */
	public List<DetailInvoice> getListDetailInvoiceByID(Integer invoice_Code) {
		return invoiceDAO.getListDetailInvoiceByID(invoice_Code);
	}
}
