package s07;

import acm.program.ConsoleProgram;
/*
 * კონსოლიდან წაიკითხეთ მთელი რიცხვი n 
 * შემდეგ n ჯერ დაბეჭდეთ “hello ” + i, სადაც i იცვლება 0-დან (n-1)-მდე.
 */
public class Ex19_0 extends ConsoleProgram {

	@Override
	public void run() {
		// Read Input
		int n = readInt();

		// Evaluate and print
		for (int i = 0; i < n; i++) {
			println("Hello " + i);
		}
	}

}
