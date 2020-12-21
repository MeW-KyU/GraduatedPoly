package team5.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team5.model.Export;
import team5.model.Merchandise;
import team5.service.ExportService;
import team5.validator.ExportValidator;

@Transactional
@Controller
@RequestMapping(value = "/admin/export/")
public class ExportController {

	@Autowired
	ExportService exportService;
	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("listExport", exportService.getListExport());
		if (exportService.getRowExp() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listExport", exportService.loadExpPage("1"));
			} else {
				model.addAttribute("listExport", exportService.loadExpPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(exportService.getRowExp()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("listExport", exportService.getListExport());
		}
		return "export/index";
	}

	// Form thêm thông tin xuất kho
	@RequestMapping(value = "add-exp.htm", method = RequestMethod.GET)
	public String formAdd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("export", new Export());
		model.addAttribute("listExport", exportService.getListExport());

		if (exportService.getRowExp() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listExport", exportService.loadExpPage("1"));
			} else {
				model.addAttribute("listExport", exportService.loadExpPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(exportService.getRowExp()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("export", new Export());
			model.addAttribute("listExport", exportService.getListExport());
		}
		return "export/add-exp";
	}

	// Form sửa thông tin xuất kho
	@RequestMapping(value = "edit-exp/{export_Code}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable("export_Code") Integer export_Code) {
		model.put("export", exportService.getExport_Code(export_Code));
		model.put("listExport", exportService.getListExport());
		return "export/edit-exp";
	}

	// Lưu dữ liệu
	@RequestMapping(value = "save-exp.htm", method = RequestMethod.POST)
	public String saveExp(ModelMap model, @ModelAttribute(value = "export") @Validated Export export,
			BindingResult result, @RequestParam("nameu") String nameu) {
		ExportValidator expVali = new ExportValidator();
		expVali.validate(export, result);

		if (result.hasErrors()) {
			model.addAttribute("listExport", exportService.getListExport());
			return "export/add-exp";
		} else {
			exportService.insertExport(export, nameu);
			model.addAttribute("listExport", exportService.getListExport());
		}

		return "redirect:/admin/export/";
	}

	// Sửa dữ liệu
	@RequestMapping(value = "edit-exp/{export_Code}.htm", method = RequestMethod.POST)
	public String editExp(ModelMap model, @PathVariable("export_Code") Integer export_Code,
			@ModelAttribute(value = "export") @Validated Export export, BindingResult result,
			@RequestParam("nameu") String nameu) {
		ExportValidator expVali = new ExportValidator();
		expVali.validate(export, result);

		if (result.hasErrors()) {
			model.addAttribute("listExport", exportService.getListExport());
			return "export/edit-exp";
		} else {
			exportService.editExport(export, nameu);
			model.addAttribute("listExport", exportService.getListExport());
		}

		return "redirect:/admin/export/";
	}

	// Xóa dữ liệu
	@RequestMapping(value = "delete-exp/{export_Code}/{nameu}.htm", method = RequestMethod.GET)
	public String deleteExp(ModelMap model, @PathVariable("export_Code") Integer export_Code,
			@ModelAttribute(value = "export") Export export, @PathVariable("nameu") String nameu) {
		exportService.deleteExport(export, nameu);
		model.addAttribute("listExport", exportService.getListExport());
		return "redirect:/admin/export/";
	}

	// Tìm kiếm thông tin xuất kho
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String searchMerchandise(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listExport", exportService.searchByExp(search));
		return "export/index";
	}

	@SuppressWarnings("unchecked")
	@ModelAttribute("merchandise")
	public List<Merchandise> getMerchandise() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Merchandise").list();
	}
}
