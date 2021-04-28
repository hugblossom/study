package com.myapp.web.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import org.apache.ibatis.annotations.Mapper;

@Configuration
@PropertySource("classpath:/application.properties")                                                // = bean name
@MapperScan(value = "com.myapp.web.mapper", annotationClass = Mapper.class, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {
	
	@Autowired
	private ApplicationContext context;
	
	@Bean
	@ConfigurationProperties(prefix = "spring.datasource.hikari")
	public HikariConfig hikariConfig() {
		return new HikariConfig();
	}
	
	@Bean(name = "mybatisDS") // connection pool 생성
	public DataSource dataSource() {
		return new HikariDataSource(hikariConfig());
	}
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setTypeAliasesPackage("com.myapp.web.domain, com.myapp.web.dto");
		bean.setMapperLocations(context.getResources("classpath:/mapper/**.xml"));
		//context.getResources() = 루트경로로부터 파일읽어옴
		return bean.getObject();
	}
	
	@Bean(name = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}
	
}
