package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrdersClientApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(OrdersClientApplication.class, args);
		OrdersClient ordersClient=ctx.getBean(OrdersClient.class);
		System.out.println(ordersClient);
		ordersClient.getRentals();
	}
	@Bean
	public  OrdersClient  ordersClient()
	{
		return  new OrdersClient();
	}
}
