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

import team5.model.Merchandise;
import team5.service.MerchandiseService;
import team5.validator.MerchandiseValidator;

@Transactional
@Controller
@RequestMapping(value = "/admin/merchandise/")
public class MerchandiseController {

	@Autowired
	MerchandiseService merchandiseService;
	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
		if (merchandiseService.getRowMer() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listMerchandise", merchandiseService.loadMerPage("1"));
			} else {
				model.addAttribute("listMerchandise", merchandiseService.loadMerPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(merchandiseService.getRowMer()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
		}
		return "merchandise/index";
	}

	// Form thêm hàng hoá
	@RequestMapping(value = "add-mer.htm", method = RequestMethod.GET)
	public String formAdd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("merchandise", new Merchandise());
		model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
		if (merchandiseService.getRowMer() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listMerchandise", merchandiseService.loadMerPage("1"));
			} else {
				model.addAttribute("listMerchandise", merchandiseService.loadMerPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(merchandiseService.getRowMer()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("merchandise", new Merchandise());
			model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
		}
		return "merchandise/add-mer";
	}

	// Form sửa hàng hoá
	@RequestMapping(value = "edit-mer/{merchandise_Code}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable(value = "merchandise_Code") String merchandise_Code) {
		model.put("merchandise", merchandiseService.getMerchandise_Code(merchandise_Code));
		model.put("listMerchandise", merchandiseService.getListMerchandise());
		return "merchandise/edit-mer";
	}

	// Lưu dữ liệu
	@RequestMapping(value = "save-mer.htm", method = RequestMethod.POST)
	public String saveMer(ModelMap model, @ModelAttribute(value = "merchandise") @Validated Merchandise merchandise,
			BindingResult result, @RequestParam("nameu") String nameu) {
		MerchandiseValidator merVali = new MerchandiseValidator();
		merVali.validate(merchandise, result);

		if (merchandise.getMerchandise_Code() == null) {
			result.reject("merchandise_Code");
		} else if (merchandise.getMerchandise_Code().indexOf(" ") > 0) {
			result.rejectValue("merchandise_Code", "merchandise",
					"Mã hàng hoá không được chứa khoảng trắng !");
		} else if (merchandiseService.checkIdMerchandise_Code(merchandise.getMerchandise_Code()) > 0) {
			result.rejectValue("merchandise_Code", "merchandise", "Mã hàng hoá này đã tồn tại !");
		}

		if (result.hasErrors()) {
			model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
			return "merchandise/add-mer";
		} else {
			merchandiseService.insertMerchandise(merchandise, nameu);
			model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
		}
		return "redirect:/admin/merchandise/";
	}

	// Sửa dữ liệu
	@RequestMapping(value = "edit-mer/{merchandise_Code}.htm", method = RequestMethod.POST)
	public String editMer(ModelMap model, @PathVariable("merchandise_Code") String merchandise_Code,
			@ModelAttribute(value = "merchandise") @Validated Merchandise merchandise, BindingResult result, @RequestParam("nameu") String nameu) {
		MerchandiseValidator merVali = new MerchandiseValidator();
		merVali.validate(merchandise, result);

		if (result.hasErrors()) {
			model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
			return "merchandise/edit-mer";
		} else {
			merchandiseService.editMerchandise(merchandise, nameu);
			model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
		}
		return "redirect:/admin/merchandise/";
	}

	// Xóa dữ liệu
	@RequestMapping(value = "delete-mer/{merchandise_Code}/{nameu}.htm", method = RequestMethod.GET)
	public String deleteMer(ModelMap model, @PathVariable("merchandise_Code") String merchandise_Code,
			@ModelAttribute(value = "merchandise") Merchandise merchandise,  @PathVariable("nameu") String nameu) {
		merchandiseService.deleteMerchandise(merchandise, nameu);
		model.addAttribute("listMerchandise", merchandiseService.getListMerchandise());
		return "redirect:/admin/merchandise/";
	}

	// Tìm kiếm hàng hoá
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String searchMerchandise(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listMerchandise", merchandiseService.searchByMer(search));
		return "merchandise/index";
	}
}
