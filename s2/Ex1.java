package s2;

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
