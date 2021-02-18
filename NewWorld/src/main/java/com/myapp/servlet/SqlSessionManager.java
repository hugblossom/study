package com.myapp.servlet;

import java.io.IOException;
import java.io.Reader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

@WebServlet(loadOnStartup = 1)
public class SqlSessionManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static SqlSessionFactory factory;
	
    public SqlSessionManager() { super(); }
    
    @Override
    public void init() {
    	Reader reader = null;
    	
    	try {
    		reader = Resources.getResourceAsReader("com/myapp/mybatis/mybatis-config.xml");
    		factory =new SqlSessionFactoryBuilder().build(reader);
    	} catch (Exception e) {}
    }
    
    public static SqlSessionFactory getSqlSessionFactory() {
    	return factory;
    }

}
