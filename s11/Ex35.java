package s11;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/*
 * თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები 
 * და დათვალოთ საშუალოდ რამდენჯერ უნდა ავაგდოთ მონეტა რათა ამოვიდეს ბორჯღალო
 */
public class Ex35 extends ConsoleProgram {

	private int MAX_COUNT = 1000;

	@Override
	public void run() {
		// Random Generator
		RandomGenerator rgen = RandomGenerator.getInstance();

		// Simulate Multiple Coin Flips
		int total = 0;
		for (int i = 0; i < MAX_COUNT; i++) {
			int cur = simulateCoinFlip(rgen);
			total += cur;
		}
		double avg = (double) total / MAX_COUNT;

		// Print Result
		println("Average coin flips to get tall is " + avg);
	}

	public int simulateCoinFlip(RandomGenerator rgen) {
		// Assume that if
		// flipCoin == false ---> coin flipped "HEAD"
		// flipCoin == true ---> coin flipped "TALL"

		int counter = 1;
		while (true) {
			boolean flipCoin = rgen.nextBoolean();
			if (flipCoin)
				break;
			counter++;
		}
		return counter;
	}
}
