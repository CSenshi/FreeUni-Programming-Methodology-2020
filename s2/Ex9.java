package s2;

import stanford.karel.*;

/*
 * კარელმა უნდა გაამრავლოს ორი რიცხვი, 
 * 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m ცალი ბრილიანტი, 
 * კარელმა 4x1 უჯრაზე უნდა დადოს n * m ბრილიანტი. 
 * 
 * 
 * ჩათვალეთ, რომ კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.
 */
public class Ex9 extends SuperKarel {

	@Override
	public void run() {
		move(); // 1x1 -> 2x1
		doMultiplication();
	}

	/*-
	 * n - number of beepers on 2x1
	 * m - number of beepers on 3x1
	 * 
	 * put m beepers on 4x1 cell n times. result: 4x1 will have n*m beepers
	 * 
	 * for tracking the number of n, we pick beeper on 2x1 cell after each iteration,
	 * after x1 reaches 0 beepers we are done iterating.
	 * 
	 * Start state:
	 * 		Position: 2x1, Direction: →
	 * End state:
	 * 		Position: 2x1, Direction: → 
	 */
	private void doMultiplication() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // 2x1 -> 3x1
			doAddition();
			moveBeepersBack();
			turnAround(); // ←
			move(); // 3x1 -> 2x1
			turnAround(); // →
		}
	}

	/*-
	 * Karel is located at 3x1 cell. 
	 * Robot picks all of the beepers one by one and puts them on 4x1 an 5x1 cells
	 * 
	 * Start state:
	 * 		Position: 3x1, Direction: →
	 * End state:
	 * 		Position: 3x1, Direction: →
	 */
	private void doAddition() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // 3x1 -> 4x1
			putBeeper();
			move(); // 4x1 -> 5x1
			putBeeper();

			turnAround(); // ←
			move(); // 5x1 -> 4x1
			move(); // 4x1 -> 3x1
			turnAround(); // →
		}
	}

	/*-
	 * Karel is located at 3x1 cell.
	 * Robot picks beepers all beepers from the 5x1 cell and put them back at the 3x1 cell
	 * 
	 * Start state:
	 * 		Position: 3x1, Direction: →
	 * End state:
	 * 		Position: 3x1, Direction: → 
	 */
	private void moveBeepersBack() {
		move(); // 3x1 -> 4x1
		move(); // 4x1 -> 5x1
		while (beepersPresent()) {
			pickBeeper();
			turnAround(); // ←
			move(); // 5x1 -> 4x1
			move(); // 4x1 -> 3x1
			putBeeper(); // →

			turnAround();
			move(); // 3x1 -> 4x1
			move(); // 4x1 -> 5x1
		}

		turnAround(); // ←
		move(); // 5x1 -> 4x1
		move(); // 4x1 -> 3x1
		turnAround(); // →
	}
}
