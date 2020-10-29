package s12;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/*
 * მომხმარებელს შეყავს 0 დან 36 მდე რიცხვი, 
 * შემდეგ ხდება რულეტკის დატრიალების სიმულაცია, 
 * 
 * კონსოლში უნდა დაიბეჭდოს ამოსული რიცხვი და მოიგო თუ არა დადებულმა რიცხვმა
 */
public class Ex37 extends ConsoleProgram {

	private final int ROULETTE_MAX = 36;

	@Override
	public void run() {
		// Random Generator
		RandomGenerator rgen = RandomGenerator.getInstance();

		simulateRouletteRoll(rgen);
	}

	public void simulateRouletteRoll(RandomGenerator rgen) {
		// Read user Input
		int userNumber = readInt("Please select yout number: ");

		// Simulate Rolling [0, 36] range
		int rolledNumber = rgen.nextInt(0, ROULETTE_MAX);

		// Check Result
		if (userNumber == rolledNumber) {
			println("You Won!");
		} else {
			println("You Lost! Rolled Number is: " + rolledNumber);
		}
	}
}
