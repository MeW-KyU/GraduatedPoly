package team5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import team5.model.Product;

public class ProductValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return Product.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		Product prod = (Product) object;
		
		if(prod.getProduct_Code().trim().length() == 0) {
			errors.rejectValue("product_Code", "product", "Hãy điền mã sản phẩm !");
		}
		if(prod.getName_Product().trim().length() == 0) {
			errors.rejectValue("name_Product", "product", "Hãy điền tên sản phẩm !");
		}
		if (prod.getUnit() == 0) {
			errors.rejectValue("unit", "product", "Hãy chọn đơn vị cho sản phẩm !");
		}
		if (prod.getPrice() == 0) {
			errors.rejectValue("price", "product", "Hãy nhập giá cho sản phẩm !");
		}
		if(prod.getDescription().trim().length() == 0) {
			errors.rejectValue("description", "product", "Hãy mô tả vài điều về sản phẩm !");
		}
	}

}
