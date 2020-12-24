package s28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReworkedSchool implements School {

	Map<String, List<String>> teacherSubjects;
	Map<String, List<String>> subjectsStudents;

	public ReworkedSchool() {
		teacherSubjects = new HashMap<>();
		subjectsStudents = new HashMap<>();
	}

	@Override
	public void addTeacher(String teacher) {
		// Add new teacher with no subjects
		teacherSubjects.put(teacher, new ArrayList<>());
	}

	@Override
	public void addSubject(String teacher, String subject) {
		// Check if teacher exists
		if (teacherSubjects.containsKey(teacher)) {
			// Get lsit of teacher's subjects
			List<String> subjects = teacherSubjects.get(teacher);
			// Add new subject in the given list
			subjects.add(subject);

			// Check if this subject exists in second map
			if (!subjectsStudents.containsKey(subject)) {
				// If it doesn't exist (it means it's new subject) we should add it
				subjectsStudents.put(subject, new ArrayList<String>());
			}
		}
	}

	@Override
	public void addPupil(String pupil, String subject) {
		// Check if subjects map contains given subject
		if (subjectsStudents.containsKey(subject)) {
			// If contains get current subject's pupils list
			List<String> pupils = subjectsStudents.get(subject);

			// Append new pupil to pupils list
			pupils.add(pupil);
		}
	}

	@Override
	public Iterator<String> getTeachers(String pupil) {
		// Prepare result list to return
		List<String> result = new ArrayList<>();

		// Iterate over all teachers
		for (String teacher : teacherSubjects.keySet()) {
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

	@Override
	public Iterator<String> getPupils(String teacher) {
		// Check if given teacher is in our list, if not return null
		if (!teacherSubjects.containsKey(teacher)) {
			return null;
		}

		// Prepare result list to return
		List<String> result = new ArrayList<>();

		// Get current teacher's subjects
		List<String> subjects = teacherSubjects.get(teacher);

		// Iterate over subjects
		for (String subject : subjects) {
			// Get current subject's pupils
			List<String> pupils = subjectsStudents.get(subject);

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

	@Override
	public void removeTeacher(String teacher) {
		teacherSubjects.remove(teacher);
	}

}
