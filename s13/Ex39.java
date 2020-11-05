package s13;

import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * დაწერეთ პროგრამა სადაც იქნება კანვასზე ბურთის მოძრაობა მარცხენა კედლის შუა წერტილიდან მარჯვენა კედლამდე. 
 */
public class Ex39 extends GraphicsProgram {

	private final int R = 50;
	private final int dx = 5, dy = 0;
	private final int sleepTime = 5;

	@Override
	public void run() {
		// Create oval
		GOval oval = new GOval(2 * R, 2 * R);
		int x = 0;
		int y = getHeight() / 2 - R;
		oval.setFilled(true);
		add(oval, x, y);

		// Move
		while (oval.getX() < getWidth() - 2 * R) {
			oval.move(dx, dy);
			pause(sleepTime);
		}

	}

}
