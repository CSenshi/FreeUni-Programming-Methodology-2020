package s19;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგყვავს n და შემდეგ n ცალი მთელი რიცხვი
 * 
 * იპოვეთ და დაბეჭდეთ ამ რიცხვებს შორის ორი მაქსიმალური რიცხვი.
 */
public class Ex55 extends ConsoleProgram {

	public void init() {
		this.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 30));
	}

	public void run() {
		// Input
		int input[] = readInput();

		// Find first 2 maximums
		boolean isSorted = isSorted(input);

		// Print
		println();
		println("Array Given: " + Arrays.toString(input));
		if (isSorted) {
			println("Sorted");
		} else {
			println("Not Sorted");
		}
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

	private boolean isSorted(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			if (input[i] > input[i + 1]) {
				return false;
			}
		}
		return true;
	}

}
