package s28;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import acm.program.ConsoleProgram;

public class Ex71 extends ConsoleProgram {

	/*-
	 * School:
	 * -	Shota: 
	 *			"Programming Methodology" - ["Luka", "Eka"]
	 *			"Open Source System" - []
	 *			"OOP" - ["Saba", "Ketevani"],
	 *			"Programming Paradigms" - ["Saba", "Ketevani"]
	 * 			
	 * -	Nika: 
	 *			"Discrete Math" - ["Mariami"]
	 *			"Theory of Computation" - ["Mariami"]
	 *			"Information Theory" - ["Mariami"]
	 *		
	 * -	Giorgi: 
	 *		 	"OOP" - ["Saba", "Ketevani"],
	 *			"Programming Paradigms" - ["Saba", "Ketevani"]
	 *			"Distributed Systems" - ["Saba", "Ketevani"]
	 *
	 *-		Irakli:
	 *			"Programming Methodology" - ["Luka", "Eka"]
	 *			"Discrete Math" - ["Mariami"]
	 */

	@Override
	public void run() {
		School school = new OldSchool();
//		School school = new ReworkedSchool();

		// 1. Add Teachers
		addTeachers(school);

		// 2. Add Subjects
		addSubjects(school);

		// 3. Add Pupils
		addPupils(school);

		// 4. Add More Teachers
		addMoreTeachersAndSubjects(school);

		// 5 Get pupils iterator
		println("######### Get Pupils #########");
		testGetPupils(school);

		// 6. Get teachers iterator
		println("######### Get Teachers #########");
		testGetTeachers(school);

		// 7. Get teachers after removing Shota
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
		// Sandro (Unknown);
		school.addSubject("Sandro", "Super Course");
	}

	private void addPupils(School school) {
		// Saba
		school.addPupil("Saba", "OOP");
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

	private void addMoreTeachersAndSubjects(School school) {
		school.addTeacher("Irakli");
		school.addSubject("Irakli", "Programming Methodology");
		school.addSubject("Irakli", "Discrete Math");
	}

	private void testGetPupils(School school) {
		println("1. Shota's Pupils:");
		Iterator<String> it1 = school.getPupils("Shota");
		printIterator(it1);

		println("\n2. Nika's Pupils:");
		Iterator<String> it2 = school.getPupils("Nika");
		printIterator(it2);

		println("\n3. Giorgi's Pupils:");
		Iterator<String> it3 = school.getPupils("Giorgi");
		printIterator(it3);

		println("\n4. Irakli's Pupils:");
		Iterator<String> it4 = school.getPupils("Irakli");
		printIterator(it4);

		println();
	}

	private void testGetTeachers(School school) {
		// 1. Saba
		println("1. Saba's Teachers:");
		Iterator<String> it1 = school.getTeachers("Saba");
		printIterator(it1);

		// 2. Ketevani
		println("\n2. Ketevani's Teachers:");
		Iterator<String> it2 = school.getTeachers("Ketevani");
		printIterator(it2);

		// 3. Luka
		println("\n3. Luka's Teachers:");
		Iterator<String> it3 = school.getTeachers("Luka");
		printIterator(it3);

		// 4. Eka
		println("\n4. Eka's Teachers:");
		Iterator<String> it4 = school.getTeachers("Eka");
		printIterator(it4);

		// 5. Eka
		println("\n5. Mariami's Teachers:");
		Iterator<String> it5 = school.getTeachers("Mariami");
		printIterator(it5);

		println();
	}

	private void testRemoveTeacher(School school) {
		school.removeTeacher("Shota");
		testGetTeachers(school);
	}

	private void printIterator(Iterator<String> it) {
		List<String> list = new ArrayList<String>();
		while (it.hasNext()) {
			list.add(it.next());
		}
		println(list);
	}
}
