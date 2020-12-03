package s22;

import java.util.ArrayList;
import java.util.Arrays;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგვყავს რიცხვები მანამ სანამ არ შეიყვანთ -1-ს, დაბეჭდეთ შეყვანილი რიცხვები შებრუნებული მიმდევრობით.
 */
public class Ex60 extends ConsoleProgram {

	public void run() {
		// Input
		ArrayList<Integer> list = readInput();

		// Evaluate
		ArrayList<Integer> reversed = reverseList(list);

		// Print
		println(reversed);
	}

	private ArrayList<Integer> readInput() {
		ArrayList<Integer> inputs = new ArrayList<>();

		while (true) {
			int input = readInt();
			if (input == -1) {
				return inputs;
			}
			inputs.add(input);
		}
	}

	private ArrayList<Integer> reverseList(ArrayList<Integer> list) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = list.size() - 1; i >= 0; i--) {
			result.add(list.get(i));
		}
		return result;
	}
}
