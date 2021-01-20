package com.ex;

import java.util.Scanner;

public class MainApplication {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String output = "";
		String command = "";
		
		while(true) {
			System.out.println("명령어를 입력하세요");
			command = scan.nextLine();
			
			if ( "gugu".equals(command) ) {
				GuGu gg = new GuGu();
				System.out.println("단을 입력하세요");
				command = scan.nextLine();
				output = gg.gugu(command);
				
				System.out.println(command + "단은");
				System.out.print(output);
		
			} else if ( "exit".equals(command) ) {
				break;
			}
			
		}
		
		
	}

}
