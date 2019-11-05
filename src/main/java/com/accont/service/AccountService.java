package com.accont.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import com.accont.dao.AccountDao;
import com.accont.model.Account;

public class AccountService {
	public List<Account> findDelinquetAccounts;
	AccountDao accountDao;

	private static Date daysAgo(int days) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.DATE, - days);
		return gc.getTime();
	}

	public List<Account> getFindDelinquetAccounts() throws Exception {
		List<Account> delinquetAccounts = new ArrayList<Account>();
		List<Account> allAccounts = accountDao.findAll();
		Date thirtyDaysAgo = daysAgo(30);
		for (Account account : allAccounts) {
			boolean owesMoney = account.getBalance().compareTo(BigDecimal.ZERO) > 0;
			boolean thirtyDaysLate = account.getLastPaidOn().compareTo(thirtyDaysAgo) <= 0;
			if (owesMoney && thirtyDaysLate) {
				delinquetAccounts.add(account);
			}
		}
		return delinquetAccounts;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
}
