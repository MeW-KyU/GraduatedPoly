package Doan.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import Doan.Dto.CartDto;
import Doan.Entity.Bills;

@Service
public interface IBillsService {
	public int AddBills(Bills bill);

	public void AddBillsDetail(HashMap<Long, CartDto> carts);
}
