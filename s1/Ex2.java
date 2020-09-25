package s1;
/*
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment 1.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

/*
 * კარელი დგას 1x1 უჯრაზე.
 * 5x1 უჯრაზე დევს 10 ცალი ბრილიანტი,
 * კარელმა ათივე ბრილიანტი უნდა გადაიტანოს 6x1 უჯრაზე
 */
public class Ex2 extends SuperKarel {

	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			move();
		}

		for (int i = 0; i < 10; i++) {
			pickBeeper();
		}

		move();

		for (int i = 0; i < 10; i++) {
			putBeeper();
		}
	}

}
