package team5.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import team5.model.Date_Yead;
import team5.model.History;
import team5.model.Product;
import team5.model.TopProduct;
import team5.service.ProductService;
import team5.service.StatisticalService;

@Transactional
@Controller
@RequestMapping(value = "/admin/statistical/")
public class StatisticalController {

	@Autowired
	StatisticalService statisticalService;

	@Autowired
	ProductService productService;

	@Autowired
	SessionFactory sessionFactory;

	@RequestMapping(method = RequestMethod.GET)
	public String viewIndex(ModelMap model, HttpServletRequest request, HttpServletResponse response) {

		model.put("countAccount", statisticalService.countAccount());
		model.put("countCustomer", statisticalService.countCustomer());
		model.put("countStaff", statisticalService.countStaff());
		model.put("countProduct", statisticalService.countProduct());
		model.put("countMerchandise", statisticalService.countMerchandise());
		model.put("countInvoice", statisticalService.countInvoice());

		List<Date_Yead> listOfYears = statisticalService.listYears();
		model.addAttribute("listOfYears", listOfYears);

		model.addAttribute("department", listOfYears.get(0).getYead() + "");
		List<List<Map<Object, Object>>> canvasjsDataListHD = statisticalService
				.getCanvasjsChartDataHD(listOfYears.get(0).getYead() + "");
		model.addAttribute("dataPointsListHD", canvasjsDataListHD);

		List<TopProduct> idTop = statisticalService.idTop();
		List<Product> listTop = null;
		List<Product> list = new ArrayList<Product>();
		model.addAttribute("idTop", idTop);
		for (int i = 0; i < idTop.size(); i++) {
			listTop = productService.searchByProd(idTop.get(i).getProduct_Code());
			for (int j = 0; j < listTop.size(); j++) {
				list.add(listTop.get(j));
			}
		}
		model.addAttribute("listProduct", list);
	
		List<History> listHistory = statisticalService.listHistory();
		model.addAttribute("listHistory", listHistory);

//		if (statisticalService.getRowHis() > 5) {
//			if (request.getParameter("page") == null) {
//				model.addAttribute("listHistory", statisticalService.loadHisPage("1"));
//			} else {
//				model.addAttribute("listHistory", statisticalService.loadHisPage(request.getParameter("page")));
//			}
//			double paging = Math.ceil(Double.valueOf(statisticalService.getRowHis()) / 10);
//			model.addAttribute("rowCount", paging);
//		} else {
//			model.addAttribute("listHistory", statisticalService.listHistory());
//		}

		return "statistical/index";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String test3(@RequestParam("department") int department, Model model, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("countAccount", statisticalService.countAccount());
		model.addAttribute("countCustomer", statisticalService.countCustomer());
		model.addAttribute("countStaff", statisticalService.countStaff());
		model.addAttribute("countProduct", statisticalService.countProduct());
		model.addAttribute("countMerchandise", statisticalService.countMerchandise());
		model.addAttribute("countInvoice", statisticalService.countInvoice());

		List<Date_Yead> listOfYears = statisticalService.listYears();
		model.addAttribute("listOfYears", listOfYears);

		model.addAttribute("department", department);
		List<List<Map<Object, Object>>> canvasjsDataListHD = statisticalService.getCanvasjsChartDataHD(department + "");
		model.addAttribute("dataPointsListHD", canvasjsDataListHD);

		List<TopProduct> idTop = statisticalService.idTop();
		model.addAttribute("idTop", idTop);
		model.addAttribute("listProduct", productService.searchByProd(idTop.get(0).getProduct_Code()));

		List<History> listHistory = statisticalService.listHistory();
		model.addAttribute("listHistory", listHistory);

//		if (statisticalService.getRowHis() > 5) {
//			if (request.getParameter("page") == null) {
//				model.addAttribute("listHistory", statisticalService.loadHisPage("1"));
//			} else {
//				model.addAttribute("listHistory", statisticalService.loadHisPage(request.getParameter("page")));
//			}
//			double paging = Math.ceil(Double.valueOf(statisticalService.getRowHis()) / 10);
//			model.addAttribute("rowCount", paging);
//		} else {
//			model.addAttribute("listHistory", statisticalService.listHistory());
//		}

		return "statistical/index";
	}

}
