package team5.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import team5.model.Staff;

public class StaffValidator implements Validator{

	public boolean supports(Class<?> arg0) {
		return Staff.class.equals(arg0);
	}

	public void validate(Object object, Errors errors) {
		Staff sta = (Staff) object;
		
		if (sta.getStaff_Code().trim().length() == 0) {
			errors.rejectValue("staff_Code", "staff", "Hãy điền mã nhân viên của bạn !");
		}
		if (sta.getName_Staff().trim().length() == 0) {
			errors.rejectValue("name_Staff", "staff", "Hãy nhập tên của nhân viên !");
		}
		if (sta.getPosition() == 0) {
			errors.rejectValue("position", "staff", "Hãy chọn vị trí của nhân viên !");
		}
		if (sta.getSalary() == 0.0) {
			errors.rejectValue("salary", "staff", "Hãy nhập lương của nhân viên !");
		}
		if (sta.getGender() == 0) {
			errors.rejectValue("gender", "staff", "Hãy chọn giới tính của nhân viên !");
		}
		if (sta.getBirthday() == null) {
			errors.rejectValue("birthday", "staff", "Hãy nhập sinh nhật của nhân viên !");
		}
		if (sta.getPhone_Staff().trim().length() == 0) {
			errors.rejectValue("phone_Staff", "staff", "Hãy điền số điện thoại của nhân viên !");
		} else if (sta.getPhone_Staff().indexOf(" ") > 0) {
			errors.rejectValue("phone_Staff", "staff", "Số điện thoại của nhân viên không được chứa khoảng trắng !");
		} else if (sta.getPhone_Staff().trim().length() < 10) {
			errors.rejectValue("phone_Staff", "staff", "Số điện thoại của nhân viên phải 10 chữ số !");
		}
		if (sta.getEmail_Staff().trim().length() == 0) {
			errors.rejectValue("email_Staff", "staff", "Hãy điền địa chỉ email của nhân viên !");
		}
	}

}
