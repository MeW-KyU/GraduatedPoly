package Doan.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Doan.Entity.Products;

@Service
public interface IProductService {
	public Products GetProductByID(String id);
	public List<Products> GetOtherProducts();
}
