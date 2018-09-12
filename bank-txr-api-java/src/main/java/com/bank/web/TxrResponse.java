package com.bank.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TxrResponse {

	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
