package com.myapp.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.mysql.cj.jdbc.MysqlDataSource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfig {
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean(name="mysqlDS")
	public DataSource dataSource() {
		MysqlDataSource dataSource = new MysqlDataSource();
		dataSource.setUrl(url);
		dataSource.setUser(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
}
