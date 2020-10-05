package s5;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import stanford.karel.*;

/*
 * დაწერეთ პროგრამა, რომლიც ეკრანის შუაში გაავლებს ჰორიზონტალურ ხაზს.
 */
public class Ex13 extends GraphicsProgram {

	@Override
	public void run() {
		int height = getHeight();
		int width = getWidth();

		GLine line = new GLine(0, height / 2, width, height / 2);
		add(line);
	}

}
