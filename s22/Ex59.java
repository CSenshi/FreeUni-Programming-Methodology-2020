package s22;

import acm.program.ConsoleProgram;

/*
 *(2018 წლის გამოცდის ამოცანა)
 * გადმოგეცემათ nxm-ზე მატრიცა რომელშიც მხოლოდ 0-ები და 1-ები წერია. 
 * მეთოდმა უნდა დააბრუნოს ამ მატრიცის ყველაზე დიდი ქვემართკუთხედის ზომა(ელემენტების რაოდენობა),
 * რომელიც მხოლოდ 1-ებისგან შედგება.
 *  
 *  მაგალითად:
 *  01100100
 *  01111100
 *	00111100
 *	00111100
 *
 *	ამ მატრიცაში ყველაზე დიდი შიდა მართკუთხედი, რომელიც სულ ერთიანებისგან შედგება არის 12 ზომის:
 *  
 *  01 1001 00
 *  01|1111|00
 *	00|1111|00
 *	00|1111|00
 *
 *  შესაბამისად ამ მატრიცაზე მეთოდმა უნდა დააბრუნოს 12. 
 *  ჩათვალეთ რომ გადმოცემულ მატრიცაში ერთი უჯრა მაინც იქნება რომელშიც წერია 1.
 */
public class Ex59 extends ConsoleProgram {

	public void run() {
		// Input
		int[][] matrix = {
				{ 0, 1, 1, 0, 0, 1, 0, 0 }, 
				{ 0, 1, 1, 1, 1, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0, 0 },
		};

		// Evaluate
		int result = getMaxSquare(matrix);

		// Print
		println(result);
	}

	// 1. Iterate over all (width, height) pairs
	private int getMaxSquare(int[][] matrix) {
		int maxSquare = 0;
		for (int width = 1; width <= matrix.length; width++) {
			for (int height = 1; height <= matrix[0].length; height++) {
				boolean isOnesRect = isCurSquare(width, height, matrix);
				if (isOnesRect) {
					int curArea = width * height;
					maxSquare = Math.max(curArea, maxSquare);
				}
			}
		}
		return maxSquare;
	}

	// 2. Iterate over all rectangle with size of (width, height) and check if one
	// of them is rectangle with only ones
	private boolean isCurSquare(int width, int height, int[][] matrix) {
		for (int x = 0; x <= matrix.length - width; x++) {
			for (int y = 0; y <= matrix[x].length - height; y++) {
				boolean isRect = checkRect(x, y, width, height, matrix);
				if (isRect) {
					return true;
				}
			}
		}
		return false;
	}

	// 3. Check if rect with coordinates (x, y) with size of (width,height) is
	// rectangle of 1s
	private boolean checkRect(int x, int y, int width, int height, int[][] matrix) {
		for (int i = x; i < x + width; i++) {
			for (int j = y; j < y + height; j++) {
				if (matrix[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
