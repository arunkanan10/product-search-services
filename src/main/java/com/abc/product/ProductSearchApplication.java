package com.abc.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ProductSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductSearchApplication.class, args);
	}
}
