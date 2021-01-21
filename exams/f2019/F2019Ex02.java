package exams.f2019;

import java.awt.Font;

import acm.program.ConsoleProgram;

public class F2019Ex02 extends ConsoleProgram {

	@Override
	public void run() {
		/*-
		 * 1. B - 5000 | [Iphone]
		 * 2. B - 4900 | [Iphone, Mouse]
		 * 3. B - 100  | [Iphone, Mouse, MacBook]
		 * 3. B - 4750 | [Iphone, Mouse, Keyboard]
		 * Result: Keyboard
		 */
		int budget = 8000;
		String[] items = new String[] { "iPhone", "Mouse", "MacBook", "Keyboard" };
		int[] costs = new int[] { 3000, 100, 4800, 150 };
		String result = greedyConsumer(budget, items, costs);	
		println("Test 1: " + result);
		
		/*-
		 * 1. B - 5000 | [Iphone]
		 * 2. B - 4950 | [Iphone, Mouse]
		 * 3. B - 2000 | [Iphone, Mouse, MacBook]
		 * 4. B - 8000 | []
		 * 5. B - 5500 | [Galaxy S20]
		 * Result: Galaxy S20
		 */
		budget = 8000;
		items = new String[] { "iPhone", "Mouse", "MacBook", "Audi", "Galaxy S20" };
		costs = new int[] { 3000, 50, 6000, 20000, 2500 };
		result = greedyConsumer(budget, items, costs);	
		println("Test 2: " + result);

		/*-
		 * 1. B - 5000 | [Iphone]
		 * 2. B - 4950 | [Iphone, Mouse]
		 * 3. B - 2000 | [MacBook]
		 * 4. B - 8000 | []
		 * Result: MacBook
		 */
		budget = 8000;
		items = new String[] { "iPhone", "Mouse", "MacBook", "Audi" };
		costs = new int[] { 3000, 50, 6000, 20000 };
		result = greedyConsumer(budget, items, costs);	
		println("Test 3: " + result);
	}

	private String greedyConsumer(int budget, String[] items, int[] costs) {
		for (int i = items.length - 1; i >= 0; i--) {
			if (costs[i] <= budget) {
				return items[i];
			}
		}
		return "";
	}

}
