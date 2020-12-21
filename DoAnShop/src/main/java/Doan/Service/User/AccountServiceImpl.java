package Doan.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Doan.Dao.CustomersDao;
import Doan.Entity.Customers;

@Service
public class AccountServiceImpl implements IAccountService{
	@Autowired
	CustomersDao customersDao = new CustomersDao();
	
	public int AddAccount(Customers customer) {
		customer.setPassword(BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt(12)));
		return customersDao.AddAccount(customer);
	}

	public Customers CheckAccount(Customers customer) {
		String pass = customer.getPassword();
		customer = customersDao.GetCustomerByAcc(customer);
		if(customer != null) {
			if(BCrypt.checkpw(pass, customer.getPassword())) {
				return customer;
			}
			else {
				return null;
			}
		}
		return null;
	}
}
