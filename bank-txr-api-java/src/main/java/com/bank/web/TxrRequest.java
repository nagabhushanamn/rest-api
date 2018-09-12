package com.bank.web;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TxrRequest {

	private double amount;
	private String fromAccNum;
	private String toAccNum;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getFromAccNum() {
		return fromAccNum;
	}

	public void setFromAccNum(String fromAccNum) {
		this.fromAccNum = fromAccNum;
	}

	public String getToAccNum() {
		return toAccNum;
	}

	public void setToAccNum(String toAccNum) {
		this.toAccNum = toAccNum;
	}

}
