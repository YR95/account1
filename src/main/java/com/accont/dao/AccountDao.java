package com.accont.dao;

import java.util.List;

import com.accont.model.Account;

public interface AccountDao {
	List<Account> findAll() throws Exception;
}
