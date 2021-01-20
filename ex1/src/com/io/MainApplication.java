package com.io;

import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainApplication {
	
	final static String PATH = "c:/JavaTest/Test.txt";

	public static void main(String[] args) throws IOException, FileNotFoundException {
		
		readWithBuffer();
		
	}
	
	public static void fileWrite(String data) {
		try {
			
			FileWriter fileWrite = new FileWriter(PATH, true);
			
					fileWrite.write(data);
					fileWrite.close();
					
			
		} catch (IOException ioe) {
			
			System.out.print(ioe.getMessage());
			
		} finally {
			
		}
	}
	
	public static void readFile() throws IOException, FileNotFoundException {
		
		byte[] b = new byte[1024];
		FileInputStream fis = new FileInputStream(PATH);
		
		fis.read(b);
		fis.close();
		
		System.out.println(new String(b));
		
	}
	
	public static void readWithBuffer() throws IOException, FileNotFoundException {
		
		BufferedReader br = new BufferedReader(new FileReader(PATH));
		
		while(true) {
			
			String lineData = br.readLine();
			
			if (lineData == null) {
				
				break;
				
			}
			
			System.out.println(lineData);
			
		}
		
	} 
	
	
}
