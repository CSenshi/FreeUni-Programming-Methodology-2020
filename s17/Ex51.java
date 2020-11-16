package s17;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ მეთოდი რომელიც გადაცემული ტექსტიდან შლის დუბლირებულ სიმბოლოებს,
 * 
 * ანუ თუ ტექსტში რომელიმე სიმბოლო მეორდება, უნდა დარჩეს მხოლოდ ყველაზე მარცხენა.
 */
public class Ex51 extends ConsoleProgram {

	public void run() {
		// Input
		String input = readLine("Input: ");

		// Evaluate
		String s = removeDuplicates(input);

		// Print Result
		println("Removed Duplicates: " + s);
	}

	private String removeDuplicates(String input) {
		String res = ""; // final result

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);

			// check if exists in duplicates string
			if (res.indexOf(c) == -1) {
				res += c; // append to result string
			}
		}
		return res;
	}
}
