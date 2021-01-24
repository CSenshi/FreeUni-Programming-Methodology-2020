package exams.f2019_v2;

import acm.program.ConsoleProgram;

public class F2019v2Ex03 extends ConsoleProgram {

	@Override
	public void run() {
		String[][] test = new String[][]{ 
				{ "Hello old world", "old:world" }, 
				{ "Hello", ""},
				{ "Will someone tell me the answer?", "someone:me"},
				{ "aaa aa bbbbb bb cc c", "bbbbb:bb"},
				{ "world world", ""},
				{ "qwe asd zxc", "", },
				{ "", "", "" },
		};

		for (int i = 0; i < test.length; i++) {
			// Input
			String testString = test[i][0];
			String realResult = test[i][1];

			// Evaluate
			String result = acquaintance(testString);

			// Print
			if (realResult.equals(result)) {
				println("Test " + (i + 1) + ": True");
			} else {
				println("Test " + (i + 1) + ": False");
				println("\tYour Result: \"" + result + "\"");
				println("\tReal Result: \"" + realResult + "\"");
			}
		}
	}

	private String acquaintance(String text) {
		return "";
	}
}
