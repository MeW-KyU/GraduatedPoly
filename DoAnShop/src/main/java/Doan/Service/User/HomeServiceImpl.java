package Doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dao.CategoriesDao;
import Doan.Dao.MenuDao;
import Doan.Dao.ProductsDao;
import Doan.Entity.Categories;
import Doan.Entity.Menus;
import Doan.Entity.Products;

@Service
public class HomeServiceImpl implements IHomeService {
	@Autowired
	private CategoriesDao categoriesDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private ProductsDao productsDao;

	public List<Categories> GetDataCategories() {
		return categoriesDao.GetDataCategories();
	}
	
	public List<Menus> GetDataMenus() {
		return menuDao.GetDataMenus();
	}
	
	public List<Products> GetDataProducts() {
		return productsDao.GetDataProducts();
	}
	
	public List<Products> GetAllProducts() {
		return productsDao.GetAllProducts();
	}

}
