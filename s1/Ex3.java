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
 * კარელი დგას 1x1 უჯრაზე,გაიყვანეთ იგი პირველი ქუჩის ბოლომდე.
 *  
 * გაითვალისწინეთ, რომ სამყაროს ზომა არ იცით. 
 * თქვენი პროგრამა უნდა მუშაობდეს ნებისმიერი ზომის სამყაროსათვის.
 */
public class Ex3 extends SuperKarel {

	@Override
	public void run() {
		while (frontIsClear()) {
			move();
		}
	}

}
