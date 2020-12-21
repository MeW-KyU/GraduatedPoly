package team5.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import team5.model.Account;
import team5.service.AccountService;

@Transactional
@Controller
@RequestMapping(value = "/admin/login/")
public class LoginController {

	@Autowired
	AccountService accountService;

	@RequestMapping(method = RequestMethod.GET)
	public String login(ModelMap model) {
		model.put("loginForm", new Account());
		return "login/index";
	}

	@RequestMapping(value = "login.htm")
	public String login(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("loginForm") Account acc, ModelMap model, BindingResult result) {
		
		result.hasErrors();

		Account account = accountService.loginAccount(acc.getUsername(), acc.getPassword());
		if (account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("account", account);
			if (request.getParameter("remember") != null) {
				Cookie ckUsername = new Cookie("username", acc.getUsername());
				ckUsername.setMaxAge(3600);
				response.addCookie(ckUsername);
				Cookie ckPass = new Cookie("password", acc.getPassword());
				ckPass.setMaxAge(3600);
				response.addCookie(ckPass);
				System.out.println("Cookie: " + acc.getUsername());
			}
			int rolse = account.getAccess();
			String res = null;
			switch (rolse) {
			case 1:
				res = "redirect:/admin/statistical/";
				break;
			case 2:
				res = "redirect:/admin/statistical/";
				break;
			}
			System.out.println("Hi " + account.getAccess());
			return res;
		} else {
			return "login/index";
		}

	}

	@RequestMapping(value = "logout.htm", method = RequestMethod.GET)
	public String logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		// Gỡ bỏ phiên làm việc
		session.removeAttribute("account");
		// Gỡ bỏ cookie
		for (Cookie ck : request.getCookies()) {
			if (ck.getName().equalsIgnoreCase("username")) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
			if (ck.getName().equalsIgnoreCase("password")) {
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
		}
		return "redirect:/admin/login/";
	}

}
