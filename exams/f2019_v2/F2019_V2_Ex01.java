package exams.f2019_v2;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

public class F2019_V2_Ex01 extends GraphicsProgram {

	private final int SQUARE_SIZE = 50;

	private GRect blueSquare;
	private GRect yellowSquare;

	private JButton leftButton;
	private JButton rightButton;

	private double dx, dy; // (vx, vy) of blueSquare
	private final int V = 3; // velocity of yellowSquare on x axis

	private final int RANDOM_TIMER = 3000; // in miliseconds
	private final int SLEEP_TIME = 10; // in miliseconds

	private RandomGenerator rgen;

	@Override
	public void init() {
		// Buttons
		leftButton = new JButton("left");
		rightButton = new JButton("right");
		add(leftButton, SOUTH);
		add(rightButton, SOUTH);

		// Squares
		// IMPORTANT! add yellowSquare after adding blueSquare
		blueSquare = new GRect(SQUARE_SIZE, SQUARE_SIZE);
		blueSquare.setFilled(true);
		blueSquare.setColor(Color.BLUE);
		add(blueSquare); // same as add(blueSquare, 0, 0);

		yellowSquare = new GRect(SQUARE_SIZE, SQUARE_SIZE);
		yellowSquare.setFilled(true);

		yellowSquare.setColor(Color.YELLOW);
		add(yellowSquare, (getWidth() - SQUARE_SIZE) / 2, (getHeight() - SQUARE_SIZE) / 2);

		// Initialize velocities with starting values
		dx = 3;
		dy = 0;

		rgen = RandomGenerator.getInstance();

		addActionListeners();
	}

	@Override
	public void run() {
		// counter to keep track of "time"
		// every time when counter reaches (RANDOM_TIMER / SLEEP_TIME)
		// then RANDOM_TIMER milisecond passes
		int counter = 0;
		
		while (true) {
			// 1. Move Blue Square
			blueSquare.move(dx, dy);

			// 2. Check for collision
			if (collision()) {
				removeAll();
				return;
			}

			// 3. Pause and check if 3 seconds are passed
			pause(SLEEP_TIME);
			counter++;
			if (counter == RANDOM_TIMER / SLEEP_TIME) {
				// 4. If 3 seconds are passed, randomize (dx. dy) and reset counter
				counter = 0;
				randomize();
			}
		}
	}

	private boolean collision() {
		// Get all 4 point coordinates of blueSquare
		double x0 = blueSquare.getX(), x1 = x0 + SQUARE_SIZE;
		double y0 = blueSquare.getY(), y1 = y0 + SQUARE_SIZE;

		// Check if any of 4 points of blueSquare are inside of yellowSquare
		return (getElementAt(x0, y0) == yellowSquare) || (getElementAt(x0, y1) == yellowSquare)
				|| (getElementAt(x1, y0) == yellowSquare) || (getElementAt(x1, y1) == yellowSquare);

	}

	private void randomize() {
		// 1. Randomize dx in range(-3, 3)
		dx = rgen.nextDouble(-3, 3);
		// 2. Calculate dy according to dx
		dy = Math.sqrt(9 - dx * dx);
		// 3. Randomize dy's sign (can be positive or negative)
		if (rgen.nextBoolean()) {
			dy *= -1;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == leftButton) {
			yellowSquare.move(-V, 0);
		} else if (e.getSource() == rightButton) {
			yellowSquare.move(V, 0);
		}

	}
}
