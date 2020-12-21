package team5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import team5.model.Customer;

public class CustomerValidator implements Validator{
	
	public boolean supports(Class<?> arg0) {
		return Customer.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		Customer cus = (Customer) object;
		
		if (cus.getCustomer_Code().trim().length() == 0) {
			errors.rejectValue("customer_Code", "customer", "Hãy điền mã tài khoản khách hàng !");
		}
		if (cus.getPassword().trim().length() == 0) {
			errors.rejectValue("password", "customer", "Hãy điền mật khẩu của khách hàng !");
		}
		if (cus.getName_Customer().trim().length() == 0) {
			errors.rejectValue("name_Customer", "customer", "Hãy điền tên của khách hàng !");
		}
		if (cus.getPhone_Customer().trim().length() == 0) {
			errors.rejectValue("phone_Customer", "customer", "Hãy điền số điện thoại của khách hàng !");
		} else if (cus.getPhone_Customer().indexOf(" ") > 0) {
			errors.rejectValue("phone_Customer", "customer", "Số điện thoại không được chứa khoảng trắng !");
		}
		if (cus.getEmail_Customer().trim().length() == 0) {
			errors.rejectValue("email_Customer", "customer", "Hãy điền địa chỉ email của khách hàng !");
		}
		if (cus.getAddress_Customer().trim().length() == 0) {
			errors.rejectValue("address_Customer", "customer", "Hãy điền địa chỉ cư trú hiện tại của khách hàng !");
		}
		
	}

}
