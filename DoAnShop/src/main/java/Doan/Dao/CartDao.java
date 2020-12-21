package Doan.Dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Doan.Dto.CartDto;
import Doan.Entity.Products;

@Repository
public class CartDao extends BaseDao {

	@Autowired
	ProductsDao productsDao = new ProductsDao();

	public HashMap<String, CartDto> AddCart(String id, HashMap<String, CartDto> cart) {
		CartDto itemCart = new CartDto();
		Products product = productsDao.FindProductsByID(id);
		if (product != null && cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(itemCart.getQuanty() + 1);
			itemCart.setTotalPrice(itemCart.getQuanty() * itemCart.getProduct().getPrice());
		}else {
			itemCart.setProduct(product);
			itemCart.setQuanty(1);
			itemCart.setTotalPrice(product.getPrice());
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<String, CartDto> EditCart(String id, int quanty, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		CartDto itemCart = new CartDto();
		if (cart.containsKey(id)) {
			itemCart = cart.get(id);
			itemCart.setQuanty(quanty);
			double totalPrice = quanty * itemCart.getProduct().getPrice();
			itemCart.setTotalPrice(totalPrice);
		}
		cart.put(id, itemCart);
		return cart;
	}

	public HashMap<String, CartDto> DeleteCart(String id, HashMap<String, CartDto> cart) {
		if (cart == null) {
			return cart;
		}
		if (cart.containsKey(id)) {
			cart.remove(id);
		}
		return cart;
	}

	public int TotalQuanty(HashMap<String, CartDto> cart) {
		int totalQuanty = 0;
		for (Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalQuanty += itemCart.getValue().getQuanty();
		}
		return totalQuanty;
	}

	public double TotalPrice(HashMap<String, CartDto> cart) {
		double totalPrice = 0;
		for (Map.Entry<String, CartDto> itemCart : cart.entrySet()) {
			totalPrice += itemCart.getValue().getTotalPrice();
		}
		return totalPrice;
	}
}
