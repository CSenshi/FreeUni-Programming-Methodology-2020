package s08;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს 1 დან n მდე რიცხვების ჯამი.
 */
public class Ex23 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int n = readInt();

		// Evaluate
		int sum = sumToN(n);

		// Print Result
		println(sum);
	}

	private int sumToN(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += i;
		}
		return sum;
	}

}
