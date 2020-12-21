package Doan.Controller.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Doan.Dto.CartDto;
import Doan.Entity.Bills;
import Doan.Entity.Customers;
import Doan.Service.User.BillsServiceImpl;
import Doan.Service.User.CartServiceImpl;

@Controller
public class CartController extends BaseController {

	@Autowired
	private CartServiceImpl cartService = new CartServiceImpl();

	@Autowired
	private BillsServiceImpl billsService = new BillsServiceImpl();

	@RequestMapping(value = "ListCart")
	public ModelAndView Index() {
		_mvShare.addObject("categories", _homeService.GetDataCategories());
		_mvShare.addObject("products", _homeService.GetDataProducts());
		_mvShare.setViewName("user/cart/list_cart");
		return _mvShare;
	}

	@RequestMapping(value = "AddCart/{id}")
	public String AddCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.AddCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "EditCart/{id}/{quanty}")
	public String EditCart(HttpServletRequest request, HttpSession session, @PathVariable String id,
			@PathVariable int quanty) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.EditCart(id, quanty, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	@RequestMapping(value = "DeleteCart/{id}")
	public String DeleteCart(HttpServletRequest request, HttpSession session, @PathVariable String id) {
		HashMap<String, CartDto> cart = (HashMap<String, CartDto>) session.getAttribute("Cart");
		if (cart == null) {
			cart = new HashMap<String, CartDto>();
		}
		cart = cartService.DeleteCart(id, cart);
		session.setAttribute("Cart", cart);
		session.setAttribute("TotalQuantyCart", cartService.TotalQuanty(cart));
		session.setAttribute("TotalPriceCart", cartService.TotalPrice(cart));
		return "redirect:" + request.getHeader("Referer");
	}

	
	// Checkout
	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public ModelAndView CheckOut(HttpServletRequest request, HttpSession session) {
		_mvShare.setViewName("user/bills/checkout");
		Bills bills = new Bills();
		Customers loginInfo = (Customers) session.getAttribute("LoginInfo");
		if (loginInfo != null) {
			bills.setUsername(loginInfo.getUsername());
			bills.setName(loginInfo.getName());
			bills.setPhone(loginInfo.getPhone());
			bills.setEmail(loginInfo.getEmail());
			bills.setAddress(loginInfo.getAddress());
		}
		_mvShare.addObject("bills", bills);
		return _mvShare;
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String CheckOut(HttpServletRequest request, HttpSession session, @ModelAttribute("bills") Bills bill) {
		bill.setQuanty(session.getAttribute("TotalQuantyCart"));
		bill.setTotal(session.getAttribute("TotalPriceCart"));
		if (billsService.AddBills(bill) > 0) {
			HashMap<Long, CartDto> carts = (HashMap<Long, CartDto>) session.getAttribute("Cart");
			billsService.AddBillsDetail(carts);
		}
		session.removeAttribute("Cart");
		session.removeAttribute("TotalQuantyCart");
		session.removeAttribute("TotalPriceCart");
		return "redirect:ListCart";
	}

}
