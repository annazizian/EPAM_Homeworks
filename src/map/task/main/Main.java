package map.task.main;

import map.task.model.Faculty;
import map.task.model.Student;
import map.task.nitialization.StudentCreator;
import map.task.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        StudentCreator studentCreator = new StudentCreator();

        //print the number of students who have the same full name
        ArrayList<Student> studentArrayList = StudentService.createStudentsArrayList();
        HashMap<Student, Integer> studentsArrayList = StudentCreator.getStudentsCountWithSameName(studentArrayList);
        studentCreator.printHashMap(studentsArrayList);

        System.out.println("\nThe number of students studying in the same faculty");
        Map<Faculty, Integer> facultyHashMap = StudentCreator.hashMapOfFaculties(studentArrayList);
        studentCreator.printHashMap(facultyHashMap);
    }
}
