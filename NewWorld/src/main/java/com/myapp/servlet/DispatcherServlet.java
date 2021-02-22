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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myapp.handler.DefaultHandler;

@WebServlet(urlPatterns = {"/main/*", "/member/*", "/board/*"}, loadOnStartup = 2)
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String encoding = "UTF-8";
	private Map<String, DefaultHandler> handlerMap = new HashMap<>();
       
    public DispatcherServlet() { super(); }
    
    public void init(ServletConfig config) throws ServletException {
    	Properties prop = new Properties();
    	String configPath = config.getServletContext().getRealPath("/WEB-INF/handler.properties");
    	
    	try (FileReader fr = new FileReader(configPath)) {
    		prop.load(fr);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	
    	Iterator<?> iter = prop.keySet().iterator();
    	
    	while(iter.hasNext()) {
    		String key = (String) iter.next();
    		String value = prop.getProperty(key); // getProperty() = key의 value를 가져온다
    		
    		try {
    			Class<?> handlerClass = Class.forName(value);
    			DefaultHandler rh = (DefaultHandler) handlerClass.newInstance();
    			handlerMap.put(key, rh);
    		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
    			e.printStackTrace();
    		}
    	}
    	
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String key = uri.substring(path.length() + 1);
		String view = null;
		String preFix = "/WEB-INF/views/";
		String sufFix = ".jsp";
		
		DefaultHandler handler = handlerMap.get(key);
		
		try {
			if (handler == null) {
				handler = handlerMap.get("error/404");
				view = handler.doHandle(request, response);
			}
			view = handler.doHandle(request, response);
		} catch ( Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher dsp = request.getRequestDispatcher(preFix + view + sufFix);
		dsp.forward(request, response);
	} 
}
