package Doan.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import Doan.Entity.Categories;
import Doan.Entity.MapperCategories;
@Repository
public class CategoriesDao extends BaseDao{

	public List<Categories> GetDataCategories() {
		List<Categories> list = new ArrayList<Categories>();
		String sql = "SELECT * FROM Categories";
		list = _jdbcTemplate.query(sql, new MapperCategories());
		return list;
	}
}
