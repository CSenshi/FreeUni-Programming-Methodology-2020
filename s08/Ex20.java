package s08;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან წაიკითხეთ n, შემდეგ წაიკითხეთ n ცალი მთელი რიცხვი და დაბეჭდეთ ჯამი.
 */
public class Ex20 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int n = readInt("Input N: ");

		// Evaluate
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int input = readInt("Enter Number #" + (i + 1) + ": ");
			sum += input;
		}

		// Print result
		println("Sum = "+ sum);
	}

}
