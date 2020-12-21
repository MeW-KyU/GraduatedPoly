package Doan.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Doan.Entity.Customers;
import Doan.Service.User.AccountServiceImpl;

@Controller
public class CustomerController extends BaseController {
	@Autowired
	AccountServiceImpl accountService = new AccountServiceImpl();

	// Register
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public ModelAndView Register(HttpServletRequest request, HttpSession session) {
		Customers loginInfo = (Customers) session.getAttribute("LoginInfo");
		try {
			if (loginInfo.getUsername() != null) {
				_mvShare.setViewName("redirect:home");
			}
		} catch (Exception e) {
			_mvShare.setViewName("user/account/register");
			_mvShare.addObject("customer", new Customers());
		}
		return _mvShare;
	}

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public ModelAndView CreateAcc(@ModelAttribute("customer") Customers customer) {
		try {
			int count = accountService.AddAccount(customer);
			if (count > 0) {
				_mvShare.addObject("status", "Sign Up Success!");
			} else {
				_mvShare.addObject("status", "Registration Failed!");
			}
			_mvShare.setViewName("user/account/register");
		} catch (Exception e) {
			_mvShare.addObject("status", "Registration Failed!");
		}
		return _mvShare;
	}

	// Login
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView lg(HttpServletRequest request, HttpSession session) {
		Customers loginInfo = (Customers) session.getAttribute("LoginInfo");
		try {
			if (loginInfo.getUsername() != null) {
				_mvShare.setViewName("redirect:home");
			}
		} catch (Exception e) {
			_mvShare.setViewName("user/account/login");
			_mvShare.addObject("customer", new Customers());
		}
		return _mvShare;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Login(HttpSession session, @ModelAttribute("customer") Customers customer) {
		try {
			customer = accountService.CheckAccount(customer);
			if (customer != null) {
				_mvShare.setViewName("redirect:home");
				session.setAttribute("LoginInfo", customer);
			} else {
				_mvShare.addObject("statusLogin", "Login failed!");
			}
		} catch (Exception e) {
			_mvShare.addObject("statusLogin", "Login failed!");
		}
		return _mvShare;
	}

	// Logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String Login(HttpSession session, HttpServletRequest request) {
		session.removeAttribute("LoginInfo");
		return "redirect:" + request.getHeader("Referer");
	}
}
