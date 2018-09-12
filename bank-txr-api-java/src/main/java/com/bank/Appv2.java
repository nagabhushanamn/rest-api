package com.bank;

import java.util.List;

import com.bank.model.Txn;
import com.bank.service.TxnService;
import com.bank.service.TxnServiceImpl;

public class Appv2 {

	public static void main(String[] args) {

		// ----------------------------------------
		TxnService txnService = new TxnServiceImpl();
		// ----------------------------------------

		List<Txn> txns = txnService.getTxns(1000.00);
		for (Txn txn : txns) {
			System.out.println(txn);
		}

		// ----------------------------------------

	}

}
