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
 * ჩათვალეთ რომ საწყის სამყაროში ბრილიანტები არსად არ დევს.
 */
public class Ex4 extends SuperKarel {

	@Override
	public void run() {
		putBeeper();
		while (frontIsClear()) {
			move();
			putBeeper();
		}
	}

}
