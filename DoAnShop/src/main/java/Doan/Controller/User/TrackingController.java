package Doan.Controller.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import Doan.Entity.Customers;
import Doan.Service.User.ITrackingService;

@Controller
public class TrackingController extends BaseController {

	@Autowired
	private ITrackingService _trackingService;

	@RequestMapping(value = "/tracking")
	public ModelAndView Tracking(HttpServletRequest request, HttpSession session) {
		Customers loginInfo = (Customers) session.getAttribute("LoginInfo");
		try {
			if (loginInfo.getUsername() != null) {
				_mvShare.addObject("track", _trackingService.GetDataTracking());
				_mvShare.setViewName("user/bills/tracking");
			}
		} catch (Exception e) {
			_mvShare.setViewName("redirect:home");
		}
		return _mvShare;
	}
}
