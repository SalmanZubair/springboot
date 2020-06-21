package com.lambda;

public class LambdaBasic2 {

	public static void main(String args[]) {

		Operation addition = (int a, int b) -> a + b;

		Operation sub = (int a, int b) -> a - b;

		Operation div = (int a, int b) -> a / b;
		Greeting gt = (String grt) -> grt;

		System.out.println(new LambdaBasic2().operate(10, 5, addition));

		System.out.println(new LambdaBasic2().operate(10, 5, sub));

		System.out.println(new LambdaBasic2().operate(10, 5, div));
		
		System.out.println(gt.greet("SALMAN"));
		
		
		

	}

	interface Operation {

		int operation(int a, int b);

	}
	
	interface Greeting {

		String greet(String greet);

	}
	

	private int operate(int a, int b, Operation op) {

		return op.operation(a, b);

	}

}