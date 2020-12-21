package Doan.Service.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dao.ProductsDao;
import Doan.Entity.Products;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	ProductsDao productDao = new ProductsDao();
	
	public Products GetProductByID(String id) {
		List<Products> listProducts = productDao.GetProductByID(id);
		return listProducts.get(0);
	}

	public List<Products> GetOtherProducts() {
		return productDao.GetDataProducts();
	}


}
