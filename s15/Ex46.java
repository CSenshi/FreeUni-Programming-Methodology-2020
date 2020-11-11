package s15;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ მეთოდი რომელსაც გადაეცემა სტიგნი და რომელიც აბრუნებს ამ სტრინგშიყველაზე ხშირ სიმბოლოს.
 */
public class Ex46 extends ConsoleProgram {
	public void run() {
		// Input
		String s = readLine("Input String: ");

		// Evaluate
		char res = mostOccuredCharacter(s);

		// Print Result
		println("The most occured symbol is: " + res);
	}

	private char mostOccuredCharacter(String s) {
		char maxChar = 0;
		int maxOcc = 0;
		for (char c = 0; c < 256; c++) {
			int res = countCharacter(s, c);
			if (res > maxOcc) {
				maxOcc = res;
				maxChar = c;
			}
		}
		return maxChar;
	}

	private int countCharacter(String s, char c) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c)
				count++;
		}
		return count;
	}
}
