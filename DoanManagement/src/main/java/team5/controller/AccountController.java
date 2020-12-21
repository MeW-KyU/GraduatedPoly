package team5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team5.model.Account;
import team5.service.AccountService;

@Transactional
@Controller
@RequestMapping(value = "/admin/account/")
public class AccountController {

	@Autowired
	AccountService accountService;

	// Trang chủ
	@RequestMapping(method = RequestMethod.GET)
	public String viewIndex(ModelMap model) {
		model.put("listAccount", accountService.getListAccount());
		return "account/index";
	}

	// Mở Form tạo dữ liệu
	@RequestMapping(value = "add-acc.htm", method = RequestMethod.GET)
	public String fromAdd(ModelMap model) {
		model.put("account", new Account());
		model.put("listAccount", accountService.getListAccount());
		return "account/add-acc";
	}

	// Mở Form sửa dữ liệu
	@RequestMapping(value = "edit-acc/{username}.htm", method = RequestMethod.GET)
	public String formEdit(ModelMap model, @PathVariable(value = "username") String username) {
		model.put("account", accountService.getUsernameAccount(username));
		model.put("listAccount", accountService.getListAccount());
		return "account/edit-acc";
	}

	// Sửa dữ liệu
	@RequestMapping(value = "edit-acc/{username}.htm", method = RequestMethod.POST)
	public String editAcc(ModelMap model, @PathVariable(value = "username") String username,
			@ModelAttribute(value = "account") Account account, BindingResult error,
			@RequestParam("nameu") String nameu) {
		if (account.getAccess() == 0) {
			error.rejectValue("access", "account", "Hãy chọn quyền của tài khoản !");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			model.put("listAccount", accountService.getListAccount());
			return "account/edit-acc";
		} else {
			accountService.editAccount(account, nameu);
			model.put("listAccount", accountService.getListAccount());
		}
		return "redirect:/admin/account/";
	}

	// Lưu dữ liệu
	@RequestMapping(value = "save-acc.htm", method = RequestMethod.POST)
	public String saveAcc(ModelMap model, @ModelAttribute(value = "account") Account account, BindingResult error,
			@RequestParam("nameu") String nameu) {
		if (account.getUsername().trim().length() == 0) {
			error.rejectValue("username", "account", "Hãy điền tên đăng nhập !");
		} else if (account.getUsername().indexOf(" ") > 0) {
			error.rejectValue("username", "account", "Tên đăng nhập không được chứa khoảng trống !");
		} else if (accountService.checkIdUsername(account.getUsername()) > 0) {
			error.rejectValue("username", "account", "Tên đăng nhập này đã tồn tại !");
		}

		if (account.getPassword().trim().length() == 0) {
			error.rejectValue("password", "account", "Hãy điền mật khẩu của bạn !");
		}

		if (account.getAccess() == 0) {
			error.rejectValue("access", "account", "Hãy chọn quyền của tài khoản !");
		}

		if (error.hasErrors()) {
			model.addAttribute("message", "Vui lòng sửa các lỗi sau đây !");
			model.put("listAccount", accountService.getListAccount());
			return "account/add-acc";
		} else {
			accountService.insertAccount(account, nameu);
			model.put("listAccount", accountService.getListAccount());
		}

		return "redirect:/admin/account/";
	}

	// reset password
	@RequestMapping(value = "reset-acc/{username}/{nameu}.htm", method = RequestMethod.GET)
	public String formReset(ModelMap model, @PathVariable(value = "username") String username,
			@ModelAttribute(value = "account") Account account, @PathVariable("nameu") String nameu) {
		account = accountService.getUsernameAccount(username);
		account.setPassword("123");
		account.getAccess();
		accountService.editAccount(account, nameu);
		model.put("listAccount", accountService.getListAccount());
		return "account/index";
	}

	// form đổi mật khẩu
	@RequestMapping(value = "FormeditPass/{username}.htm", method = RequestMethod.GET)
	public String formEditPass(ModelMap model, @PathVariable(value = "username") String username) {
		model.put("account", accountService.getUsernameAccount(username));
		model.put("listAccount", accountService.getListAccount());
		return "account/edit-pass";
	}

	// đổi mật khẩu
	@RequestMapping(value = "editPass/{username}.htm", method = RequestMethod.POST)
	public String editPass(ModelMap model, @PathVariable(value = "username") String username,
			@ModelAttribute(value = "account") Account account1, BindingResult error,
			@RequestParam("nameu") String nameu) {
		if (account1.getUsername().trim().length() == 0) {
			error.rejectValue("username", "account", "Hãy điền tên đăng nhập !");
		}
		if (account1.getPassword().trim().length() == 0) {
			error.rejectValue("password", "account", "Hãy điền mật khẩu của bạn !");
		}
		Account account = accountService.getUsernameAccount(username);
		account.setPassword(account1.getPassword());
		account.getUsername();
		account.getAccess();
		System.out.println(account.getPassword());
		accountService.editAccount(account, nameu);
		model.put("listAccount", accountService.getListAccount());

		return "account/index";
	}

	// Xóa dữ liệu
	@RequestMapping(value = "delete-acc/{username}/{nameu}.htm", method = RequestMethod.GET)
	public String deleteAcc(ModelMap model, @PathVariable(value = "username") String username,
			@ModelAttribute(value = "account") Account account, @PathVariable("nameu") String nameu) {
		accountService.deleteAccount(account, nameu);
		model.put("listAccount", accountService.getListAccount());
		return "redirect:/admin/account/";
	}

	// Tìm kiếm tài khoản
	@RequestMapping(value = "search.htm", method = RequestMethod.GET)
	public String search(ModelMap model, @RequestParam("search") String search) {
		model.addAttribute("listAccount", accountService.searchAccount(search));
		return "account/index";
	}

}
