package exams.f2019;

import java.util.ArrayList;
import java.util.HashMap;

import acm.program.ConsoleProgram;

public class F2019Ex04 extends ConsoleProgram {

	/*-
	 * friends - {
	 * 		"Ana" - ["Giorgi", "Nino", "Mariami", "Luka"]
	 * 		"Giorgi" - ["Ana", "Nino"]
	 * 		"Nino" - ["Ana", "Giorgi", "Mariami"]
	 * 		"Mariami" - ["Ana", "Nino"]
	 * 		"Luka" - ["Ana"]
	 * 	}
	 */
	public void run() {
		// 1. Create empty friends map
		HashMap<String, ArrayList<Person>> friends = new HashMap<>();

		// 2. Initialize persons
		Person ana = new Person("Ana", 20);
		Person giorgi = new Person("Giorgi", 20);
		Person nino = new Person("Nino", 20);
		Person mariami = new Person("Mariami", 20);
		Person luka = new Person("Luka", 20);

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

		println(friends);
	}

	private ArrayList<Person> getPersons(HashMap<String, ArrayList<Person>> friends) {
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
}