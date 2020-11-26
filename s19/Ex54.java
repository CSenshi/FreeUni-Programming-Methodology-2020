package s19;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი
 * 
 * იპოვეთ და დაბეჭდეთ ამ რიცხვებს შორის ორი მაქსიმალური რიცხვი.
 */
public class Ex54 extends ConsoleProgram {

	public void init() {
		this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
	}

	public void run() {
		// Input
		int input[] = readInput();

		// Find first 2 maximums
		int maxs[] = findMaximums(input);

		// Print
		println();
		println("1st Maximum: " + maxs[0]);
		println("2nd Maximum: " + maxs[1]);
	}

	private int[] readInput() {
		// 1. Read N
		int n = readInt("Input N: ");

		// 2. Read total of N integers
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt("Input number #" + (i + 1) + ": ");
		}
		return arr;
	}

	/*
	 * Return array of length = 2 where 0th element is the maximum and 1st element
	 * is the second maximum
	 */
	private int[] findMaximums(int[] input) {
		// Initialize array to store our maximums
		// max[0] >= max[1] !!! ALWAYS !!!
		int maxs[] = new int[2];
		maxs[0] = Integer.MIN_VALUE;
		maxs[1] = Integer.MIN_VALUE;

		// Iterate over given input and find maximums
		for (int i = 0; i < input.length; i++) {
			int curNum = input[i];

			if (curNum > maxs[1]) {
				if (curNum > maxs[0]) {
					maxs[1] = maxs[0];
					maxs[0] = curNum;
				} else {
					maxs[1] = curNum;
				}
			}
		}

		return maxs;
	}

}
