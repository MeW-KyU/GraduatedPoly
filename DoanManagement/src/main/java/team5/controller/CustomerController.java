package team5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team5.model.Customer;
import team5.service.CustomerService;
import team5.validator.CustomerValidator;

@Transactional
@Controller
@RequestMapping(value = "/admin/customer/")
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("listCustomer", customerService.getListCustomer());
		if (customerService.getRowCus() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listCustomer", customerService.loadCusPage("1"));
			} else {
				model.addAttribute("listCustomer", customerService.loadCusPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(customerService.getRowCus()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("listCustomer", customerService.getListCustomer());
		}
		return "customer/index";
	}

	// Form thêm khách hàng
	@RequestMapping(value = "add-cus.htm", method = RequestMethod.GET)
	public String formAdd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomer", customerService.getListCustomer());
		if (customerService.getRowCus() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listCustomer", customerService.loadCusPage("1"));
			} else {
				model.addAttribute("listCustomer", customerService.loadCusPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(customerService.getRowCus()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("customer", new Customer());
			model.addAttribute("listCustomer", customerService.getListCustomer());
		}
		return "customer/add-cus";
	}

	// Form sửa khách hàng
	@RequestMapping(value = "edit-cus/{customer_Code}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable(value = "customer_Code") String customer_Code) {
		model.put("customer", customerService.getCustomer_Code(customer_Code));
		model.put("listCustomer", customerService.getListCustomer());
		return "customer/edit-cus";
	}

	// Lưu dữ liệu
	@RequestMapping(value = "save-cus.htm", method = RequestMethod.POST)
	public String saveCus(ModelMap model, @ModelAttribute(value = "customer") @Validated Customer customer,
			BindingResult result, @RequestParam("nameu") String nameu) {
		CustomerValidator cusVali = new CustomerValidator();
		cusVali.validate(customer, result);

		if (customer.getCustomer_Code() == null) {
			result.reject("customer_Code");
		} else if (customer.getCustomer_Code().indexOf(" ") > 0) {
			result.rejectValue("customer_Code", "customer", "Mã tài khoản khách hàng không được chứa khoảng trắng !");
		} else if (customerService.checkIdCustomer_Code(customer.getCustomer_Code()) > 0) {
			result.rejectValue("customer_Code", "customer", "Mã tài khoản khách hàng này đã tồn tại !");
		}

		if (result.hasErrors()) {
			model.addAttribute("listCustomer", customerService.getListCustomer());
			return "customer/add-cus";
		} else {
			customerService.insertCustomer(customer,nameu);

			model.addAttribute("listCustomer", customerService.getListCustomer());

		}
		return "redirect:/admin/customer/";
	}

	// Sửa dữ liệu
	@RequestMapping(value = "edit-cus/{customer_Code}.htm", method = RequestMethod.POST)
	public String editCus(ModelMap model, @PathVariable("customer_Code") String customer_Code,
			@ModelAttribute(value = "customer") @Validated Customer customer, BindingResult result, @RequestParam("nameu") String nameu) {
		CustomerValidator cusVali = new CustomerValidator();
		cusVali.validate(customer, result);

		if (result.hasErrors()) {
			model.addAttribute("listCustomer", customerService.getListCustomer());
			return "customer/edit-cus";
		} else {
			customerService.editCustomer(customer,nameu);
			model.addAttribute("listCustomer", customerService.getListCustomer());
		}
		return "redirect:/admin/customer/";
	}

	// Xóa dữ liệu
	@RequestMapping(value = "delete-cus/{customer_Code}/{nameu}.htm", method = RequestMethod.GET)
	public String deleteCus(ModelMap model, @PathVariable("customer_Code") String customer_Code,
			@ModelAttribute(value = "customer") Customer customer,  @PathVariable("nameu") String nameu) {
		customerService.deleteCustomer(customer,nameu);
		model.addAttribute("listCustomer", customerService.getListCustomer());
		return "redirect:/admin/customer/";
	}

	// Tìm kiếm khách hàng
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String searchCustomer(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listCustomer", customerService.searchByCus(search));
		return "customer/index";
	}

	// reset password
	@RequestMapping(value = "reset-cus/{customer_Code}/{nameu}.htm", method = RequestMethod.GET)
	public String formReset(ModelMap model, @PathVariable(value = "customer_Code") String customer_Code,
			@ModelAttribute(value = "customer") Customer customer, @PathVariable("nameu") String nameu) {
		customer = customerService.getCustomer_Code(customer_Code);
		customer.setPassword("123");
		customerService.editCustomer(customer,nameu);
		model.put("listCustomer", customerService.getListCustomer());
		return "customer/index";
	}
}
