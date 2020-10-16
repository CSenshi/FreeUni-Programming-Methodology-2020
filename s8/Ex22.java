package s8;

import java.awt.Color;

import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;;

/*
 * ჭადრაკის დაფის დახატვა 8x8 ზე
 */
public class Ex22 extends GraphicsProgram {

	private int N_ROW = 8;
	private int N_COL = 8;

	@Override
	public void run() {
		double cellSize = calculateCellSize();
		drawCheckerboard(cellSize);
	}

	/*
	 * Calculates cell size by evaluating and finding minimal value by which canvas
	 * can be filled in height or in widh
	 */
	private double calculateCellSize() {
		double height = getHeight();
		double width = getWidth();

		double sizeAccordingToWidth = width / N_COL;
		double sizeAccordingToHeight = height / N_ROW;

		if (sizeAccordingToWidth > sizeAccordingToHeight) {
			return sizeAccordingToHeight;
		} else {
			return sizeAccordingToWidth;
		}
	}

	/*
	 * Draw whole checkerboard with N_ROW rows (default 8 rows)
	 */
	private void drawCheckerboard(double cellSize) {
		for (int i = 0; i < N_COL; i++) {
			drawCheckerboardRow(cellSize, i);
		}
	}

	/*
	 * Draw one row of chekerboard with N_COL cells (default 8 cells)
	 */
	private void drawCheckerboardRow(double cellSize, int rowNum) {
		for (int i = 0; i < N_ROW; i++) {
			drawCheckerboardCell(cellSize, rowNum, i);
		}
	}

	/*
	 * Draw one cell of checkerboard on (rowNum, colNum) coordinates with size of
	 * rectSize
	 */
	private void drawCheckerboardCell(double cellSize, int rowNum, int colNum) {
		double x = cellSize * rowNum;
		double y = cellSize * colNum;

		GRect cell = new GRect(x, y, cellSize, cellSize);
		cell.setFilled(true);
		if ((rowNum + colNum) % 2 == 1) {
			cell.setColor(Color.BLACK);
		} else {
			cell.setColor(Color.ORANGE);
		}
		add(cell);
	}

}
