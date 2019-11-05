package com.accont.dao.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.core.io.Resource;

import com.accont.dao.AccountDao;
import com.accont.model.Account;

public class CsvAccountDao implements AccountDao {
	private Resource csvResource;

	public void setCsvResource(Resource csv) {
		this.csvResource = csv;
	}

	public List<Account> findAll() throws Exception {
		List<Account> results = new ArrayList<Account>();
		DateFormat fmt = new SimpleDateFormat("MMddyyyy");
		BufferedReader bf = new BufferedReader(new FileReader(csvResource.getFile()));
		String line;
		while ((line = bf.readLine()) != null) {
			String[] fields = line.split(",");
			String accountNo = fields[0];
			BigDecimal balance = new BigDecimal(fields[1]);
			Date lastPaidOn = fmt.parse(fields[2]);
			Account account = new Account(accountNo, balance, lastPaidOn);
			results.add(account);
		}
		bf.close();
		return results;
	}
}
