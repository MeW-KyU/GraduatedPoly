package team5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import team5.model.Export;

public class ExportValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return Export.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		Export exp = (Export) object;
		
		if (exp.getDate_Export() == null) {
			errors.rejectValue("date_Export", "export", "Ngày xuất hoá đơn không được để trống !");
		}
		if (exp.getAmount() == 0) {
			errors.rejectValue("amount", "export", "Hãy số lượng hàng hoá !");
		}
	}

}
