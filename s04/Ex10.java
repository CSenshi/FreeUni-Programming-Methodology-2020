package s04;

import stanford.karel.*;

/*
 * კარელმა უნდა გაყოს ორი რიცხვი, 
 * 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m ცალი ბრილიანტი, 
 * კარელმა 4x1 უჯრაზე უნდა დადოს n / m ბრილიანტი. 
 * 
 * ჩათვალეთ, რომ n ზუსტად იყოფა m-ზე და კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.
 */
public class Ex10 extends SuperKarel {

	@Override
	public void run() {
		move(); // 1x1 -> 2x1
		doDivision();
	}

	/*-
	 * n - number of beepers on 2x1
	 * m - number of beepers on 3x1
	 * 
	 * remove m beepers from 2x1 cell n/m times. result: 4x1 will have n/m beepers
	 * 
	 * Start state:
	 * 		Position: 2x1, Direction: →
	 * End state:
	 * 		Position: 2x1, Direction: → 
	 */
	private void doDivision() {
		while (beepersPresent()) {
			move(); // 2x1 -> 3x1
			doSubstitution();
			moveBeepersBack();
			saveResult();
		}
	}

	/*-
	 * Karel is located at 3x1 cell. 
	 * Robot picks all of the beepers one by one from 3x1 (total of m)
	 * also pick m beepers from 2x1 and puts them on 1x1 cells
	 * 
	 * Start state:
	 * 		Position: 3x1, Direction: →
	 * End state:
	 * 		Position: 3x1, Direction: →
	 */
	private void doSubstitution() {
		while (beepersPresent()) {
			pickBeeper();
			turnAround(); // ←
			move(); // 3x1 -> 2x1
			pickBeeper();
			move(); // 2x1 -> 1x1
			putBeeper();

			turnAround(); // →
			move(); // 1x1 -> 2x1
			move(); // 2x1 -> 3x1
		}
	}

	/*-
	 * Karel is located at 3x1 cell.
	 * Robot picks all beepers from the 1x1 cell and put them back at the 3x1 cell
	 * 
	 * Start state:
	 * 		Position: 3x1, Direction: →
	 * End state:
	 * 		Position: 3x1, Direction: → 
	 */
	private void moveBeepersBack() {
		turnAround(); // ←
		move(); // 3x1 -> 2x1
		move(); // 2x1 -> 1x1
		turnAround(); // →
		while (beepersPresent()) {
			pickBeeper();
			move(); // 1x1 -> 2x1
			move(); // 2x1 -> 3x1
			putBeeper();

			turnAround(); // ←
			move(); // 3x1 -> 2x1
			move(); // 2x1 -> 1x1
			turnAround(); // →
		}

		move(); // 1x1 -> 2x1
		move(); // 2x1 -> 3x1
	}

	/*-
	 * Increment beepers by 1 on 4x1 cell (4x1 is final result cell)
	 * 
	 * Start state:
	 * 		Position: 3x1, Direction: →
	 * End state:
	 * 		Position: 3x1, Direction: → 
	 */
	private void saveResult() {
		move(); // 3x1 -> 4x1
		putBeeper(); 
		turnAround(); // ←
		move(); // 4x1 -> 3x1
		move(); // 3x1 -> 2x1
		turnAround(); // →
	}
}
