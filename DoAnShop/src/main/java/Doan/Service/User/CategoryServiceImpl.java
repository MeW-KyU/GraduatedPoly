package Doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dao.CategoriesDao;
import Doan.Dao.ProductsDao;
import Doan.Entity.Categories;
import Doan.Entity.Products;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private ProductsDao productsDao;

	@Autowired
	private CategoriesDao categoriesDao;

	public List<Products> GetAllProductsByID(String id) {
		return productsDao.GetAllProductsByID(id);
	}

	public List<Categories> GetDataCategories() {
		return categoriesDao.GetDataCategories();
	}

}
