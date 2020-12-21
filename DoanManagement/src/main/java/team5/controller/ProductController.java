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
import org.springframework.web.multipart.MultipartFile;

import team5.model.Categories;
import team5.model.Product;
import team5.service.ProductService;
import team5.validator.ProductValidator;

@Transactional
@Controller
@RequestMapping(value = "/admin/product/")
public class ProductController {

	@Autowired
	ProductService productService;
	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("listProduct", productService.getListProduct());
		if (productService.getRowProd() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listProduct", productService.loadProdPage("1"));
			} else {
				model.addAttribute("listProduct", productService.loadProdPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(productService.getRowProd()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("listProduct", productService.getListProduct());
		}
		return "product/index";
	}

	// Form thêm sản phẩm
	@RequestMapping(value = "add-prod.htm", method = RequestMethod.GET)
	public String formAdd(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("product", new Product());
		model.addAttribute("listProduct", productService.getListProduct());

		if (productService.getRowProd() > 10) {
			if (request.getParameter("page") == null) {
				model.addAttribute("listProduct", productService.loadProdPage("1"));
			} else {
				model.addAttribute("listProduct", productService.loadProdPage(request.getParameter("page")));
			}
			double paging = Math.ceil(Double.valueOf(productService.getRowProd()) / 10);
			model.addAttribute("rowCount", paging);
		} else {
			model.addAttribute("product", new Product());
			model.addAttribute("listProduct", productService.getListProduct());
		}
		return "product/add-prod";
	}

	// Form sửa sản phẩm
	@RequestMapping(value = "edit-prod/{product_Code}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable("product_Code") String product_Code) {
		model.put("product", productService.getProduct_Code(product_Code));
		model.put("listProduct", productService.getListProduct());
		return "product/edit-prod";
	}

	// Lưu dữ liệu
	@RequestMapping(value = "save-prod.htm", method = RequestMethod.POST)
	public String saveProd(ModelMap model, @ModelAttribute(value = "product") @Validated Product product,
			BindingResult result, @RequestParam MultipartFile image, @RequestParam("nameu") String nameu) throws Exception {
		ProductValidator prodVali = new ProductValidator();
		prodVali.validate(product, result);

		if (product.getProduct_Code() == null) {
			result.reject("product_Code");
		} else if (product.getProduct_Code().indexOf(" ") > 0) {
			result.rejectValue("product_Code", "product", "Mã sản phẩm không được chứa khoảng trắng !");
		} else if (productService.checkIdProduct_Code(product.getProduct_Code()) > 0) {
			result.rejectValue("product_Code", "product", "Mã sản phẩm này đã tồn tại !");
		}

		String rs = product.getProduct_Code();
		String[] splits = rs.split("\\d+");
		for (String code : splits) {
			if (code.trim().equals("sp_pizza")) {
				product.setSize("S/M/L/XL");
			} else {
				product.setSize("M/L");
			}
		}

		if (!image.isEmpty()) {
			product.setImage(image.getBytes());

			if (result.hasFieldErrors("product_Code") && result.hasFieldErrors("name_Product")
					&& result.hasFieldErrors("unit") && result.hasFieldErrors("price")
					&& result.hasFieldErrors("description")) {
				model.addAttribute("listProduct", productService.getListProduct());
				return "product/add-prod";
			} else if (!image.getOriginalFilename().endsWith(".jpg") && !image.getOriginalFilename().endsWith(".png")
					&& !image.getOriginalFilename().endsWith(".jpeg") && !image.getOriginalFilename().endsWith(".JPG")
					&& !image.getOriginalFilename().endsWith(".PNG")
					&& !image.getOriginalFilename().endsWith(".JPEG")) {
				model.addAttribute("listProduct", productService.getListProduct());
				return "product/add-prod";
			} else {
				productService.insertProduct(product, nameu);
				model.addAttribute("listProduct", productService.getListProduct());
			}
			
		} else {
			model.addAttribute("listProduct", productService.getListProduct());
			return "product/add-prod";
		}

		return "redirect:/admin/product/";
	}

	// Sửa dữ liệu
	@RequestMapping(value = "edit-prod/{product_Code}.htm", method = RequestMethod.POST)
	public String editProd(ModelMap model, @PathVariable("product_Code") String product_Code,
			@ModelAttribute(value = "product") @Validated Product product, BindingResult result,
			@RequestParam MultipartFile image, @RequestParam("nameu") String nameu) throws Exception {
		ProductValidator prodVali = new ProductValidator();
		prodVali.validate(product, result);

		String rs = product.getProduct_Code();
		String[] splits = rs.split("\\d+");
		for (String code : splits) {
			if (code.trim().equals("sp_pizza")) {
				product.setSize("S/M/L/XL");
			} else {
				product.setSize("M/L");
			}
		}

		if (!image.isEmpty()) {
			product.setImage(image.getBytes());
			System.out.println(product.getImage());
			if (result.hasFieldErrors("product_Code") && result.hasFieldErrors("name_Product")
					&& result.hasFieldErrors("unit") && result.hasFieldErrors("price")
					&& result.hasFieldErrors("description")) {
				model.addAttribute("listProduct", productService.getListProduct());
				return "product/edit-prod";
			} else {
				productService.editProduct(product, nameu);
				model.addAttribute("listProduct", productService.getListProduct());
			}
		} else {
			model.addAttribute("listProduct", productService.getListProduct());
			return "product/edit-prod";
		}

		return "redirect:/admin/product/";
	}

	// Xóa dữ liệu
	@RequestMapping(value = "delete-prod/{product_Code}/{nameu}.htm", method = RequestMethod.GET)
	public String deleteProd(ModelMap model, @PathVariable("product_Code") String product_Code,
			@ModelAttribute(value = "product") Product product,  @PathVariable("nameu") String nameu) {
		productService.deleteProduct(product, nameu);
		model.addAttribute("listProduct", productService.getListProduct());
		return "redirect:/admin/product/";
	}

	// Tìm kiếm sản phẩm
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String searchMerchandise(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listProduct", productService.searchByProd(search));
		return "product/index";
	}

	@SuppressWarnings("unchecked")
	@ModelAttribute("categories")
	public List<Categories> getCategories() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("FROM Categories").list();
	}
}
