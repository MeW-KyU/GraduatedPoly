package team5.controller;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Transactional
@Controller
public class HomeController {

	@Autowired
	SessionFactory sessionFactory;

	// Trang chủ
	@RequestMapping(value = "/admin/statistical/")
	public String home(ModelMap model, HttpServletRequest request) {
		
		return "statistical/index";
	}
}
