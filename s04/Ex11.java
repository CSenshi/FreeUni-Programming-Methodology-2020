package s04;

import stanford.karel.*;

/*
 * მოცემული გაქვთ სამყარო შემთხვევითად განლაგებული კედლებით. კარელი დგას 1x1 უჯრაზე.
 * თქვენი მიზანია კარელი მიიყვანოთ სამყაროს მარჯვენა ზედა კუთხეში. 
 * 
 * ჩათვალეთ, რომ კედლები ისეა განლაგებული, რომ გზა არსებობს.
 * 
 * პ.ს. მარჯვენა ზედა კუთხეში დაგხვდებათ ბიპერი, ამით მიხვდებით მიხვედით თუ არა მარჯვენა ზედა კუთხეში.
 */
public class Ex11 extends SuperKarel {

	@Override
	public void run() {
		wallFollower();
	}

	/*-
	 * Solve maze by always following right wall.
	 *
	 * More Details:
	 * 		https://en.wikipedia.org/wiki/Maze_solving_algorithm#Wall_follower
	 */
	private void wallFollower() {
		while (noBeepersPresent()) {
			if (rightIsClear()) {
				turnRight();
			} else {
				while (frontIsBlocked()) {
					turnLeft();
				}
			}
			move();
		}
	}
}
