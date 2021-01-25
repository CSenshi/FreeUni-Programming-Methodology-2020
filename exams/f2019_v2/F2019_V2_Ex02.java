package exams.f2019_v2;

import acm.program.ConsoleProgram;

public class F2019_V2_Ex02 extends ConsoleProgram {
	
	@Override
	public void run() {
		int[][] world = new int[][] { //
				{ 1, 0, 0, 0 }, //
				{ 1, 1, 2, 1 }, //
				{ 0, 1, 2, 1 }, //
				{ 0, 2, 0, 0 }, //
		};

		String[] insturctions = new String[] { "move", // 0x0 -> 0x1
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
		int realResult = 4;
		if (result == realResult) {
			println("Test 1: True (result = " + realResult + ")");
		} else {
			println("Test 1: False");
			println("\tYour Result: \"" + result + "\"");
			println("\tReal Result: \"" + realResult + "\"");
		}
	}

	private int apples(int[][] world, String[] instructions) {
		/*-
		 * Directions:
		 * 		dir == 0 -> right 
		 * 		dir == 1 -> up 
		 * 		dir == 2 -> left 
		 * 		dir == 3 -> down		
		 * 
		 * Starting position (0, 0)
		 * Starting Direction (East) (Right)
		 * Starting Total Apples 0
		 */
		int x = 0, y = 0;
		int dir = 0;
		int totalApples = 0;

		// Edge Case: Check if starting point contains apple
		if (world[x][y] == 1) {
			totalApples++;
			world[x][y] = 0;
		}

		// Iterate over each instruction and do them
		for (String inst : instructions) {
			if (inst.equals("move")) {
				// Get Directions
				int dx, dy;
				if (dir == 0) { // right
					dx = 1;
					dy = 0;
				} else if (dir == 1) { // up
					dx = 0;
					dy = -1;
				} else if (dir == 2) { // left
					dx = -1;
					dy = 0;
				} else /* if (dir == 3) */ { // down
					dx = 0;
					dy = 1;
				}

				// Advance
				int nextX = x + dx, nextY = y + dy;

				// Check 1: InBounds
				if (nextX < 0 || nextY < 0 || nextY >= world.length || nextX >= world[nextY].length) {
					continue; // Do Nothing (Just Stay)
				}

				// Check 2: Stone
				if (world[nextY][nextX] == 2) {
					continue; // Do Nothing (Just Stay)
				}

				// Check 3: Apple
				if (world[nextY][nextX] == 1) {
					totalApples++; // Increment apple's count
					world[nextY][nextX] = 0; // remove apple from world
				}

				// Change current location
				x = nextX;
				y = nextY;
			} else { // inst.equals("left")
				// Turn left by incrementing dir value modulo 4
				// Main idea is for (dir+1) to be left rotation of (dir)
				dir = (dir + 1) % 4;
			}
		}
		return totalApples;
	}

}
