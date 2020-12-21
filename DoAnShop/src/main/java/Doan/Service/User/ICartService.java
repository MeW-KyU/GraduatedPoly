package Doan.Service.User;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import Doan.Dto.CartDto;

@Service
public interface ICartService {
	public HashMap<String, CartDto> AddCart(String id, HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> EditCart(String id, int quanty, HashMap<String, CartDto> cart);
	public HashMap<String, CartDto> DeleteCart(String id, HashMap<String, CartDto> cart);
	public int TotalQuanty(HashMap<String, CartDto> cart);
	public double TotalPrice(HashMap<String, CartDto> cart);
}
