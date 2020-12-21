package Doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Entity.Categories;
import Doan.Entity.Menus;
import Doan.Entity.Products;

@Service
public interface IHomeService {
	@Autowired
	public List<Categories> GetDataCategories();
	public List<Menus> GetDataMenus();
	public List<Products> GetDataProducts();
	public List<Products> GetAllProducts();
}
