package s28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

public class OldSchool implements School {

	Map<String, Map<String, List<String>>> data;

	public OldSchool() {
		data = new HashMap<>();
	}

	public void addTeacher(String teacher) {
		// Add new teacher with no subjects
		data.put(teacher, new HashMap<>());
	}

	public void addSubject(String teacher, String subject) {
		// Check if teacher exists
		if (data.containsKey(teacher)) {
			// Get teacher's subjects
			Map<String, List<String>> subjects = data.get(teacher);

			// list to assign to teacher's subject in data
			// Initially it is empty
			List<String> students = new ArrayList<>();

			// Check if someone else has this course if so change students
			// Iterate over all teacher's subjects
			for (String teacher2 : data.keySet()) {
				Map<String, List<String>> subjects2 = data.get(teacher2);
				// Check if current teacher's subjects' list contains given subject
				if (subjects2.containsKey(subject)) {
					// If contains change students
					students = subjects2.get(subject);
				}
			}

			// Add new subject with students to current teacher
			subjects.put(subject, students);
		}
	}

	public void addPupil(String pupil, String subject) {
		// Iterate over all teachers
		for (String teacher : data.keySet()) {
			// Get current teacher's subejcts
			Map<String, List<String>> subjects = data.get(teacher);
			// Check if teacher's subjects contains given subject
			if (subjects.containsKey(subject)) {
				// If contains get current subject's pupils list
				List<String> pupils = subjects.get(subject);
				// Append new pupil to pupils list
				pupils.add(pupil);
			}
		}
	}

	public Iterator<String> getTeachers(String pupil) {
		// Prepare result list to return
		List<String> result = new ArrayList<>();

		// Iterate over all teachers
		for (String teacher : data.keySet()) {
			// For given teacher get iterator of it's pupils (using method defined below)
			Iterator<String> it = getPupils(teacher);

			// Iterate over teacher's pupils
			while (it.hasNext()) {
				String currentPupil = it.next();
				// Check if current pupil is same as passed pupil
				if (currentPupil.equals(pupil)) {
					// If so it means that we found pupil in the list of students of teacher
					// add student to result list
					result.add(teacher);
					break;
				}
			}
		}

		// return iterator of pre defined list
		return result.iterator();
	}

	public Iterator<String> getPupils(String teacher) {
		// Check if given teacher is in our list, if not return null
		if (!data.containsKey(teacher)) {
			return null;
		}

		// Prepare result list to return
		List<String> result = new ArrayList<String>();

		// Get current teacher's subjects
		Map<String, List<String>> subjects = data.get(teacher);
		// Iterate over subjects
		for (String subject : subjects.keySet()) {
			// Get current subject's pupils
			List<String> pupils = subjects.get(subject);
			// Iterate over pupils
			for (String pupil : pupils) {
				// Duplication check in result list
				if (!result.contains(pupil)) {
					// If doesn't contain add
					result.add(pupil);
				}
			}
		}

		// return iterator of pre defined list
		return result.iterator();
	}

	public void removeTeacher(String teacher) {
		// Remove teacher from data
		data.remove(teacher);
	}
}
