package s10;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ პროგრამა რომელიც იპოვის და დაბეჭდავს 1000000 მდე ყველა მერტივ რიცხვს
 */
public class Ex32 extends ConsoleProgram {

	private final int MAX_COUNT = 1000;

	@Override
	public void run() {
		for (int i = 0; i < MAX_COUNT; i++)
			if (isPrime(i))
				println(i);

	}

	private boolean isPrime(int n) {
		if (n < 2)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
