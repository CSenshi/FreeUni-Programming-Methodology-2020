package s14;

import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * გააკეთეთ Paint-ის ფანქრის ანალოგიური ხელსაწყო. 
 * 
 * კერძოდ, მაუსის ყოველ მოძრაობაზე ეკრანზე დაამატეთ გაფერადებული წრეწირები იმავე წერტილში სადაც მაუსი მდებარეობს.
 */
public class Ex41 extends GraphicsProgram {

	private RandomGenerator rgen;
	private final int R = 50;

	@Override
	public void init() {
		rgen = RandomGenerator.getInstance();
		addMouseListeners();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		GOval oval = new GOval(2 * R, 2 * R);

		int x = e.getX() - R;
		int y = e.getY() - R;

		oval.setFilled(true);
		oval.setColor(rgen.nextColor());

		add(oval, x, y);
	}
}
