package s12;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

/*
 * თქვენი ამოცანაა გააკეთოთ მონეტის აგდების სიმულაციები.
 * 
 * დათვალეთ საშუალოდ რამდენჯერ უნდა ავაგდოთ მონეტა რათა 3-ჯერ ზედიზედ ამოვიდეს ბორჯღალო.
 */
public class Ex36 extends ConsoleProgram {

	private int MAX_COUNT = 1000;
	private int CONSECUTIVE_HEADS = 3;

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
		println("Average coin flips to get 3x heads in a row is: " + avg);
	}

	public int simulateCoinFlip(RandomGenerator rgen) {
		// Assume that if
		// flipCoin == true  ---> coin flipped "HEAD"
		// flipCoin == false ---> coin flipped "TALL"

		int counter = 0; // total flips
		int consecutive = 0; // consecutive heads count
		while (consecutive < CONSECUTIVE_HEADS) {
			boolean flipCoin = rgen.nextBoolean();
			counter++;
			if (flipCoin)
				consecutive++;
			else
				consecutive = 0;
		}
		return counter;
	}
}
