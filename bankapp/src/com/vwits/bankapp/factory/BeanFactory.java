package com.vwits.bankapp.factory;

import com.vwits.bankapp.dao.AccountDao;
import com.vwits.bankapp.dao.impl.AccountArrayListDaoImpl;
import com.vwits.bankapp.service.AccountService;
import com.vwits.bankapp.service.impl.AccountServiceImpl;

//Responsible for object creation of different layers (Dao,View etc)
// Creating an object of DaoImpl leads to tight coupling
// to a specific implementation which is bad
// DON't create object here
// Ask some other class to create object
// Factory Design Pattern

public class BeanFactory {

	public static AccountDao getDao()
	{
		AccountArrayListDaoImpl dao = new AccountArrayListDaoImpl();
		return dao;
	}
	
	public static AccountService getServcie()
	{
		AccountServiceImpl service = new AccountServiceImpl(getDao());
		return service;
	}
	
	
}
