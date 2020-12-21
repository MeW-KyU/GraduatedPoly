package Doan.Service.User;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dao.BillsDao;
import Doan.Dto.CartDto;
import Doan.Entity.BillDetail;
import Doan.Entity.Bills;

@Service
public class BillsServiceImpl implements IBillsService {

	@Autowired
	private BillsDao billsDao;

	public int AddBills(Bills bill) {
		return billsDao.AddBills(bill);
	}

	public void AddBillsDetail(HashMap<Long, CartDto> carts) {
		long idBills = billsDao.GetIDLastBills();

		for (Map.Entry<Long, CartDto> itemCart : carts.entrySet()) {
			BillDetail billDetail = new BillDetail();
			billDetail.setId_bills(idBills);
			billDetail.setProduct_Code(itemCart.getValue().getProduct().getProduct_Code());
			billDetail.setQuanty(itemCart.getValue().getQuanty());
			billDetail.setTotal(itemCart.getValue().getTotalPrice());
			billsDao.AddBillsDetail(billDetail);
		}

	}
}
