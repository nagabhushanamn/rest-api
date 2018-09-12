package com.bank.repository;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public class JpaAccountRepository implements AccountRepository {

	private final static Logger LOGGER = Logger.getLogger("bank-txr");

	@Autowired
	private EntityManager em;

	public JpaAccountRepository() {
		LOGGER.info("JpaAccountRepository instance created..");
	}

	@Override
	public Account loadAccount(String num) {
		LOGGER.info("loading account - " + num);
		return em.find(Account.class, num);
	}

	@Override
	public void updateAccount(Account account) {
		LOGGER.info("updating account ");
		em.merge(account);

	}

}
