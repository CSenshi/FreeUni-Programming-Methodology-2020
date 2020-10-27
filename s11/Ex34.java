package s11;

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * კანვასზე დახატეთ 1000 შემთხვევითი რადიუსის მქონე შემთხვევითი ფერით გაფერადებული წრე, შემთხვევით კოორდინატებზე.
 */
public class Ex34 extends GraphicsProgram {

	private int MAX_COUNT = 1000;

	@Override
	public void run() {
		// Random Generator
		RandomGenerator rgen = RandomGenerator.getInstance();
		for (int i = 0; i < MAX_COUNT; i++) {
			drawRandomCircle(rgen);
		}
	}

	public void drawRandomCircle(RandomGenerator rgen) {
		int r = rgen.nextInt(0, getHeight() / 2);
		int x = rgen.nextInt(0, getWidth() - 2 * r);
		int y = rgen.nextInt(getHeight() - 2 * r);
		Color c = rgen.nextColor();

		GOval oval = new GOval(x, y, 2 * r, 2 * r);
		oval.setFilled(true);
		oval.setFillColor(c);
		add(oval);
	}
}
