package s14;

import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/*
 * წრეწირის drag ით გადაადგილება
 */
public class Ex43 extends GraphicsProgram {

	private GOval oval;
	private int R;

	public void init() {
		// Add Circle
		R = 100;
		oval = new GOval(2 * R, 2 * R);
		int x = getWidth() / 2 - R;
		int y = getHeight() / 2 - R;
		oval.setFilled(true);
		add(oval, x, y);

		// Listeners
		addMouseListeners();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Getting Object
		int x = e.getX(), y = e.getY();
		Object obj = getElementAt(x, y);

		// Check if this object is our GOval, if not return
		if (obj != oval) {
			return;
		}

		// At this point obj is our GOval, so we will change its location
		oval.setLocation(x - R, y - R);
	}
}
