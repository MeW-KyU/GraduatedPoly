package Doan.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Doan.Service.User.IProductService;

@Controller
public class ProductController extends BaseController{
	
	@Autowired
	private IProductService _productService;
	
	@RequestMapping(value = {"product-details/{id}"})
	public ModelAndView Index(@PathVariable String id) {
		_mvShare.setViewName("user/products/product");
		_mvShare.addObject("product", _productService.GetProductByID(id));
		_mvShare.addObject("otherProducts", _productService.GetOtherProducts());
		return _mvShare;
	}
}
