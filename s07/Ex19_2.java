package s07;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან წაიკითხეთ მთელი რიცხვი n და შემდეგ n ცალი მთელი რიცხვი.
 * 
 * დაბეჭდეთ შეყვანილ რიცხვებს შორის მაქსიმალური და მინიმალური.
 */
public class Ex19_2 extends ConsoleProgram {

	@Override
	public void run() {
		// Read Input
		int n = readInt();

		// Evaluate
		int minNumber = Integer.MAX_VALUE; // -2147483648 = -(2^31)
		int maxNumber = Integer.MIN_VALUE; // 2147483647 = (2^31-1)

		for (int i = 0; i < n; i++) {
			int input = readInt();

			// If input is less than currently saved minNumber, update minNumber
			if (input < minNumber) {
				minNumber = input;
			}

			// If input is bigger than currently saved maxNumber, update maxNumber
			if (input > maxNumber) {
				maxNumber = input;
			}
		}

		// Print result
		println("Max Number = " + maxNumber);
		println("Min Number = " + minNumber);
	}

}
