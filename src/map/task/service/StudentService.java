package map.task.service;

import map.task.model.Faculty;
import map.task.model.Student;

import java.util.*;

public class StudentService {
    public static ArrayList<Student> createStudentsArrayList() {
        ArrayList<Student> studentsArrayList = new ArrayList<>();
        studentsArrayList.add(new Student("Anna", "Azizyan",
                20, "0912536987", Faculty.MATH));
        studentsArrayList.add(new Student("Anna", "Azizyan",
                16, "0916666987", Faculty.PHYSICS));
        studentsArrayList.add(new Student("Babken", "Barsamyan",
                19, "0986545122", Faculty.MATH));
        studentsArrayList.add(new Student("Jensen", "Sargssian",
                20, "0995388356", Faculty.PHILOSOPHY));
        studentsArrayList.add(new Student("Narek", "Khachikyan",
                16, "0996537845", Faculty.PHYSICS));
        studentsArrayList.add(new Student("Varazdat", "Kazryan",
                21, "0953697841", Faculty.ENGLISH));
        studentsArrayList.add(new Student("Mane", "Hambardzumyan",
                30, "0946547895", Faculty.ENGLISH));
        studentsArrayList.add(new Student("Andranik", "Petrossian",
                25, "0969845122", Faculty.PHILOSOPHY));
        return studentsArrayList;
    }

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
