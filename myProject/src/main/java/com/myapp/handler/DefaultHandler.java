package com.myapp.handler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface DefaultHandler {
	public void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException;
}
