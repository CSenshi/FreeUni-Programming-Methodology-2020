package s8;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;;

/*
 * ხაზებით ბადის დახატვა 10x10 ზე
 */
public class Ex21 extends GraphicsProgram {

	private int N_ROW = 10;
	private int N_COL = 10;

	@Override
	public void run() {
		drawHorizontalLines();
		drawVerticalLines();

	}

	// Draw N_ROW Horizontal lines
	private void drawHorizontalLines() {
		for (int i = 0; i < N_ROW; i++) {
			int y = i * getHeight() / N_ROW;
			GLine line = new GLine(0, y, getWidth(), y);
			add(line);
		}
	}

	// Draw N_COL Vertical lines
	private void drawVerticalLines() {
		for (int i = 0; i < N_COL; i++) {
			int x = i * getWidth() / N_COL;
			GLine line = new GLine(x, 0, x, getHeight());
			add(line);
		}
	}

}
