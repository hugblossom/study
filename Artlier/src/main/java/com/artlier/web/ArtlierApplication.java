package com.artlier.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.artlier")
public class ArtlierApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtlierApplication.class, args);
	}

}
