package team5.dao;

import java.util.List;
import java.util.Map;

import team5.model.Customer;
import team5.model.Date_Yead;
import team5.model.History;
import team5.model.TopProduct;

public interface StatisticalDAO {

	public int countAccount();

	public int countCustomer();

	public int countStaff();

	public int countProduct();

	public int countMerchandise();

	public int countInvoice();

	public List<Date_Yead> listYears();

	List<List<Map<Object, Object>>> getCanvasjsChartDataHD(String yearSale);

	public List<TopProduct> idTop();

	public List<History> listHistory();

	public List<History> loadHisPage(String page);

	public int getRowHis();

}
