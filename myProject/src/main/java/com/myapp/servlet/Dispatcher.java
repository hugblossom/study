package com.myapp.servlet;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.handler.RequestHandler;

public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, RequestHandler> handlerMap = new HashMap<>();
       
    public Dispatcher() { super(); }
    
    public void init(ServletConfig config) throws ServletException {
    	String encoding = config.getInitParameter("encoding");
    	String handlerConfig = config.getInitParameter("handlerProperties");
    	Properties prop = new Properties();
    	String configPath = config.getServletContext().getRealPath(handlerConfig);
    	
    	try (FileReader fr = new FileReader(configPath)) {
    		prop.load(fr);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	Iterator<?> iter = prop.keySet().iterator();
    	
    	while(iter.hasNext()) {
    		String key = (String) iter.next();
    		String value = prop.getProperty(key);
    		
    		try {
    			Class<?> handlerClass = Class.forName(value);
    			RequestHandler rh = (RequestHandler) handlerClass.newInstance();
    			handlerMap.put(key, rh);
    		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}