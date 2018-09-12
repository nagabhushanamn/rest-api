package com.bank;

import com.bank.repository.AccountRepository;
import com.bank.repository.JpaAccountRepository;
import com.bank.service.TxrService;
import com.bank.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// third-party / (can be spring framework) / container ==> application-context

		// init
		System.out.println("--------------------");
		AccountRepository accountRepository = new JpaAccountRepository();
		TxrService txrService = new TxrServiceImpl(accountRepository);
		System.out.println("--------------------");

		// use
		System.out.println("--------------------");
		txrService.txr(100.00, "1", "2");
		System.out.println();
		txrService.txr(100.00, "2", "1");
		System.out.println("--------------------");

		// destroy
		System.out.println("--------------------");
		// ..
		System.out.println("--------------------");

	}

}
