package Doan.Entity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import org.springframework.jdbc.core.RowMapper;

public class MapperProducts implements RowMapper<Products> {

	public Products mapRow(ResultSet rs, int rowNum) throws SQLException {
		Products products = new Products();
		try {
			products.setProduct_Code(rs.getString("product_Code"));
			products.setName_Product(rs.getString("name_Product"));
			products.setPrice(rs.getDouble("price"));
			products.setDescription(rs.getString("description"));
			products.setCategories_Code(rs.getString("categories_Code"));
			products.setSize(rs.getString("size"));
			
			//Covert binary to image
			Blob blob = rs.getBlob("image");
			InputStream inputStream = blob.getBinaryStream();
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			byte[] imageBytes = outputStream.toByteArray();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			inputStream.close();
			outputStream.close();
			products.setImage(base64Image);
			
		} catch (SQLException | IOException ex) {
			ex.printStackTrace();
		}

		return products;
	}

}
