package s28;

import java.util.Iterator;

import acm.program.ConsoleProgram;

public class Ex71 extends ConsoleProgram {

	/*-
	 * School:
	 * -	Shota: 
	 *			"Programming Methodology" - ["Luka", "Eka"],
	 *			"Open Source System" - [],
	 *			"OOP" - ["Saba", "Ketevani"],
	 *			"Programming Paradigms" - ["Saba", "Ketevani"],
	 * 			
	 * -	Nika: 
	 *			"Discrete Math" - ["Mariami"]
	 *			"Theory of Computation" - ["Mariami"]
	 *			"Information Theory" - ["Mariami"]
	 *		
	 * -	Giorgi: 
	 *		 	"OOP" - ["Saba", "Ketevani"],
	 *			"Programming Paradigms" - ["Saba", "Ketevani"],
	 *			"Distributed Systems" - ["Saba", "Ketevani"]
	 * 
	 */
	 
	@Override
	public void run() {
		School school = new School();

		// 1. Add Teachers
		addTeachers(school);

		// 2. Add Subjects
		addSubjects(school);

		// 3. Add Pupils
		addPupils(school);

		// 4 Get pupils iterator
		println("######### Get Pupils #########");
		testGetPupils(school);

		// 5. Get teachers iterator
		println("######### Get Teachers #########");
		testGetTeachers(school);

		// 6. Get teachers after removing Shota
		println("######### Get Teachers After Removing Teacher #########");
		testRemoveTeacher(school);
	}

	private void addTeachers(School school) {
		school.addTeacher("Shota");
		school.addTeacher("Nika");
		school.addTeacher("Giorgi");
	}

	private void addSubjects(School school) {
		// Shota
		school.addSubject("Shota", "Programming Methodology");
		school.addSubject("Shota", "Open Source System");
		school.addSubject("Shota", "OOP");
		school.addSubject("Shota", "Programming Paradigms");
		// Nika
		school.addSubject("Nika", "Discrete Math");
		school.addSubject("Nika", "Theory of Computation");
		school.addSubject("Nika", "Information Theory");
		// Giorgi
		school.addSubject("Giorgi", "OOP");
		school.addSubject("Giorgi", "Programming Paradigms");
		school.addSubject("Giorgi", "Distributed Systems");
		// 2.4 Sandro (Unknown);
		school.addSubject("Sandro", "Super Course");
	}

	private void addPupils(School school) {
		// Saba
		school.addPupil("Saba", "OOP");
		school.addPupil("Saba", "Programming Paradigms");
		school.addPupil("Saba", "Distributed Systems");
		// Ketevani
		school.addPupil("Ketevani", "OOP");
		school.addPupil("Ketevani", "Programming Paradigms");
		school.addPupil("Ketevani", "Distributed Systems");
		// Luka
		school.addPupil("Luka", "Programming Methodology");
		// Eka
		school.addPupil("Eka", "Programming Methodology");
		// Mariami
		school.addPupil("Mariami", "Discrete Math");
		school.addPupil("Mariami", "Theory of Computation");
		school.addPupil("Mariami", "Information Theory");
	}

	private void testGetPupils(School school) {
		println("1. Shota's Pupils:");
		Iterator<String> it1 = school.getPupils("Shota");
		while (it1.hasNext()) {
			print(it1.next() + ", ");
		}
		println();

		println("\n2. Nika's Pupils:");
		Iterator<String> it2 = school.getPupils("Nika");
		while (it2.hasNext()) {
			print(it2.next() + ", ");
		}
		println();

		println("\n3. Giorgi's Pupils:");
		Iterator<String> it3 = school.getPupils("Giorgi");
		while (it3.hasNext()) {
			print(it3.next() + ", ");
		}
		println();
		println();
	}

	private void testGetTeachers(School school) {
		// 1. Saba
		println("1. Saba's Teachers:");
		Iterator<String> it1 = school.getTeachers("Saba");
		while (it1.hasNext()) {
			print(it1.next() + ", ");
		}
		println();

		// 2. Ketevani
		println("\n2. Ketevani's Teachers:");
		Iterator<String> it2 = school.getTeachers("Ketevani");
		while (it2.hasNext()) {
			print(it2.next() + ", ");
		}
		println();

		// 3. Luka
		println("\n3. Luka's Teachers:");
		Iterator<String> it3 = school.getTeachers("Luka");
		while (it3.hasNext()) {
			print(it3.next() + ", ");
		}
		println();

		// 4. Eka
		println("\n4. Luka's Teachers:");
		Iterator<String> it4 = school.getTeachers("Eka");
		while (it4.hasNext()) {
			print(it4.next() + ", ");
		}
		println();

		// 5. Eka
		println("\n5. Luka's Teachers:");
		Iterator<String> it5 = school.getTeachers("Mariami");
		while (it5.hasNext()) {
			print(it5.next() + ", ");
		}
		println();
		println();
	}

	private void testRemoveTeacher(School school) {
		school.removeTeacher("Shota");
		testGetTeachers(school);
	}

}
