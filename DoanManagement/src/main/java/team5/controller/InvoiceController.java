package team5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team5.model.Invoice;
import team5.service.InvoiceService;

@Controller
@Transactional
@RequestMapping(value = "/admin/invoice/")
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("listInvoice", invoiceService.getListInvoice());
		if (invoiceService.getRowInvoice() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listInvoice", invoiceService.loadInvoicePage("1"));
			} else {
				model.addAttribute("listInvoice", invoiceService.loadInvoicePage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(invoiceService.getRowInvoice()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("listInvoice", invoiceService.getListInvoice());
		}
		return "invoice/index";
	}

	// Form sửa đơn hàng
	@RequestMapping(value = "edit-invoice/{invoice_Code}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable("invoice_Code") Integer invoice_Code) {
		model.put("invoice", invoiceService.getInvoice_Code(invoice_Code));
		model.put("listInvoice", invoiceService.getListInvoice());
		return "invoice/edit-invoice";
	}

	// Sửa đơn hàng
	@RequestMapping(value = "edit-invoice/{invoice_Code}.htm", method = RequestMethod.POST)
	public String editInvoice(ModelMap model, @PathVariable("invoice_Code") Integer invoice_Code,
			@ModelAttribute(value = "invoice") @Validated Invoice invoice, @RequestParam("nameu") String nameu) {
		invoiceService.editInvoice(invoice, nameu);
		model.put("listInvoice", invoiceService.getListInvoice());
		return "invoice/edit-invoice";
	}

	// Tìm kiếm đơn hàng
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String searchInvoice(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listInvoice", invoiceService.searchInvoice(search));
		return "invoice/index";
	}

	// Lọc đơn hàng
	@RequestMapping(value = "filter.htm", method = RequestMethod.GET)
	public String filterInvoice(ModelMap model, @RequestParam("filter") String filter) {
		model.addAttribute("listInvoice", invoiceService.filterStatus(filter));
		return "invoice/index";
	}

	// Xử lí trạng thái đơn hàng
	public String statusInvoice(ModelMap model, @PathVariable("invoice_Code") Integer invoice_Code,
			@PathVariable("value") String value, @ModelAttribute("invoice") Invoice invoice, @RequestParam("nameu") String nameu) {
		invoice = invoiceService.getInvoice_Code(invoice_Code);
		if (value.equals("Confirm")) {
			invoice.setStatus(3);
			invoiceService.editInvoice(invoice, nameu);
		}
		if (value.equals("Handling")) {
			invoice.setStatus(2);
			invoiceService.editInvoice(invoice, nameu);
		}
		if (value.equals("Cancel")) {
			invoice.setStatus(1);
			invoiceService.editInvoice(invoice, nameu);
		}
		return "redirect:/admin/invoice/";
	}
	
	// Show danh sách hoá đơn chi tiết
	@RequestMapping("detail-invoice/{invoice_Code}.htm")
	public String detailInvoice(ModelMap model, @PathVariable("invoice_Code") Integer invoice_Code) {
		Session session = sessionFactory.getCurrentSession();
		Invoice invoice = new Invoice();
		invoice.setInvoice_Code(invoice_Code);
		session.refresh(invoice);
		
		model.addAttribute("invoice", invoice);
		model.addAttribute("detail", invoiceService.getListDetailInvoiceByID(invoice_Code));
		
		return "invoice/detail-invoice";
	}
}
