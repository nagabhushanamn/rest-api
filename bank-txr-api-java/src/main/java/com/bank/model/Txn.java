package com.bank.model;

import java.time.LocalDate;

public class Txn {

	private int id;
	private LocalDate date;
	private double amount;
	private TxnType type;

	public Txn(int id, LocalDate date, double amount, TxnType type) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Txn [id=" + id + ", date=" + date + ", amount=" + amount + ", type=" + type + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

}
