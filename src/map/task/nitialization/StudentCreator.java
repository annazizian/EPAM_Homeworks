package map.task.nitialization;

import map.task.model.Faculty;
import map.task.model.Student;

import java.util.*;

public class StudentCreator {

    //getting number of students with same name and surname and return the map
    public static HashMap<Student, Integer> getStudentsCountWithSameName(ArrayList<Student> studentArrayList) {
        HashMap<Student, Integer> studentsHashMap = new HashMap<>();
        if (studentArrayList != null) {
            for (Student student : studentArrayList) {
                if (studentsHashMap.containsKey(student)) {
                    studentsHashMap.replace(student, studentsHashMap.get(student) + 1);
                } else {
                    studentsHashMap.put(student, 1);
                }
            }
        }
        return studentsHashMap;
    }

    //getting the number of students in each faculty
    public static Map<Faculty, Integer> hashMapOfFaculties(ArrayList<Student> studentArrayList) {
        Map<Faculty, Integer> facultiesHashMap = new EnumMap<>(Faculty.class);
        if (studentArrayList != null) {
            for (Student student : studentArrayList) {
                Faculty faculty = student.getFaculty();
                if (facultiesHashMap.containsKey(faculty)) {
                    facultiesHashMap.replace(faculty, facultiesHashMap.get(faculty) + 1);
                } else {
                    facultiesHashMap.put(faculty, 1);
                }
            }
        }
        return facultiesHashMap;
    }

    public void printHashMap(Map hashMap) {
        if (!hashMap.isEmpty()) {
            Iterator iterator = hashMap.keySet().iterator();
            while (iterator.hasNext()) {
                Object current = iterator.next();
                System.out.println(current + " : " + hashMap.get(current));
            }
        }
    }
}
