package team5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import team5.model.Merchandise;

public class MerchandiseValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return Merchandise.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		Merchandise mer = (Merchandise) object;
		
		if (mer.getMerchandise_Code().trim().length() == 0) {
			errors.rejectValue("merchandise_Code", "merchandise", "Hãy điền mã hàng hoá !");
		}
		if (mer.getName_Merchandise().trim().length() == 0) {
			errors.rejectValue("name_Merchandise", "merchandise", "Hãy nhập tên hàng hoá !");
		}
		if (mer.getUnit() == 0) {
			errors.rejectValue("unit", "merchandise", "Hãy chọn đơn vị cho hàng hoá !");
		}
		if (mer.getUnit_Price() == 0) {
			errors.rejectValue("unit_Price", "merchandise", "Hãy nhập đơn giá cho hàng hoá !");
		}
		if (mer.getAmount() == 0) {
			errors.rejectValue("amount", "merchandise", "Hãy số lượng hàng hoá !");
		}
	}

}
