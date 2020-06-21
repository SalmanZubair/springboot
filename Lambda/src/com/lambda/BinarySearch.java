package com.lambda;

public class BinarySearch {

	public static void main(String[] args) {

		System.out.println("Started");
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int key = 7;
		int last = arr.length;

		int mid = last / 2;
		int first = 0;

		while (first <= last) {

			if (arr[mid] < key)
				first = mid + 1;
			else if (arr[mid] == key) {
				System.out.println(key + " is present at location  :: " + mid);
				break;
			} else
				last = mid - 1;
			
			mid = (first + last)/2;
		}

		if (first > last)
			System.out.println("hgsafdj");
	}
}
