package Doan.Service.User;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dao.CartDao;
import Doan.Dto.CartDto;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartDao cartDao = new CartDao();

	public HashMap<String, CartDto> AddCart(String id, HashMap<String, CartDto> cart) {
		return cartDao.AddCart(id, cart);
	}

	public HashMap<String, CartDto> EditCart(String id, int quanty, HashMap<String, CartDto> cart) {
		return cartDao.EditCart(id, quanty, cart);
	}

	public HashMap<String, CartDto> DeleteCart(String id, HashMap<String, CartDto> cart) {
		return cartDao.DeleteCart(id, cart);
	}

	public int TotalQuanty(HashMap<String, CartDto> cart) {
		return cartDao.TotalQuanty(cart);
	}

	public double TotalPrice(HashMap<String, CartDto> cart) {
		return cartDao.TotalPrice(cart);
	}
}
