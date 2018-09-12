package com.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.bank.repository.AccountRepository;
import com.bank.repository.JpaAccountRepository;
import com.bank.service.TxrService;
import com.bank.service.TxrServiceImpl;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableTransactionManagement
public class AppV3 {

	public static void main(String[] args) {

		// third-party / (can be spring framework) / container ==> application-context

		// init
		System.out.println("--------------------");
		ConfigurableApplicationContext context = null;
		context = SpringApplication.run(AppV3.class, args);
		System.out.println("--------------------");

		// use
		System.out.println("--------------------");
//		TxrService txrService = context.getBean(TxrService.class);
//		txrService.txr(9700.00, "2", "1");
		System.out.println();
		System.out.println("--------------------");

		// destroy
		System.out.println("--------------------");
		// context.close();
		System.out.println("--------------------");

	}

}
