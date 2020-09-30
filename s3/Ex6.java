package s3;

import stanford.karel.*;

/*
 * კარელმა უნდა შეკრიბოს ორი რიცხვი, 
 * 2x1 უჯრაზე დევს n ცალი ბრილიანტი, 3x1 უჯრაზე m ცალი ბრილიანტი, 
 * კარელმა 4x1 უჯრაზე უნდა დადოს n+m ბრილიანტი. 
 * 
 * ჩათვალეთ, რომ კარელს ჩანთაში უსასრულო რაოდენობის ბრილიანტი აქვს.
 */
public class Ex6 extends SuperKarel {

	@Override
	public void run() {
		move(); // 1x1 -> 2x1
		addFirstSum();
		move(); // 2x1 -> 3x1
		addSecondSum();
	}

	/*-
	 * Move Beepers from 2x1 to 4x1 one by one
	 * 
	 * Start state: 
	 * 		Position: 2x1, Direction: →
	 * End state: 
	 * 		Position: 2x1, Direction: →
	 */
	private void addFirstSum() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // 2x1 -> 3x1
			move(); // 3x1 -> 4x1
			putBeeper();

			turnAround(); // ←
			move(); // 4x1 -> 3x1
			move(); // 3x1 -> 2x1
			turnAround(); // →
		}
	}

	/*-
	 * Move Beepers from 2x1 to 4x1 one by one
	 * 
	 * Start state: 
	 * 		Position: 3x1, Direction: →
	 * End state: 
	 * 		Position: 3x1, Direction: →
	 */
	private void addSecondSum() {
		while (beepersPresent()) {
			pickBeeper();
			move(); // 3x1 -> 4x1
			putBeeper();

			turnAround(); // ←
			move(); // 4x1 -> 3x1
			turnAround(); // →
		}
	}
}
