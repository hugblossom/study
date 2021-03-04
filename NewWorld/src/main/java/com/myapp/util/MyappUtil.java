package com.myapp.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MyappUtil {
	
	public static JSONObject requestToJson(HttpServletRequest request) throws Exception {
		BufferedReader reader;
		StringBuilder sb = new StringBuilder();
		InputStream is = request.getInputStream();
		
		if ( is != null ) {
			reader = new BufferedReader(new InputStreamReader(is));
			char[] charBuffer = new char[128];
			int read = -1;
			
			while ( (read = reader.read(charBuffer)) > 0 ) {
				sb.append(charBuffer, 0 ,read);
			}
		}
		
		String data = sb.toString();
		
		JSONParser parser = new JSONParser();
		return (JSONObject) parser.parse(data);
	}
	
	public static String nowDateTime() {
		return LocalDateTime.now().toString();
	}

}
