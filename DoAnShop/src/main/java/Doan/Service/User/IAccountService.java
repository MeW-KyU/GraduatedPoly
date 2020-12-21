package Doan.Service.User;

import org.springframework.stereotype.Service;

import Doan.Entity.Customers;

@Service
public interface IAccountService {
	public int AddAccount(Customers customer);
	
	public Customers CheckAccount(Customers customer);
}
