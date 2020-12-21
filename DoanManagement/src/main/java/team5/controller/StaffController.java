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

import team5.model.Staff;
import team5.service.StaffService;
import team5.validator.StaffValidator;

@Transactional
@Controller
@RequestMapping(value = "/admin/staff/")
public class StaffController {

	@Autowired
	StaffService staffService;
	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("listStaff", staffService.getListStaff());
		if (staffService.getRowSta() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listStaff", staffService.loadStaPage("1"));
			} else {
				model.addAttribute("listStaff", staffService.loadStaPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(staffService.getRowSta()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("listStaff", staffService.getListStaff());
		}
		return "staff/index";
	}

	// Form thêm nhân viên
	@RequestMapping(value = "add-sta.htm", method = RequestMethod.GET)
	public String formAdd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("staff", new Staff());
		model.addAttribute("listStaff", staffService.getListStaff());
		if (staffService.getRowSta() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listStaff", staffService.loadStaPage("1"));
			} else {
				model.addAttribute("listStaff", staffService.loadStaPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(staffService.getRowSta()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("staff", new Staff());
			model.addAttribute("listStaff", staffService.getListStaff());
		}
		return "staff/add-sta";
	}

	// Form sửa nhân viên
	@RequestMapping(value = "edit-sta/{staff_Code}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable(value = "staff_Code") String staff_Code) {
		model.put("staff", staffService.getStaff_Code(staff_Code));
		model.put("listStaff", staffService.getListStaff());
		return "staff/edit-sta";
	}

	// Lưu dữ liệu
	@RequestMapping(value = "save-sta.htm", method = RequestMethod.POST)
	public String saveSta(ModelMap model, @ModelAttribute(value = "staff") @Validated Staff staff,
			BindingResult result, @RequestParam("nameu") String nameu) {
		
		
		StaffValidator staVali = new StaffValidator();
		staVali.validate(staff, result);

		if (staff.getStaff_Code() == null) {
			result.reject("staff_Code");
		} else if (staff.getStaff_Code().indexOf(" ") > 0) {
			result.rejectValue("staff_Code", "staff", "Mã tài khoản nhân viên không được chứa khoảng trắng !");
		} else if (staffService.checkIdStaff_Code(staff.getStaff_Code()) > 0) {
			result.rejectValue("staff_Code", "staff", "Mã tài khoản nhân viên này đã tồn tại !");
		}

		if (result.hasErrors()) {
			model.addAttribute("listStaff", staffService.getListStaff());
			return "staff/add-sta";
		} else {
			staffService.insertStaff(staff,nameu);
			model.addAttribute("listStaff", staffService.getListStaff());
		}
		return "redirect:/admin/staff/";
	}

	// Sửa dữ liệu
	@RequestMapping(value = "edit-sta/{staff_Code}.htm", method = RequestMethod.POST)
	public String editSta(ModelMap model, @PathVariable("staff_Code") String staff_Code,
			@ModelAttribute(value = "staff") @Validated Staff staff, BindingResult result
			, @RequestParam("nameu") String nameu) {
		StaffValidator staVali = new StaffValidator();
		staVali.validate(staff, result);

		if (result.hasErrors()) {
			model.addAttribute("listStaff", staffService.getListStaff());
			return "staff/edit-sta";
		} else {
			staffService.editStaff(staff,nameu);
			model.addAttribute("listStaff", staffService.getListStaff());
		}
		return "redirect:/admin/staff/";
	}

	// Xóa dữ liệu
	@RequestMapping(value = "delete-sta/{staff_Code}/{nameu}.htm", method = RequestMethod.GET)
	public String deleteSta(ModelMap model, @PathVariable("staff_Code") String staff_Code,
			@ModelAttribute(value = "staff") Staff staff,  @PathVariable("nameu") String nameu) {
		staffService.deleteStaff(staff, nameu);
		model.addAttribute("listStaff", staffService.getListStaff());
		return "redirect:/admin/staff/";
	}

	// Tìm kiếm nhân viên
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String searchStaff(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listStaff", staffService.searchBySta(search));
		return "staff/index";
	}

}
