package com.bank.service.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.bank.model.Txn;

public class TxnUtilLib {

	public static List<Txn> filter(List<Txn> dataIn, Predicate<Txn> predicate) {

		List<Txn> dataOut = new ArrayList<>();
		for (Txn txn : dataIn) {
			if (predicate.test(txn))
				dataOut.add(txn);
		}

		return dataOut;

	}

}
