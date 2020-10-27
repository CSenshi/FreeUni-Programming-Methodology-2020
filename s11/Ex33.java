package s11;

import java.awt.Color;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * დაწერეთ პროგრამა რომელიც კანვასზე დახატავს შემთხვევითი ფერის მქონე წრეწირს, 
 * რაიდიუსიც შემთხვევით აირჩეით შეზღუდული რეინჯიდან.
 */
public class Ex33 extends GraphicsProgram {

	@Override
	public void run() {
		// Random Generator
		RandomGenerator rgen = RandomGenerator.getInstance();

		int r = rgen.nextInt(0, getHeight() / 2);
		int x = getWidth() / 2 - r;
		int y = getHeight() / 2 - r;
		Color c = rgen.nextColor();

		GOval oval = new GOval(x, y, 2 * r, 2 * r);
		oval.setFilled(true);
		oval.setFillColor(c);
		add(oval);
	}
}
