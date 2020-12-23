package s27;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/**
 * მთელ ფორმაზე ბადის დახატვა, ისე რომ ფორმის ზომის ცვლილებაზე ბადის უჯრის ზომაც
 * პროპორციულად იზრდებოდეს.
 */
public class Ex70 extends GraphicsProgram implements ComponentListener {

	int N_ROWS = 10;
	int N_COLS = 10;

	@Override
	public void init() {
		addComponentListener(this);
	}

	@Override
	public void run() {
		drawGrid();
	}

	private void drawGrid() {
		// 1. Draw Horizontal Lines
		for (int i = 0; i < N_ROWS; i++) {
			double y = i * getHeight() / N_ROWS;
			double x0 = 0, x1 = getWidth();

			add(new GLine(x0, y, x1, y));
		}

		// 2. Draw Vertical Lines
		for (int i = 0; i < N_COLS; i++) {
			double x = i * getWidth() / N_COLS;
			double y0 = 0, y1 = getHeight();

			add(new GLine(x, y0, x, y1));
		}
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		removeAll();
		drawGrid();
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
	}
}
