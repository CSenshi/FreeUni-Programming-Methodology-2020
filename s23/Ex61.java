package s23;


import acm.program.ConsoleProgram;

/*
 * კონსოლიდან შეგვყავს რიცხვი m და n, შემდეგ n ცალი რიცხვი. 
 * 
 * პროგრამამ უნდა იპოვოს შეყვანილი რიცხვებიდან წყვილი რომელთა ჯამი არის m.
 * 
 */
public class Ex61 extends ConsoleProgram {

	public void run() {
		// Input
		int m = readInt("Input m: ");
		int[] list = readInput();

		// Evaluate/Print
		findSum(list, m);
	}

	private int[] readInput() {
		// 1. Read N
		int n = readInt("Input n: ");

		// 2. Read total of N integers
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = readInt("Input number #" + (i + 1) + ": ");
		}
		return arr;
	}

	private void findSum(int[] list, int m) {
		for (int i = 0; i < list.length; i++) {
			for (int j = i + 1; j < list.length; j++) {
				int x = list[i], y = list[j];
				if (x + y == m) {
					println("Found Sum! " + x + "+" + y + "=" + m);
					return;
				}
			}
		}
		println("Sum not found");
	}
}
