package s7;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან წაიკითხეთ მთელი რიცხვი n 
 * შემდეგ n ჯერ დაბეჭდეთ “hello ” + i, სადაც i იცვლება (n-1)-დან 0-მდე.
 */
public class Ex19_1 extends ConsoleProgram {

	@Override
	public void run() {
		// Read Input
		int n = readInt();

		// Evaluate and print
		for (int i = n - 1; i >= 0; i--) {
			println("Hello " + i);
		}
	}

}
