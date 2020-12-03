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
		int[][] matrix = { { 0, 1, 1, 0, 0, 1, 0, 0 }, { 0, 1, 1, 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1, 1, 0, 0 },
				{ 0, 0, 1, 1, 1, 1, 0, 0 }, };

		// Evaluate
		int result = getMaxSquare(matrix);

		// Print
		println(result);
	}

	// 1. Iterate over all (x0, y0) coordinates representing the starting point of
	// rectangle
	private int getMaxSquare(int[][] matrix) {
		int maxSquare = 0;

		// Select start point (x0, y0)
		for (int x0 = 0; x0 < matrix.length; x0++) {
			for (int y0 = 0; y0 < matrix[x0].length; y0++) {
				// find max area of rectangles with starting point of (x0, y0)
				int maxArea = maxSquareWithStartPoint(x0, y0, matrix);
				maxSquare = Math.max(maxArea, maxSquare);
			}
		}
		return maxSquare;
	}

	// 2. Iterate over all (x1, y1) coordinates representing the ending point of
	// rectangle and return max Area of rectangle with
	// starting point = (x0, y0) and ending point = (x1, y1)
	private int maxSquareWithStartPoint(int x0, int y0, int[][] matrix) {
		int maxArea = 0;
		for (int x1 = 0; x1 < matrix.length; x1++) {
			for (int y1 = 0; y1 < matrix[x1].length; y1++) {
				boolean isRect = checkRect(x0, y0, x1, y1, matrix);
				if (isRect) {
					int area = (x1 - x0 + 1) * (y1 - y0 + 1);
					maxArea = Math.max(maxArea, area);
				}
			}
		}
		return maxArea;
	}

	// 3. Check if rect with starting coordinates (x0, y0) and ending coordinates
	// (x1, y1) is rectangle of 1s
	private boolean checkRect(int x0, int y0, int x1, int y1, int[][] matrix) {
		for (int i = x0; i <= x1; i++) {
			for (int j = y0; j <= y1; j++) {
				if (matrix[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
