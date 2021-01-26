package com.myapp.config;

import java.io.IOException;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ConnectionPool extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ConnectionPool() { super(); }
    
    public void init() throws ServletException {
    	jdbcDriver();
    	createPool();
    }
    
    private void jdbcDriver() {
    	try {
    		class.forName("com.mysql.jdbc.Driver");
    	} catch(ClassNotFoundException cnfe) {
    		throw new RuntimeException("driver load fail", cnfe);
    	}
    }
    
    private void createPool() {
    	try {
			String url		= "jdbc:mysql://localhost/stephy?&useSSL=false";
			String user		= "root";
			String password	= "2002";
			ConnectionFactory conn = new DriverManagerConnectionFactory(url,user,password);			
			PoolableConnectionFactory pool = new PoolableConnectionFactory(conn,null);	
			GenericObjectPoolConfig<PoolableConnection> poolconf = new GenericObjectPoolConfig<PoolableConnection>();
			poolconf.setTimeBetweenEvictionRunsMillis(60000L*5L);
			poolconf.setMinIdle(5);
			poolconf.setMaxTotal(100);
			poolconf.setTestWhileIdle(true);
			GenericObjectPool<PoolableConnection> connpool = new GenericObjectPool<>(pool,poolconf);
			pool.setPool(connpool);
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("myapp", connpool);
		}catch(Exception e) {
			System.out.print(e);
		}
    }

}