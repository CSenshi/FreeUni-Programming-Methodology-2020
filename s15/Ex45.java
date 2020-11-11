package s15;

import acm.program.ConsoleProgram;

/*
 * მომხმარებელს კონსოლიდან შეჰყავს ტექსტი და სიმბოლო. 
 * 
 * თქვენმა პროგრამამ უნდა იპოვოს რამდენჯერ გვხვდება მოცემულ ტექსტში მოცემული სიმბოლო
 */
public class Ex45 extends ConsoleProgram {

	public void run() {
		// Input
		String s = readLine("Input String: ");
		char c = readChar("Input Symbol: ");

		// Evaluate
		int res = countCharacter(s, c);

		// Print Result
		println("Total occurrences of symbol " + c + ": " + res);
	}

	private char readChar(String prompt) {
		while (true) {
			String res = readLine(prompt);
			if (res.length() == 1) {
				return res.charAt(0);
			}
			println("Please enter exactly 1 symbol!");
		}
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
