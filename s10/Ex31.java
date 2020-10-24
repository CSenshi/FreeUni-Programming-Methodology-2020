package s10;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ პროგრამა რომელიც დაადგენს შეყვანილი რიცხვი მარტივია თუ არა
 */
public class Ex31 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int n = readInt();

		// Evaluate
		boolean result = isPrime(n);

		// Print
		if (result) {
			println("Number " + n + " is prime!");
		} else {
			println("Number " + n + " is not prime!");
		}

	}

	private boolean isPrime(int n) {
		if (n < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
