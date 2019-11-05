package com.accont;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.accont.service.AccountService;

public class ConsoleApp {
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AccountService accountService= (AccountService) context.getBean("accountService");
		System.out.println(accountService.getFindDelinquetAccounts());

	}
}
