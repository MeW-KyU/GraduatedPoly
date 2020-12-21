package Doan.Service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import Doan.Entity.Categories;
import Doan.Entity.Products;

@Service
public interface ICategoryService {
	
	public List<Products> GetAllProductsByID(String id);
	public List<Categories> GetDataCategories();
	
}
