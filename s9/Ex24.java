package s9;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს n ის გამყოფების რაოდენობა
 */
public class Ex24 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int n = readInt();

		// Evaluate/Print
		printDivisors(n);
	}

	private void printDivisors(int n) {
		for (int i = 1; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				int divisor = i;
				int quotient = n / i;

				println(divisor);
				if (quotient != divisor)
					println(quotient);
			}
		}
	}

}
