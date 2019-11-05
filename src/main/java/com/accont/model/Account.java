package com.accont.model;

import java.math.BigDecimal;
import java.util.Date;

public class Account {
	private String accountNo;
	private BigDecimal balance;
	private Date lastPaidOn;

	public Account(String accountNo, BigDecimal balance, Date lastPaidOn) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.lastPaidOn = lastPaidOn;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public Date getLastPaidOn() {
		return lastPaidOn;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("Account{");
		sb.append("accountNo='").append(accountNo).append('\'');
		sb.append(", balance=").append(balance);
		sb.append(", lastPaidOn=").append(lastPaidOn);
		sb.append('}');
		return sb.toString();
	}
}
