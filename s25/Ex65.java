package s25;

import acm.program.ConsoleProgram;
import s24.Friends;

/*
 * 63-ე ამოცანის გაგრძელება:
 * 
 * დაბეჭდეთ ადამიანი რომელსაც ყველაზე მეტი ადამიანი ემეგობრება
 */
public class Ex65 extends ConsoleProgram {

	public void run() {
		// 1. Initialize Friends Class
		Friends friends = new Friends(this);

		// 2. Read Input
		friends.readFriendsList();

		// 3. Print List
		String friendsString = friends.findMostFriendedUser();
		println(friendsString);
	}

}
