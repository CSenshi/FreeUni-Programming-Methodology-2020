package s15;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ პრედიკატ მეთოდი რომელსაც გადაეცემა სტრინგი და რომელიც დაადგენს არის თუ არა მოცემული ტექსტი პალინდრომი
 */
public class Ex47 extends ConsoleProgram {

	public void run() {
		// Input
		String s = readLine("Input String: ");

		// Evaluate
		boolean res = isPalindrome(s);

		// Print Result
		println("isPalindrome? " + res);
	}

	private boolean isPalindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			char c1 = s.charAt(i);
			char c2 = s.charAt(s.length() - i - 1);

			if (c1 != c2)
				return false;
		}
		return true;

	}

}
