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
 * 3x1 უჯრაზე დევს ბრილიანტი,
 * კარელმა ბრილიანტი უნდა გადაიტანოს 4x1 უჯრაზე და დაამთავროს მუშაობა.
 */

public class Ex1 extends SuperKarel {

	@Override
	public void run() {
		move();
		move();
		pickBeeper();
		move();
		putBeeper();
	}

}
