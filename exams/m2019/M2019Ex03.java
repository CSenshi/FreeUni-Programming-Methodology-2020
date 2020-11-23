package exams.m2019;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GObject;
import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class M2019Ex03 extends GraphicsProgram {

	private final int CIRCLE_D = 100;
	private final int DELAY = 100;

	private GOval flick;
	private RandomGenerator rgen;

	@Override
	public void init() {
		flick = null;
		rgen = RandomGenerator.getInstance();
		addMouseListeners();
	}

	public void run() {
		while (true) {
			// 1. Pause by given time
			pause(DELAY);

			// 2. Check if there is object to flick and color if is
			if (flick != null) {
				colorOval();
			}
		}
	}

	private void colorOval() {
		int rand = rgen.nextInt(0, 5);
		if (rand == 0) {
			flick.setFillColor(Color.GREEN);
			flick = null;
		} else if (rand == 1) {
			flick.setFillColor(Color.RED);
		} else if (rand == 2) {
			flick.setFillColor(Color.BLUE);
		} else if (rand == 3) {
			flick.setFillColor(Color.BLACK);
		} else {
			flick.setFillColor(Color.YELLOW);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// 1. Get Object on (x, y) coordinates
		GObject obj = getElementAt(e.getX(), e.getY());

		// 2. Check if object is null and draw if is else flick
		if (obj == null) {
			drawNewCircle(e.getX(), e.getY());
		} else {
			flickerCircle((GOval) obj);
		}
	}

	private void drawNewCircle(int x, int y) {
		int circleX = x - CIRCLE_D / 2;
		int circleY = y - CIRCLE_D / 2;

		GOval oval = new GOval(circleX, circleY, CIRCLE_D, CIRCLE_D);
		oval.setFilled(true);
		oval.setFillColor(rgen.nextColor());
		add(oval);
	}

	private void flickerCircle(GOval obj) {
		flick = obj;
	}
}
