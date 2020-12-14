package s24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Friends {

	/* Instance Variables */
	private final String TERMINATOR = "";
	private ConsoleProgram program;
	private Map<String, List<String>> friendsList;

	/* Constructor */
	public Friends(ConsoleProgram program) {
		// ConsoleProgram is needed to read input and write output
		this.program = program;
		friendsList = new HashMap<>();
	}

	/*
	 * readFriendsList() - Read input from program and save friends list in the
	 * friendsList instance var
	 */
	public void readFriendsList() {
		while (true) {
			// 1. Input names and check if it's terminator input
			String input = readFriendsInput();
			if (input.equals(TERMINATOR)) {
				break;
			}

			// 2. Extract names from input
			StringTokenizer st = new StringTokenizer(input);
			String secondName = st.nextToken();
			String firstName = st.nextToken();

			// 3. Check if firstName is in the Map of friends
			if (!friendsList.containsKey(firstName)) {
				// 4. If not add with value of empty ArrayList
				friendsList.put(firstName, new ArrayList<String>());
			}

			// 5. Add secondName to firstName's list of friends
			List<String> friendsOfFirst = friendsList.get(firstName);
			friendsOfFirst.add(secondName);
		}
	}

	/*
	 * Read single line of two names - validate only when exactly 2 names are
	 * written or when string is TERMINATOR
	 */
	private String readFriendsInput() {
		String input = this.program.readLine("Input friends: ");
		while (true) {
			// Case 1: input is terminator string -> OK!
			if (input.equals(TERMINATOR)) {
				return input;
			}

			// Case 2: input exactly one space -> OK!
			// Tokenize and check for total tokens being 2
			StringTokenizer st = new StringTokenizer(input);
			if (st.countTokens() == 2) {
				return input;
			}

			// Case 3: Incorrect input -> Err!
			input = this.program.readLine("Please input exactly 2 friends name separated by space: ");
		}
	}

	/*
	 * Ex63 - return person with most friends
	 */
	public String findUserWithMostFriends() {
		String result = null;
		int maxCount = 0;
		for (String key : friendsList.keySet()) {
			List<String> currentFriendsList = friendsList.get(key);
			if (currentFriendsList.size() > maxCount) {
				result = key;
				maxCount = currentFriendsList.size();
			}
		}
		return result;
	}

	/*
	 * Ex64 - Print list name with their friends
	 */
	public String toString() {
		// Check if empty
		if (this.friendsList.size() == 0) {
			return "Empty Friends List!";
		}

		// Result String to return
		String result = "";

		// Iterate over (Key, Value) and append result string
		Iterator<String> it = this.friendsList.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next(); // Key
			List<String> friends = this.friendsList.get(key); // Value

			// Append to current name's string
			String keyValueString = key + " - " + friends;
			result += keyValueString + "\n";
		}

		// Remove last character '\n'
		result = result.substring(0, result.length() - 1);

		// Return Result
		return result;
	}

	/*
	 * Ex65 - return person who with friends to most users (revert oh Ex63)
	 */
	public String findMostFriendedUser() {
		// 1. Fill reverse map of friendsList
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String key : this.friendsList.keySet()) {
			List<String> currentFriends = this.friendsList.get(key);
			for (String friendName : currentFriends) {
				if (!counts.containsKey(friendName)) {
					counts.put(friendName, 0);
				}
				counts.put(friendName, counts.get(friendName) + 1);
			}
		}

		// 2. Iterate and find user
		int maxCount = 0;
		String user = null;
		for (String key : counts.keySet()) {
			int value = counts.get(key);
			if (value > maxCount) {
				maxCount = value;
				user = key;
			}
		}

		// 3. Return user
		return user;
	}

	/*
	 * Ex66 - print 2 persons without mutual friends
	 */
	public void printFriendsWithNoMutuals() {
		for (String user1 : this.friendsList.keySet()) {
			for (String user2 : this.friendsList.keySet()) {
				// If user1 == user2 we should not evaluate mutual friends because they are the
				// same user
				if (user1 == user2) {
					continue;
				}

				// Get both users' friends list
				List<String> friends1 = this.friendsList.get(user1);
				List<String> friends2 = this.friendsList.get(user2);

				// Iterate one friends list and check occurances in another list
				boolean haveMutualFriends = false;
				for (String friend : friends1) {
					if (friends2.contains(friend)) {
						haveMutualFriends = true;
						break;
					}
				}

				// If these users dont have friends in common print them and return
				if (!haveMutualFriends) {
					this.program.println(user1 + " - " + user2);
					return;
				}
			}
		}

		// At this point we didn't find such users so print out following message
		this.program.println("There are no 2 users with no mutual friends");
	}
}
