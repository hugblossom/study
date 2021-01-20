package com.ex;

public class GuGu {

	public String gugu(String input) {
		String result = "";
		int dan = Integer.parseInt(input);
		
		
			for ( int j=1; j < 10; j++ ) {
			
				if ( j % 3 == 0 ) {
					result += dan + "x" + j + "=" + (dan*j) + "\n";
				} else {
					result += dan + "x" + j + "=" + (dan*j) + "\t";	
				}
				
			}
		
			return result;
	}
	
}
