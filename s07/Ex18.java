package s07;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან წაიკითხეთ ორი მთელი რიცხვი და დაბეჭდეთ მათ შორის მაქსიმალური.
 */
public class Ex18 extends ConsoleProgram {

	@Override
	public void run() {
		// Read Input
		int input1 = readInt();
		int input2 = readInt();

		// Evaluate
		int max;
		if (input1 > input2) {
			max = input1;
		} else {
			max = input2;
		}
		
		// Print result
		println("denominator = " + max);
	}

}
