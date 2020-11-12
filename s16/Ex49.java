package s16;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ stringToInteger მეთოდი, რომელსაც გადაეცემა სტრინგი და აბრუნებს მთელ რიცხვს.
 * 
 * ჩათვალეთ, რომ გადაცემული სტრინგი მხოლოდ ციფრებისგან შედგება და არ იწყება 0-ით.
 * ასევე ჩათვალეთ, რომ დაბრუნებული მნიშვნელობა დადებითია და ეტევა int-ში.
 * 
 * მაგალითად: “234” გადაცემის შემთხვევაში მეთოდმა უნდა დააბრუნოს 234. 
 */
public class Ex49 extends ConsoleProgram {

	public void run() {
		// Input
		String numStr = readLine("Input: ");

		// Evaluate
		int res = stringToInt(numStr);

		// Print Result
		println(res);
	}

	// Implementation with only positive integers
	private int stringToInt(String numStr) {
		int res = 0;

		for (int i = 0; i < numStr.length(); i++) {
			char curChar = numStr.charAt(i);
			int curInt = curChar - '0';

			res *= 10;
			res += curInt;
		}

		return res;
	}

	// Implementation with negative value support
	private int stringToIntV2(String numStr) {
		int res = 0;
		boolean isNegative = numStr.charAt(0) == '-';

		// Skip 1st char ('-' symbol) if negative
		if (isNegative)
			numStr = numStr.substring(1);

		for (int i = 0; i < numStr.length(); i++) {
			char curChar = numStr.charAt(i);
			int curInt = curChar - '0';

			res *= 10;
			res += curInt;
		}

		// Make num negative if '-' sign at start
		if (isNegative)
			res *= -1;

		return res;
	}

}
