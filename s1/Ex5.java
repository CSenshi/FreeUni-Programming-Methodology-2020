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
 * კარელი დგას 1x1 უჯრაზე, შეავსებინეთ მას პირველი ქუჩა ბრილიანტებით. 
 * ანუ პირველი ქუჩის ყველა უჯრაზე უნდა იდოს ზუსტად ერთი ბრილიანტი. 
 * 
 * ჩათვალეთ რომ საწყისი სამყარო ცარიელი არ არის 
 * და გარკვეულ(ჩვენთვის უცნობ) უჯრებში თითო(მხოლოდ ერთი) ბრილიანტი დევს.
 */
public class Ex5 extends SuperKarel {

	@Override
	public void run() {
		doAction();
		while (frontIsClear()) {
			move();
			doAction();
		}
	}

	private void doAction() {
		if (!beepersPresent()) {
			putBeeper();
		}
	}

}
