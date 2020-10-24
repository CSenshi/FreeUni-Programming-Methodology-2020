package s06;

import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.ConsoleProgram;
import acm.program.GraphicsProgram;
import stanford.karel.*;

/*
 * კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათი საშუალო არითმეტიკული.
 */
public class Ex15 extends ConsoleProgram {

	@Override
	public void run() {
		int a = readInt();
		int b = readInt();

		double result = ((double) (a + b)) / 2;
		println(result);
	}

}
