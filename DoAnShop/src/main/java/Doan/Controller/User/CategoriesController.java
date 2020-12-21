package Doan.Controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Doan.Service.User.CategoryServiceImpl;

@Controller
public class CategoriesController extends BaseController{
	
	@Autowired
	private CategoryServiceImpl categoryService;
	
	@RequestMapping(value = "/categories/{id}")
	public ModelAndView Product(@PathVariable String id) {
		_mvShare.setViewName("user/products/categories");
		_mvShare.addObject("AllProductsByID", categoryService.GetAllProductsByID(id));
		_mvShare.addObject("categories", _homeService.GetDataCategories());
		return _mvShare;
	}
	
}
