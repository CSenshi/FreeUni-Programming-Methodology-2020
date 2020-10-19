package s9;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის უდიდესი საერთო გამყოფი.
 */
public class Ex26 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int a = readInt();
		int b = readInt();

		// Evaluate
		int gcd = GCD(a, b);

		// Print
		println("GCD(" + a + ", " + b + ") = " + gcd);
	}

	private int GCD(int a, int b) {
		if (a < b) {
			// swap: (a,b) = (b,a)
			int tmp = b;
			b = a;
			a = tmp;
		}

		// at this point (a >= b) ALWAYS!
		int res = 1;
		for (int i = a; i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				res = i;
				break;
			}
		}
		return res;
	}
}