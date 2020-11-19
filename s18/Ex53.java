package s18;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ პროგრამა რომელიც წაიკითხავს თავის თავს ფაილიდან და დაბეჭდავს კონსოლში.
 */
public class Ex53 extends ConsoleProgram {

	public void run() {
		// Read Content
		String content = readContent("s18/test.txt");

		// Check If Error
		if (content == null)
			return;

		// Evaluate
		int symbolCount = countSymbols(content);
		int wordCount = countWords(content);
		int sentenceCount = countSentences(content);
		int sentencesWithDot = countSentences(content, ".");
		int sentencesWithQuestionMark = countSentences(content, "?");
		int sentencesWithExclamationPoint = countSentences(content, "!");

		// Print Results
		println("Total Symbols: " + symbolCount);
		println("Total Words: " + wordCount);
		println("Total Sentences: " + sentenceCount);
		println("Total Sentences Ending with . : " + sentencesWithDot);
		println("Total Sentences Ending with ? : " + sentencesWithQuestionMark);
		println("Total Sentences Ending with ! : " + sentencesWithExclamationPoint);
	}

	private String readContent(String fileName) {
		try {
			String content = "";
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = br.readLine(); // 1. read current line

				if (line == null) { // 2. if (line == null) => there are no more lines to read
					break;
				}

				// 3. at this point (line != null) => there are more lines to read
				content += line + '\n'; // 4. append content current line
			}
			br.close();
			return content;
		} catch (Exception e) {
			println(e);
		}
		return null;
	}

	private int countSymbols(String content) {
		return content.length();
	}

	private int countWords(String content) {
		StringTokenizer st = new StringTokenizer(content);
		return st.countTokens();
	}

	private int countSentences(String content) {
		return countSentences(content, ".?!");
	}

	private int countSentences(String content, String marks) {
		StringTokenizer st = new StringTokenizer(content, marks);
		return st.countTokens() - 1;
	}

}
