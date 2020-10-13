package s7;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან წაიკითხეთ ნამდვილი რიცხვი და დაბეჭდეთ მისი მთელი ნაწილი და მისი წილადი ნაწილი. 
 * 
 * მაგალითად მომხმარებელმა თუ შეიყვანა 3.14 თქვენმა პროგრამამ უნდა დაბეჭდოს 3 და 0.14
 */
public class Ex17 extends ConsoleProgram {

	@Override
	public void run() {
		// Read Input
		double input = readDouble();

		// Evaluate
		int denominator = (int) input;
		double fraction = input - denominator;

		// Print result
		println("denominator = " + denominator);
		println("fraction = " + fraction);
	}

}
