package s13;

import acm.graphics.GOval;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;
import acm.util.RandomGenerator;

/*
 * წინა ამოცანის გაგრძელება.
 * დაამატეთ ვერტიკალური კედლებიდან ასხლეტვა, ანუ ბურთი მოძრაობს მარცხენა კედლიდან მარჯვნივ. 
 * როგორც კი მარჯვენა კედელს დაეტაკება იმავე სიჩქარით უნდა გააგრძელოს მოძრაობა მაჯვენა კედლიდან მარცხნივ. 
 * როგორც კი მარცხენა კედელს დაეტაკება უნდა გააგრძელოს მარჯვნივ და ა.შ. უსასრულოდ. 
 */
public class Ex40 extends GraphicsProgram {

	private final int R = 50;
	private final int sleepTime = 5;
	private int dx = 5, dy = 0;

	@Override
	public void run() {
		// Create oval
		GOval oval = new GOval(2 * R, 2 * R);
		int x = 0;
		int y = getHeight() / 2 - R;
		oval.setFilled(true);
		add(oval, x, y);

		// Move
		while (true) {
			oval.move(dx, dy);
			pause(sleepTime);
			
			if (oval.getX() <= 0 || oval.getX() >= getWidth() - 2*R) {
				dx *= -1;
			}
		}

	}

}
