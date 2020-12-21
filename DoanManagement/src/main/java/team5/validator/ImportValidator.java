package team5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import team5.model.Import;

public class ImportValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return Import.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		Import imp = (Import) object;
		
		if (imp.getDate_Import() == null) {
			errors.rejectValue("date_Import", "import", "Ngày xuất hoá đơn không được để trống !");
		}
		if (imp.getAmount() == 0) {
			errors.rejectValue("amount", "import", "Hãy số lượng hàng hoá !");
		}
		if (imp.getUnit_Price() == 0) {
			errors.rejectValue("unit_Price", "import", "Hãy đơn giá hàng hoá !");
		}
	}
}
