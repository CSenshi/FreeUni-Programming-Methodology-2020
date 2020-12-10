package s24;

import acm.program.ConsoleProgram;

/*
 * 63-ე ამოცანის გაგრძელება:
 * 
 * დაბეჭდეთ თითოეული შეყვანილი სახელი და მის გასწვრივ მძიმით გამოყოფილი მეგობრების სია. 
 */
public class Ex64 extends ConsoleProgram {

	public void run() {
		// 1. Initialize Friends Class
		Friends friends = new Friends(this);

		// 2. Read Input
		friends.readFriendsList();

		// 3. Print List
		String friendsString = friends.toString();
		println(friendsString);
	}

}
