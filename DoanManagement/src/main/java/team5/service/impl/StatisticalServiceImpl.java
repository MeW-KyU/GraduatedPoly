package team5.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import team5.dao.StatisticalDAO;
import team5.model.Customer;
import team5.model.Date_Yead;
import team5.model.History;
import team5.model.TopProduct;
import team5.service.StatisticalService;

@Service
public class StatisticalServiceImpl implements StatisticalService {

	@Autowired
	StatisticalDAO statisticalDAO;

	public int countAccount() {
		return statisticalDAO.countAccount();
	}

	public int countCustomer() {
		return statisticalDAO.countCustomer();
	}

	public int countStaff() {
		return statisticalDAO.countStaff();
	}

	public int countProduct() {
		return statisticalDAO.countProduct();
	}

	public int countInvoice() {
		return statisticalDAO.countInvoice();
	}

	public int countMerchandise() {
		return statisticalDAO.countMerchandise();
	}

	public List<Date_Yead> listYears() {
		return statisticalDAO.listYears();
	}

	public List<List<Map<Object, Object>>> getCanvasjsChartDataHD(String yearSale) {
		return statisticalDAO.getCanvasjsChartDataHD(yearSale);
	}

	public List<TopProduct> idTop() {
		return statisticalDAO.idTop();
	}

	public List<History> listHistory() {
		return statisticalDAO.listHistory();
	}

	public List<History> loadHisPage(String page) {
		return statisticalDAO.loadHisPage(page);
	}

	public int getRowHis() {
		return statisticalDAO.getRowHis();
	}

}
