package exams.f2019_v1;

import java.util.Arrays;

import acm.program.ConsoleProgram;

public class F2019_V1_Ex03 extends ConsoleProgram {

	@Override
	public void run() {
		String[][] test = { 
				{ "123456", "abc345def", "345" }, 
				{ "abcde abcd abc dcbaa", "abcd abc abcde", "abcde" },
				{ "ababab", "baba", "ab" },
				{ "", "", "" },
			};

		for (int i = 0; i < test.length; i++) {
			String s1 = test[i][0];
			String s2 = test[i][1];
			String realRes = test[i][2];
			String result = maxSortedSubString(s1, s2);

			if (realRes.equals(result)) {
				println("Test " + (i + 1) + ": True");
			} else {
				println("Test " + (i + 1) + ": False");
				println("\tYour Result: " + result);
				println("\tReal Result: " + realRes);
			}
		}
	}

	private String maxSortedSubString(String st1, String st2) {
		String result = "";
		for (int i = 0; i < st1.length(); i++) {
			for (int j = i + 1; j < st1.length(); j++) {
				String s = st1.substring(i, j);

				// Check 1: is substring of st2?
				if (!st2.contains(s)) {
					break;
				}

				// Check 2: is Sorted?
				if (!isSorted2(s)) {
					break;
				}

				// Update
				if (result.length() < s.length()) {
					result = s;
				}
			}
		}
		return result;
	}

	// Check isSorted step by step.
	// each one should be bigger than last one
	private boolean isSorted(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) > s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}

	// Check isSorted by comparing reversed string to real one
	private boolean isSorted2(String s) {
		// 1. Convert: String -> char[]
		char[] charArr = s.toCharArray();
		// 2. Sort: char[]
		Arrays.sort(charArr);
		// 3. Convert: char[] -> String
		String sortedS = new String(charArr);
		// 4. Check if reversed is equal to real
		return s.equals(sortedS);
	}

}
