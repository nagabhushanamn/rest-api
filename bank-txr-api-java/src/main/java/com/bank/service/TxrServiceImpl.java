package com.bank.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.JpaAccountRepository;

/*
 *  design & performance issues
 *  ----------------------------
 *  
 *  ==> on every txr, new account-repo instance created & ignored
 *  	-> slow,memory or resource usage high
 *  ==> tight-coupling b/w TxrService & JPAAccount repository
 *  	-> can't extend module with new features
 *  ==> unit-testing not possible
 *      -> dev & bug fix will be slow
 *      
 *      
 *      
 *   why these issues ?
 *   
 *   => dependent itself creating its own dependency
 *      
 *   soln : don't create dependency in dependent's class, do lookup on factory
 *      
 *   limitation factory-lookup
 *   
 *    => factory location tight-coupling 
 *    
 *   best-soln : don't create/lookup , get inject by any 'third-party' ( IOC )
 *   
 *   
 *   
 *    
 *      
 *      
 * 
 */

@Service
public class TxrServiceImpl implements TxrService {

	private final static Logger LOGGER = Logger.getLogger("bank-txr");

	private AccountRepository accountRepository;

	@Autowired
	public TxrServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		LOGGER.info("TxrServiceImpl instance created.");
	}

	@Transactional
	@Override
	public boolean txr(double amount, String fromAccNum, String toAccNum) {

		LOGGER.info("txr initiated");

		// load 'from' & 'to' accounts
		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		// insert Txn History into table

		// update both accounts
		accountRepository.updateAccount(toAccount);
		accountRepository.updateAccount(fromAccount);
		LOGGER.info("txr successful");
		return true;
	}

}
