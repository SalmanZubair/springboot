package com.lambda;

public class Check {

	public static void main(String args[]) {

		int num = 3, prime = 2, i;

		while (true) {

			for ( i = 2; i <= num/2 ; i++) {
				if (num % i == 0) 
					break;
			}
			
			if( i > num/2){
				System.out.println(num);
				prime++;
			}
				
			
			
			if (num >= 100)
				break;
			
			num++;

		}

	}

}
