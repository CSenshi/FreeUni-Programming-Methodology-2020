package s21;

import java.awt.Font;
import java.util.Arrays;

import acm.program.ConsoleProgram;

/*
 * (2018 წლის გამოცდის ამოცანა)
 * 
 * მატრიცას ეწოდება მაგიური თუკი ის კვადრატულია(n x n-ზე) და მასში არის ყველა რიცხვი 1-დან n^2-ის ჩათვლით.
 * 
 * თქვენი მიზანია დაწეროთ magicMatrix მეთოდი,
 * რომელიც შეამოწმებს არის თუ არა მატრიცა მაგიური და თუკი მაგიურია მაშინ დააბრუნებს true-ს თუ არა მაშინ false-ს.
 */
public class Ex58 extends ConsoleProgram {

	public void run() {
		// 1. Input
		int[][] matrix = 
			{{ 9, 7, 3 }, 
			 { 1, 2, 6 }, 
			 { 5, 8, 4 }};

		// 2. Evaluate
		boolean result = magicMatrix(matrix);

		// 3. Print
		println(result);
	}

	private boolean magicMatrix(int[][] matrix) {
		// 1. Check if is square
		int n = matrix.length;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i].length != n) {
				return false;
			}
		}

		// 2. Check for all number occurances
		boolean[] allNums = new boolean[n * n];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int curNum = matrix[i][j];
				if (curNum < 1 || curNum > n * n)
					return false;
				allNums[curNum - 1] = true;
			}
		}

		for (int i = 0; i < allNums.length; i++) {
			if (!allNums[i]) {
				return false;
			}
		}

		return true;
	}
}
