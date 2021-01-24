package exams.f2019_v1;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JTextField;

import acm.graphics.GLine;
import acm.graphics.GPoint;
import acm.program.GraphicsProgram;

public class F2019_V1_Ex01 extends GraphicsProgram {

	private JTextField xField;
	private JTextField yField;
	private JButton addButton;
	private JButton removeButton;

	private List<GPoint> points;

	public void init() {
		// 1. Initialization
		xField = new JTextField(5);
		yField = new JTextField(5);
		addButton = new JButton("add");
		removeButton = new JButton("remove");
		points = new ArrayList<GPoint>();

		// 2. Add to canvas
		add(xField, SOUTH);
		add(yField, SOUTH);
		add(addButton, SOUTH);
		add(removeButton, SOUTH);

		// 3. Add listeners
		addActionListeners();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1. Get Input
		String xStr = xField.getText();
		String yStr = yField.getText();

		// 2. Check if they are both valid integers
		if (!isValidInteger(xStr, yStr)) {
			return;
		}

		// 3. Add or remove given point from points List
		int x = Integer.parseInt(xStr);
		int y = Integer.parseInt(yStr);
		GPoint point = new GPoint(x, y);
		if (e.getSource() == addButton) {
			points.add(point);
		} else if (e.getSource() == removeButton) {
			points.remove(point);
		}

		// 4. Clear the screen and draw everything
		removeAll();
		for (int i = 1; i < points.size(); i++) {
			// 4.1 Get last and current point
			GPoint lastPoint = points.get(i - 1);
			GPoint currPoint = points.get(i);

			// 4.2 Create line by connecting last and current points
			add(new GLine(lastPoint.getX(), lastPoint.getY(), currPoint.getX(), currPoint.getY()));
		}
	}

	// Check isValidInteger by manually checking for characters
	private boolean isValidInteger(String xStr, String yStr) {
		// Check 1: non empty
		if (xStr.isEmpty() || yStr.isEmpty()) {
			return false;
		}

		// Check 2: Only Integers
		for (int i = 0; i < xStr.length(); i++) {
			char c = xStr.charAt(i);
			if (c != '-' && '0' > c || c > '9') {
				return false;
			}
		}

		for (int i = 0; i < yStr.length(); i++) {
			char c = yStr.charAt(i);
			if (c != '-' && '0' > c || c > '9') {
				return false;
			}
		}
		return true;
	}

	// Check isValidInteger by trying to parse as int
	// if error occures catch and return false
	private boolean isValidInteger2(String xStr, String yStr) {
		try {
			int x = Integer.parseInt(xStr);
			int y = Integer.parseInt(yStr);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
