package s2;

import stanford.karel.*;

/*
 * კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას მთელი სამყარო თითო ბრილიანტით. 
 * ანუ მთელ სამყაროში ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. 
 * 
 * ჩათვალეთ რომ საწყისი სამყარო ცარიელი არ არის და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი)
 * ბრილიანტი დევს. ამასთან გაითვალისწინეთ, რომ სამყაროს ზომები თქვენთვის უცნობია და 
 * თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის სამყაროსათვის.
 */
public class Ex7 extends SuperKarel {

	@Override
	public void run() {
		fillOneRow();
		goBack();
		while (leftIsClear()) {
			goUp();
			fillOneRow();
			goBack();
		}
	}

	/*-
	 * Fill n'th row with beepers (don't put if beeper is present)
	 * 
	 * Start state: 
	 * 		Position: nx1, Direction: →
	 * End state: 
	 * 		Position: nxm, Direction: →
	 */
	private void fillOneRow() {
		while (frontIsClear()) {
			if (!beepersPresent())
				putBeeper();
			move();
		}
		if (!beepersPresent())
			putBeeper();
	}

	/*-
	 * Go back to 1st column after filling rows (called after fillOneRow())
	 * 
	 * Start state:
	 * 		Position: nxm, Direction: →
	 * End state:
	 * 		Position: nx1, Direction: →
	 */
	private void goBack() {
		turnAround(); // ←
		while (frontIsClear()) {
			move();
		}
		turnAround(); // →
	}

	/*-
	 * Move up by 1 cell
	 *  
	 * Start state: 
	 * 		Position: 1xn, Direction: →
	 * End state: 
	 * 		Position: 1x(n+1), Direction: →
	 */
	private void goUp() {
		turnLeft(); // ↑
		move(); // 1xn -> 1x(n+1)
		turnRight(); // →
	}
}
