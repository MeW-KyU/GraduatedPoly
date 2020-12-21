package Doan.Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MapperCategories implements RowMapper<Categories> {
	public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
		Categories categories = new Categories();
		categories.setID_Categories(rs.getString("Categories_Code")); //Tom change ID_Categories to Categories_Code in database
		categories.setName_Categories(rs.getString("Name_Categories"));
		return categories;
	}
}
