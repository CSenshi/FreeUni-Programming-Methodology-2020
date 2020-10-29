package s12;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/*
 * მომხმარებელს შეყავს 0 დან 36 მდე რიცხვი, 
 * შემდეგ ხდება რულეტკის დატრიალების სიმულაცია, 
 * 
 * კონსოლში უნდა დაიბეჭდოს ამოსული რიცხვი და მოიგო თუ არა დადებულმა რიცხვმა
 */
public class Ex38 extends ConsoleProgram {

	private final int ROULETTE_MAX = 36;
	private final int STARTING_MONEY = 1000;

	@Override
	public void run() {
		// Random Generator
		RandomGenerator rgen = RandomGenerator.getInstance();

		// Welcome Message
		printWelcomeMessage();

		// Game
		int currentBalance = STARTING_MONEY;
		while (currentBalance > 0) {
			println("\nMoney: " + currentBalance);
			int balanceChange = simulateRouletteRoll(rgen, currentBalance);
			currentBalance += balanceChange;
		}

		// Exit Message
		printExitMessage();
	}

	private void printExitMessage() {
		println();
		println("Congratulations!");
		println("You Lost All Your Money!");
		println("Do Not Play Roulette and Don't Do Drugs Kids!");
	}

	private void printWelcomeMessage() {
		println("Welcome to FreeUni Roulette 2020!");
		println("Your Starting Money is " + STARTING_MONEY + "Gel!");
		println("Good Luck! Have Fun!");
		println("");
	}

	public int simulateRouletteRoll(RandomGenerator rgen, int currentBalance) {
		// Read user Input
		int userNumber = inputRollNumber();
		int userBet = inputBetNumber(currentBalance);

		// Simulate Rolling [0, 36] range
		int rolledNumber = rgen.nextInt(0, ROULETTE_MAX);

		// Check Result
		if (userNumber == rolledNumber) {
			println("You Won!");
			return userBet * 2;
		} else {
			println("You Lost! Rolled Number is: " + rolledNumber);
			return -userBet;
		}
	}

	private int inputRollNumber() {
		int userNumber = readInt("Bet Number: ");
		while (userNumber < 0 || userNumber > ROULETTE_MAX) {
			userNumber = readInt("Number Out Of Range! Please select your number in range [0,36]: ");
		}
		return userNumber;
	}

	private int inputBetNumber(int currentBalance) {
		int userBet = readInt("Bet Money: ");
		while (userBet < 0 || userBet > currentBalance) {
			userBet = readInt("Money Out Of Range! Please select your amount in range [0," + currentBalance + "]: ");
		}
		return userBet;
	}

}
