package s10;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეყავს მთელი რიცხვი.
 * დაბეჭდეთ რიცხვი რომელიც მიიღება ციფრების შებრუნებით
 *
 * მაგალითად: 1256 -> 6521
 */
public class Ex30 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int n = readInt();

		// Evaluate
		int result = reverse(n);

		// Print
		println("reverse of " + n + " is " + result);
	}

	private int reverse(int n) {
		int result = 0;
		
		while(n > 0) {
			result = result * 10 + n%10;
			n /= 10;
		}
		
		return result;
	}
}
