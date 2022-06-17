package com.revature;

import com.revature.exceptions.Number13Exception;

public class Calculator {

	public int add(int a, int b) {
		if(a == 8 && b == 5 ) {
			throw new Number13Exception();
		}
		return a + b;
		
		public int subtract(int a, int b) {
			return 0;
		}
		
		public int sumOfAnArray(int[] intArr) {
			return 0;
		}
	}
}
