package s25;

import acm.program.ConsoleProgram;
import s24.Friends;

/*
 * 63-ე ამოცანის გაგრძელება:
 * 
 * დაბეჭდეთ ორი ადამინი რომელთაც არ ჰყავთ საერთო მეგობრები
 */
public class Ex66 extends ConsoleProgram {

	public void run() {
		// 1. Initialize Friends Class
		Friends friends = new Friends(this);

		// 2. Read Input
		friends.readFriendsList();

		// 3. Print Friends
		friends.printFriendsWithNoMutuals();
	}

}
