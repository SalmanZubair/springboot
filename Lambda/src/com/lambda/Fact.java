package com.lambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

public class Fact {

	
	public static void main(String[] args) {

		LinkedList<String> array = new LinkedList<String>();
		
		array.add("orange");
		array.add("red");
		array.add("orange");
		array.add("red");
		array.add("orange");
		array.add("red");
		
		array.add(0, "green");
		
		for (String string : array) {
			System.out.println(string);
		}
		
		System.out.println("$$$$$$$$$");

		
		Iterator<String> it = array.descendingIterator();
		
		while(it.hasNext())
			System.out.println(it.next());
		
		
		System.out.println(array);
		
	}
}
