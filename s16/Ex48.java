package s16;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგვყავს ტექსტი პროგრამამ უნდა დაბეჭდოს სტატისტიკა რომელი სიმბოლო რამდენჯერ გვხვდება.
 */
public class Ex48 extends ConsoleProgram {

	public void run() {
		// Input
		String input = readLine("Input ");

		// Evaluate/Print
		countAllCharacters(input);
	}

	private void countAllCharacters(String input) {
		String visitedChars = "";
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);

			// 1. Check if already counted characted
			if (visitedChars.indexOf(ch) != -1)
				continue;

			// 2. if new character (not seen yet) -> count, print, add to visited.
			int count = countCharacter(input, ch);
			println(ch + " - " + count);
			visitedChars += ch;
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
