package s2;

import stanford.karel.*;

/*
 * კარელი დგას 1x1 უჯრაზე, გაიყვანეთ იგი პირველი ქუჩის ბოლომდე.
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
