package com.myapp.web.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HCPConfig {
	
	/*
	 * @Bean
	 * 
	 * @ConfigurationProperties(prefix = "spring.datasource.hikari") public
	 * HikariConfig hikariConfig() { return new HikariConfig(); }
	 * 
	 * @Bean(name = "hikariDS") public DataSource datasource() { return new
	 * HikariDataSource(hikariConfig()); }
	 */
}
