package Doan.Controller.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController extends BaseController{
	
	// Homepage
	@RequestMapping(value = {"/", "/home", "/Home"})
	public ModelAndView Index() {
		_mvShare.addObject("categories", _homeService.GetDataCategories());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/index");
		return _mvShare;
	}
	
	// Menu
	@RequestMapping(value = {"/menu", "/Menu"})
	public ModelAndView Menu() {
		_mvShare.addObject("categories", _homeService.GetDataCategories());
		_mvShare.addObject("AllProducts", _homeService.GetAllProducts());
		_mvShare.setViewName("user/menu");
		return _mvShare;
	}
	
	// Services
	@RequestMapping(value = {"/services", "/Services"})
	public ModelAndView Services() {
		_mvShare.setViewName("user/services");
		return _mvShare;
	}
	
	// About
	@RequestMapping(value = {"/about", "/About"})
	public ModelAndView About() {
		_mvShare.setViewName("user/about");
		return _mvShare;
	}
	
	// Contact
	@RequestMapping(value = {"/contact", "/Contact"})
	public ModelAndView Contact() {
		_mvShare.setViewName("user/contact");
		return _mvShare;
	}
	
}
