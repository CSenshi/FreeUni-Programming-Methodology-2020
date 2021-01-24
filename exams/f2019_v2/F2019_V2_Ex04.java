package exams.f2019_v2;

import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class F2019_V2_Ex04 extends ConsoleProgram {

	@Override
	public void run() {
		// Scores table #1
		HashMap<String, Integer> scores1 = new HashMap<String, Integer>();
		scores1.put("Gela", 15);
		scores1.put("Vano", 20);
		scores1.put("Petre", 13);
		scores1.put("Ilia", 17);

		// Scores table #2
		HashMap<String, Integer> scores2 = new HashMap<String, Integer>();
		scores2.put("Salome", 30);
		scores2.put("Vano", 15);
		scores2.put("Ilia", 24);

		// Merge all scores tables into arraylist
		ArrayList<HashMap<String, Integer>> scores = new ArrayList<HashMap<String, Integer>>();
		scores.add(scores1);
		scores.add(scores2);

		// Call our function
		HashMap<String, ArrayList<Integer>> mergedScores = merge(scores);
		println(mergedScores);
	}

	private HashMap<String, ArrayList<Integer>> merge(ArrayList<HashMap<String, Integer>> maps) {
		return null;
	}
}
