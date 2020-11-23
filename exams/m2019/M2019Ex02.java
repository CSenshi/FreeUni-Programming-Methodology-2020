package exams.m2019;

import java.awt.Font;

import acm.program.ConsoleProgram;

public class M2019Ex02 extends ConsoleProgram {

	//
	public void run() {
		// All Should Be True
		println("Test Palindromes");
		int trueArr[] = { 121, 44, 7, 13231, 6472746 };
		for (int i = 0; i < trueArr.length; i++) {
			boolean result = isPalindrom(trueArr[i]);
			if (result) {
				println("PASS: " + trueArr[i] + " -> " + result);
			} else {
				println("FAIL: " + trueArr[i] + " -> " + result);
			}
		}

		// All Should Be False
		println("\nTest No Palindromes");
		int falseArr[] = { 10, 1000, 654, 13, 1354328 };
		for (int i = 0; i < falseArr.length; i++) {
			boolean result = isPalindrom(falseArr[i]);
			if (!result) {
				println("PASS: " + falseArr[i] + " -> " + result);
			} else {
				println("FAIL: " + falseArr[i] + " -> " + result);
			}
		}
	}

	/** Solution 1: Reverse **/
	private boolean isPalindrom(int x) {
		int y = reverse(x);
		return x == y;
	}

	/*
	 * Reverse int number and return int
	 * 
	 * Example: 1234 -> 4321
	 */
	private int reverse(int x) {
		int y = 0;
		while (x > 0) {
			y *= 10;
			y += x % 10;
			x /= 10;
		}
		return y;
	}

	/** Solution 2: One By One **/
	private boolean isPalindrom2(int x) {
		while (x > 9) { // Iterate until one decimal is left
			int l = leftMost(x);
			int r = rightMost(x);
			if (r != l) {
				return false;
			}
			x = decreaseNum(x);
		}
		return true;
	}

	/*
	 * Return the left number of int
	 * 
	 * Example: 1234 -> return 1
	 */
	private int leftMost(int x) {
		int cur = 1;
		while (cur * 10 < x) {
			cur *= 10;
		}
		return x / cur;
	}

	/*
	 * Return the right number of int
	 * 
	 * Example: 1234 -> return 4
	 */
	private int rightMost(int x) {
		return x % 10;
	}

	/*
	 * Return number without left and right numbers.
	 *
	 * Example: 12345 -> return 234
	 */
	private int decreaseNum(int x) {
		// 1. Remove LeftMost
		int cur = 1;
		while (cur * 10 < x) {
			cur *= 10;
		}
		x = x % cur;

		// 2. Remove RightMost
		x = x / 10;

		return x;
	}

}
