package exams.f2019_v2;

import acm.program.ConsoleProgram;

public class F2019v2Ex02 extends ConsoleProgram {

	@Override
	public void run() {
		int[][] world = new int[][] { 
				{ 0, 0, 0, 0 }, 
				{ 1, 1, 2, 1 }, 
				{ 0, 1, 2, 1 }, 
				{ 0, 2, 0, 0 } 
		};

		String[] insturctions = new String[] {
				"move", // 0x0 -> 0x1
				"left", "left", "left", // turn right
				"move", // 0x1 -> 1x1 (Eat Apple)
				"move", // 1x1 -> 1x2 (Eat Apple)
				"move", // 1x2 -> X (Stone!)
				"left", "left", "left", // turn right
				"move", // 1x2 -> 0x2
				"left", "left", "left", // turn right
				"move" // 0x2 -> 0x1 (Eat Apple)
		};

		int result = apples(world, insturctions);
		int realResult = 3;
		if (result == realResult) {
			println("Test 1: True (result = " + realResult + ")");
		} else {
			println("Test 1: False");
			println("\tYour Result: \"" + result + "\"");
			println("\tReal Result: \"" + realResult + "\"");
		}
	}

	private int apples(int[][] world, String[] instructions) {
		return 0;
	}
}
