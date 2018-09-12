package com.bank.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.bank.model.Txn;
import com.bank.model.TxnType;
import com.bank.service.lib.TxnUtilLib;

public class TxnServiceImpl implements TxnService {

	private List<Txn> txns = Arrays.asList(new Txn(2313, LocalDate.of(2017, 4, 12), 1000.00, TxnType.CREDIT),
			new Txn(2313, LocalDate.of(2017, 4, 12), 1000.00, TxnType.CREDIT),
			new Txn(3423, LocalDate.of(2018, 4, 12), 3000.00, TxnType.DEBIT),
			new Txn(4313, LocalDate.of(2018, 2, 13), 4000.00, TxnType.CREDIT),
			new Txn(5313, LocalDate.of(2018, 3, 11), 1000.00, TxnType.CREDIT),
			new Txn(6313, LocalDate.of(2018, 8, 17), 5000.00, TxnType.DEBIT),
			new Txn(7313, LocalDate.of(2018, 7, 19), 6000.00, TxnType.DEBIT),
			new Txn(8314, LocalDate.of(2018, 9, 20), 1000.00, TxnType.CREDIT),
			new Txn(9313, LocalDate.of(2018, 10, 20), 7000.00, TxnType.CREDIT),
			new Txn(9314, LocalDate.of(2018, 10, 20), 1000.00, TxnType.DEBIT));

	@Override
	public List<Txn> getTxns(int limit) {
		// ..
		return null;
	}

	@Override
	public List<Txn> getTxns(double amount) {

		// A. imperative style ( what + How )

		// ----------------------------------------------------

//		List<Txn> result = new ArrayList<>();
//		for (Txn txn : txns) {
//			if (txn.getAmount() == amount)
//				result.add(txn);
//		}
//
//		return result;

		// ----------------------------------------------------

		// B. declarative style : Local Inner class
//		class ByAmountCondition implements Predicate<Txn> {
//			@Override
//			public boolean test(Txn t) {
//				return t.getAmount() == amount;
//			}
//		}
//		Predicate<Txn> predicate = new ByAmountCondition();

		// ----------------------------------------------------

		// C. declarative style : Anonymous Inner class
//		Predicate<Txn> predicate = new Predicate<Txn>() {
//			@Override
//			public boolean test(Txn t) {
//				return t.getAmount() == amount;
//			}
//		};
//
//		return TxnUtilLib.filter(txns, predicate);

		// ----------------------------------------------------

//		D. declarative style : function   ( what )  ==> Functional programming pardigm

		return TxnUtilLib.filter(txns, t -> t.getAmount() == amount);

		// ----------------------------------------------------
		
		/*
		 *  in js
		 *  
		 *  let condition=function(t){
		 *  return t.getAmount()=== amount
		 *  };
		 *  
		 *  let condition=(t)=>return t.getAmount()=== amount
		 *  
		 *  
		 *  
		 * 
		 */

	}

	@Override
	public List<Txn> getTxns(LocalDate date) {

		List<Txn> result = new ArrayList<>();
		for (Txn txn : txns) {
			if (txn.getDate().equals(date))
				result.add(txn);
		}

		return result;

	}

	@Override
	public List<Txn> getTxns(LocalDate from, LocalDate to) {
		return null;
	}

}
