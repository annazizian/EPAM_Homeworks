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
}
