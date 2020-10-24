package s07;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან წაიკითხეთ სამი მთელი რიცხვი და დაბეჭდეთ მათი საშუალო ჰარმონიული.
 * შეგახსენებთ, რომ სამი რიცხვის საშუალო ჰარმონიულის გამოთვლის ფორმულა არის:
 * 
 *  _________1__________
 *  (1/a) + (1/b) + (1/c) 
 */
public class Ex16 extends ConsoleProgram {

	@Override
	public void run() {
		// Input
		int a = readInt();
		int b = readInt();
		int c = readInt();

		// Evaluate
		double aReverse = 1.0 / a;
		double bReverse = 1.0 / b;
		double cReverse = 1.0 / c;
		double result = 1.0 / (aReverse + bReverse + cReverse);

		// Print result
		println(result);
	}

}
