package com.bank.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.TxrService;

@RestController
public class TxrController {

	@Autowired
	private TxrService txrService;

	@RequestMapping(value = "/v1/api/txr", method = RequestMethod.POST)
	public TxrResponse doTxr(@RequestBody TxrRequest request) {
		boolean b = txrService.txr(request.getAmount(), request.getFromAccNum(), request.getToAccNum());
		TxrResponse response = new TxrResponse();
		response.setStatus(b ? "Txr success" : "Txr failed");
		return response;
	}

}
