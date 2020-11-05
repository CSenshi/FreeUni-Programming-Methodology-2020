package s14;

import java.awt.event.MouseEvent;

import acm.graphics.GLine;
import acm.program.GraphicsProgram;

/*
 * Paint-ის მონაკვეთის ხატვის გაკეთება.
 * 
 * ჯერ აჭერ მაუსს, ფიქსირდება ერთი წვერო,
 * მერე მაუსის მოძრაობისას მონაკვეთიც მოძრაობს,
 * რადგან მეორე წვერო არაა დაფიქსირებული და კლიკით ფიქსირდება მეორე წვეროც.
 */
public class Ex42 extends GraphicsProgram {

	private boolean startPointSet;
	private boolean endingPointSet;
	private GLine line;

	@Override
	public void init() {
		startPointSet = false;
		endingPointSet = false;
		addMouseListeners();
	}

	public void mouseClicked(MouseEvent e) {
		if (!startPointSet) {
			int x = e.getX();
			int y = e.getY();
			startPointSet = true;
			line = new GLine(x, y, x, y);
			add(line);
		} else if (!endingPointSet) {
			endingPointSet = true;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (startPointSet && !endingPointSet) {
			line.setEndPoint(e.getX(), e.getY());
		}
	}
}
