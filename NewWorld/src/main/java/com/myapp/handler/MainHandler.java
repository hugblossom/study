package com.myapp.handler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainHandler implements DefaultHandler { // NullHandler라고도 함
	String view = "main";
	
	public String doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
	
	return view;
	}
}
