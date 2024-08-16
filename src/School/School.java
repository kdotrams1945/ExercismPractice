package School;
import java.util.*;
public class School {
        private Map<Integer, List<String>> roster;

        public School() {
            roster = new HashMap<>();
        }

        public boolean add(String student, int grade) {
            if (!roster.containsKey(grade)) {
                roster.put(grade, new ArrayList<>());
            }

            List<String> studentsInGrade = roster.get(grade);
            if (studentsInGrade.contains(student)) {
                return false; // Already added
            }

            for (List<String> students : roster.values()) {
                if (students.contains(student)) {
                    return false; // Already added to another grade
                }
            }

            studentsInGrade.add(student);
            Collections.sort(studentsInGrade); // Sort alphabetically
            return true;
        }

        public List<String> roster() {
            List<String> allStudents = new ArrayList<>();
            List<Integer> sortedGrades = new ArrayList<>(roster.keySet());
            Collections.sort(sortedGrades);

            for (int grade : sortedGrades) {
                allStudents.addAll(roster.get(grade));
            }

            return allStudents;
        }

        public List<String> grade(int grade) {
            List<String> studentsInGrade = roster.getOrDefault(grade, new ArrayList<>());
            Collections.sort(studentsInGrade); // Sort alphabetically
            return studentsInGrade;
        }

}
