package com.lambda;

public class Pallindrome {

	public static void main(String[] args) {
		String str = "ABBDCCsDBBA";
		int i, flag = 1, len = str.length();
		
		for ( i = 0; i<(len+1)/2; i++){
			
			if(str.charAt(i) != str.charAt(len-i-1)){
				System.out.println("Not Pallindrome");
			flag=0;
			}
		}
		
		if(flag == 1)
			System.out.println("pallindrome");
		
	}
	
}
