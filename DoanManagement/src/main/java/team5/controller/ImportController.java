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

import team5.model.Import;
import team5.model.Merchandise;
import team5.service.ImportService;
import team5.validator.ImportValidator;

@Transactional
@Controller
@RequestMapping(value = "/admin/import/")
public class ImportController {

	@Autowired
	ImportService importService;
	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("listImport", importService.getListImport());
		if (importService.getRowImp() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listImport", importService.loadImpPage("1"));
			} else {
				model.addAttribute("listImport", importService.loadImpPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(importService.getRowImp()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("listImport", importService.getListImport());
		}
		return "import/index";
	}

	// Form thêm thông tin nhập kho
	@RequestMapping(value = "add-imp.htm", method = RequestMethod.GET)
	public String formAdd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("import", new Import());
		model.addAttribute("listImport", importService.getListImport());

		if (importService.getRowImp() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listImport", importService.loadImpPage("1"));
			} else {
				model.addAttribute("listImport", importService.loadImpPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(importService.getRowImp()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("import", new Import());
			model.addAttribute("listImport", importService.getListImport());
		}
		return "import/add-imp";
	}

	// Form sửa thông tin nhập kho
	@RequestMapping(value = "edit-imp/{import_Code}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable("import_Code") Integer import_Code) {
		model.put("import", importService.getImport_Code(import_Code));
		model.put("listImport", importService.getListImport());
		return "import/edit-imp";
	}

	// Lưu dữ liệu
	@RequestMapping(value = "save-imp.htm", method = RequestMethod.POST)
	public String saveImp(ModelMap model, @ModelAttribute(value = "import") @Validated Import importt,
			BindingResult result, @RequestParam("nameu") String nameu) {
		ImportValidator impVali = new ImportValidator();
		impVali.validate(importt, result);

		if (result.hasErrors()) {
			model.addAttribute("listImport", importService.getListImport());
			return "import/add-imp";
		} else {
			importt.setTotal(importt.getAmount() * importt.getUnit_Price());
			importService.insertImport(importt, nameu);
			model.addAttribute("listImport", importService.getListImport());
		}

		return "redirect:/admin/import/";
	}

	// Sửa dữ liệu
	@RequestMapping(value = "edit-imp/{import_Code}.htm", method = RequestMethod.POST)
	public String editImp(ModelMap model, @PathVariable("import_Code") Integer import_Code,
			@ModelAttribute(value = "import") @Validated Import importt, BindingResult result, @RequestParam("nameu") String nameu) {
		ImportValidator impVali = new ImportValidator();
		impVali.validate(importt, result);
		
		if (result.hasErrors()) {
			model.addAttribute("listImport", importService.getListImport());
			return "import/edit-imp";
		} else {
			importt.setTotal(importt.getAmount() * importt.getUnit_Price());
			importService.editImport(importt, nameu);
			model.addAttribute("listImport", importService.getListImport());
		}

		return "redirect:/admin/import/";
	}

	// Xóa dữ liệu
	@RequestMapping(value = "delete-imp/{import_Code}/{nameu}.htm", method = RequestMethod.GET)
	public String deleteImp(ModelMap model, @PathVariable("import_Code") Integer import_Code,
			@ModelAttribute(value = "import") Import importt,  @PathVariable("nameu") String nameu) {
		importService.deleteImport(importt, nameu);
		model.addAttribute("listImport", importService.getListImport());
		return "redirect:/admin/import/";
	}

	// Tìm kiếm thông tin nhập kho
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String searchMerchandise(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listImport", importService.searchByImp(search));
		return "import/index";
	}

	@SuppressWarnings("unchecked")
	@ModelAttribute("merchandise")
	public List<Merchandise> getMerchandise() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Merchandise").list();
	}
}
