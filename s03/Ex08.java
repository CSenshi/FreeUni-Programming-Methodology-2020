package s03;

import stanford.karel.*;

/*
 * კარელმა უნდა გამოაკლოს ორი რიცხვი,
 * 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m ცალი ბრილიანტი, 
 * კარელმა 4x1 უჯრაზე უნდა დადოს n-m ბრილიანტი. 
 * 
 * ჩათვალეთ, რომ კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს და ჩათვალეთ, რომ n>=m.
 */
public class Ex08 extends SuperKarel {

	@Override
	public void run() {
		move(); // 1x1 -> 2x1
		moveBeepersToDestination();
		move(); // 2x1 -> 3x1
		iterateOverBeepers();
	}

	/*-
	 * Karel moves beepers from 2x1 to 4x1
	 * 
	 * Start state:
	 * 		Position: 2x1, Direction: →
	 * End state:
	 * 		Position: 2x1, Direction: → 
	 */
	private void moveBeepersToDestination() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // 2x1 -> 3x1
			move(); // 3x1 -> 4x1
			putBeeper();

			turnAround(); // →
			move(); // 4x1 -> 3x1
			move(); // 3x1 -> 2x1
			turnAround(); // ←
		}
	}

	/*-
	 * Karel is located at 3x1, in each while iteration robot picks one beeper from 3x1 and second from 4x1.
	 * Robot will do this while beeeper is present on 3x1 cell.
	 * 
	 * This will result in picking beeper n times from 3x1 and 4x1 cells
	 * So, 3x1 will have (n-n) beepers left, and 4x1 will have (m-n) beepers left
	 * 
	 * Start state:
	 * 		Position: 3x1, Direction: →
	 * End state:
	 * 		Position: 3x1, Direction: → 
	 */
	private void iterateOverBeepers() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // 3x1 -> 4x1
			pickBeeper();

			turnAround(); // ←
			move(); // 4x1 -> 3x1
			turnAround(); // →
		}
	}

}
