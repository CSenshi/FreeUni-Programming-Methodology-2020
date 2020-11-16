package s17;

import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის დუბლირებულ სიმბოლოებს.
 * 
 * ანუ თუ ტექსტიში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ ყველაზე მარცხენა.
 */
public class Ex50 extends ConsoleProgram {

	public void run() {
		// Input
		String input = readLine("Input: ");

		// Evaluate
		int count = countWords(input);

		// Print Result
		println("Total Words: " + count);
	}

	// Count tokens by hand
	private int countWords(String input) {
		int total = 0;
		StringTokenizer tokenizer = new StringTokenizer(input);
		while (tokenizer.hasMoreTokens()) {
			tokenizer.nextToken();
			total++;
		}
		return total;
	}

	// Count tokens with StringTokenizer countTokens() method
	private int countWords2(String input) {
		StringTokenizer tokenizer = new StringTokenizer(input);
		return tokenizer.countTokens();
	}
}
