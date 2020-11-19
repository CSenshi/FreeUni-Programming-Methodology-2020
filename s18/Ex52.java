package s18;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import acm.program.ConsoleProgram;

/*
 * დაწერეთ პროგრამა რომელიც წაიკითხავს თავის თავს ფაილიდან და დაბეჭდავს კონსოლში.
 */
public class Ex52 extends ConsoleProgram {

	private final String fileName = "s18/Ex52.java";

	public void run() {
		// Read File Content
		String content = readContent(fileName);

		// Print File Content
		println("Content of file " + fileName);
		println(content);
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

}
