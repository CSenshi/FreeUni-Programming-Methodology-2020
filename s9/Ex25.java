package s9;

import acm.program.ConsoleProgram;
import s9.Ex26;

/*
 * მომხმარებელს შეჰყავს ორი რიცხვი თქვენმა პროგრამამ უნდა დაბეჭდოს ამ ორი რიცხვის უმცირესი საერთო ჯერადი.
 */
public class Ex25 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int a = readInt();
		int b = readInt();

		// Evaluate
		int res = LCM(a, b);

		// Print
		println("LCM(" + a + ", " + b + ") = " + res);
	}

	private int LCM(int a, int b) {
		if (a < b) {
			// swap: (a,b) = (b,a)
			int tmp = b;
			b = a;
			a = tmp;
		}

		// at this point (a >= b) ALWAYS!
		int lcm = a;
		while (true) {
			if (lcm % a == 0 && lcm % b == 0)
				return lcm;
			lcm+=a;
		}
	}

}
