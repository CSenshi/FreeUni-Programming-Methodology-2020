package s23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგვყავს სახელები, მანამ სანამ არ შევიყვანთ ცარიელ სტრინგს.
 * 
 * დაბეჭდეთ სახელი და მის გასწვრივ რაოდენობა რამდენჯერ შევიყვანეთ ეს სახელი.
 * 
 */
public class Ex62 extends ConsoleProgram {

	public void run() {
		// Input
		List<String> list = readInput();

		// Evaluate
		Map<String, Integer> counts = evaluateNameFrequencies(list);

		// Print Result
		printFrequencies(counts);
	}

	private List<String> readInput() {
		List<String> result = new ArrayList<>();
		while (true) {
			String s = readLine("Input name:");
			if (s.equals("")) {
				break;
			}
			result.add(s);
		}
		return result;
	}

	private Map<String, Integer> evaluateNameFrequencies(List<String> list) {
		Map<String, Integer> frequencies = new HashMap<String, Integer>();
		
		for (String name : list) {			
			if (frequencies.containsKey(name)) {
				int currentCount = frequencies.get(name);
				frequencies.put(name, currentCount + 1);
			} else {
				frequencies.put(name, 1);
			}
		}
		
		return frequencies;
	}

	private void printFrequencies(Map<String, Integer> counts) {
		for (String name : counts.keySet()) {
			int count = counts.get(name);
			println(name + " - " + count);
		}
	}

}
