package s1;

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
