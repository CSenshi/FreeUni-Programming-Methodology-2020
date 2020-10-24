package s10;

import acm.program.ConsoleProgram;

/*
 * მოხმარებელს შეყავს მთელი რიცხვი n.
 * 
 * პროგრამამ უნდა დაბეჭდოს ფიბონაჩის მიმდევრობის მე-n წევრი.
 */
public class Ex29 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int n = readInt();

		// Evaluate
		int result = fib(n);

		// Print
		println("fib(" + n + ") = " + result);
	}

	private int fib(int n) {
		int f1 = 0, f2 = 1;

		for (int i = 0; i < n; i++) {
			int tmp = f1 + f2;
			f1 = f2;
			f2 = tmp;
		}

		return f1;
	}
}
