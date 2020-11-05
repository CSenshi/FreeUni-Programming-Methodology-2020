package s14;

import java.awt.event.MouseEvent;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

/*
 * მაუსის კლიკზე იმავე ადგილზე ჩნდება ბურთი და იწყებს ვარდნას ძირს, 
 * თუ მაუსს სხვა ადგილზე ვაკლიკებ ბურთი გადადის ახალ ადგილზე და იქედან იწყებს ვარდნას
 */
public class Ex44 extends GraphicsProgram {

	private GOval oval;
	private final int R = 75, dy = 1, sleepTime = 2;

	@Override
	public void init() {
		// Add Circle
		oval = new GOval(2 * R, 2 * R);
		oval.setFilled(true);
		add(oval);
		
		// Listeners
		addMouseListeners();
	}

	public void run() {
		while (true) {
			oval.move(0, dy);
			pause(sleepTime);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX(), y = e.getY();
		oval.setLocation(x - R, y - R);
	}
}
