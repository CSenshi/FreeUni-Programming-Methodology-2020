package exams.f2019_v1;

import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class F2019_V1_Ex04 extends ConsoleProgram {
	/*-
	 * friends - {
	 * 		"Ana" - [("Giorgi", 25), ("Nino", 23), ("Mariami", 18), ("Luka", 22)]
	 * 		"Giorgi" - [("Ana", 18), ("Nino", 23)]
	 * 		"Nino" - [("Ana", 18), ("Giorgi", 25), ("Mariami", 18)]
	 * 		"Mariami" - [("Ana", 18), ("Nino", 23)]
	 * 		"Luka" - [("Ana", 18)]
	 * 	}
	 */
	public void run() {
		// 1. Create empty friends map
		HashMap<String, ArrayList<Person>> friends = new HashMap<>();

		// 2. Initialize persons
		Person ana = new Person("Ana", 18);
		Person giorgi = new Person("Giorgi", 25);
		Person nino = new Person("Nino", 23);
		Person mariami = new Person("Mariami", 18);
		Person luka = new Person("Luka", 22);

		// 3. Create empty friends list for each person
		friends.put(ana.getName(), new ArrayList<>());
		friends.put(giorgi.getName(), new ArrayList<>());
		friends.put(nino.getName(), new ArrayList<>());
		friends.put(mariami.getName(), new ArrayList<>());
		friends.put(luka.getName(), new ArrayList<>());

		// 4. add friendships
		// Ana - Giorgi
		friends.get(ana.getName()).add(giorgi);
		friends.get(giorgi.getName()).add(ana);
		// Ana - Nino
		friends.get(ana.getName()).add(nino);
		friends.get(nino.getName()).add(ana);
		// Ana - Mariami
		friends.get(ana.getName()).add(mariami);
		friends.get(mariami.getName()).add(ana);
		// Ana - Luka
		friends.get(ana.getName()).add(luka);
		friends.get(luka.getName()).add(ana);

		// Giorgi - Nino
		friends.get(giorgi.getName()).add(nino);
		friends.get(nino.getName()).add(giorgi);

		// Nino - Mariami
		friends.get(nino.getName()).add(mariami);
		friends.get(mariami.getName()).add(nino);

		println(getPersons(friends));
	}

	private ArrayList<Person> getPersons(HashMap<String, ArrayList<Person>> friends) {
		ArrayList<Person> result = new ArrayList<>();

		// 1. Count total average
		double totalAverage = 0;
		for (String name : friends.keySet()) {
			ArrayList<Person> friendsList = friends.get(name);

			// find person object
			Person currPerson = findPerson(friendsList, name, friends);

			totalAverage += currPerson.getAge();
		}
		totalAverage /= friends.size();

		// 2. count friends average
		for (String name : friends.keySet()) {
			ArrayList<Person> friendsList = friends.get(name);
			double average = 0;
			// find person object
			Person currPerson = findPerson(friendsList, name, friends);

			for (Person p : friendsList) {
				average += p.getAge();
			}
			average /= friendsList.size();
			if (average < totalAverage) {
				result.add(currPerson);
			}
		}

		return result;
	}

	private Person findPerson(ArrayList<Person> friendsList, String name, HashMap<String, ArrayList<Person>> friends) {
		for (Person p : friendsList) {
			ArrayList<Person> persons = friends.get(p.getName());
			for (Person p2 : persons) {
				if (p2.getName().equals(name)) {
					return p2;
				}
			}
		}
		return null;
	}
}

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		name = newName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int newAge) {
		age = newAge;
	}

	@Override
	public String toString() {
		return "(" + name + ", " + age + ")";
	}
}
