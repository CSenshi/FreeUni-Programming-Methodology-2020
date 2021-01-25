package exams.f2019_v2;


import acm.program.ConsoleProgram;

public class F2019_V2_Ex03 extends ConsoleProgram {

	@Override
	public void run() {
		String[][] test = new String[][] { //
				{ "Hello old world", "old:world" }, //
				{ "Hello", "" }, //
				{ "Will someone tell me the answer?", "someone:me" }, //
				{ "aaa aa bbbbb bb cc c", "bbbbb:bb" }, //
				{ "world world", "" }, //
				{ "qwe asd zxc", "", }, //
				{ "", "" },//
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
		// 1. Split String into words (words are separated by space)
		String[] words = text.split(" ");

		// 2. Check all words pairs
		String result = "";
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				// Checking pair (w1, w2)
				String w1 = words[i], w2 = words[j];

				if (areClose(w1, w2)) {
					// Generate current result string
					String currResult = w1 + ":" + w2;
					// if current result string has length bigger than old result, change result
					if (currResult.length() > result.length()) {
						result = currResult;
					}
				}
			}
		}
		return result;
	}

	private boolean areClose(String w1, String w2) {
		// Check 1: same strings are not close
		if (w1.equals(w2))
			return false;

		// Change: make w1 to always have length less than w2
		if (w1.length() > w2.length()) {
			String tmp = w1;
			w1 = w2;
			w2 = tmp;
		}

		// w1.length() <= w2.length()
		int j = 0;
		for (int i = 0; i < w1.length(); i++) {
			// Find j such that w2[j] == w1[i]
			while (j < w2.length() && w2.charAt(j) != w1.charAt(i)) {
				j++;
			}

			// Check: if j >= w2.length() we reached the end of w2 and could not find w1[i]
			if (j >= w2.length()) {
				return false;
			}

			// At this point we found such j, so we increment j and go to next iteration
			j++;
		}
		return true;
	}
}
