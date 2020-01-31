package map.task.main;

import map.task.model.Faculty;
import map.task.model.Student;
import map.task.service.StudentService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

        //print the number of students who have the same full name
        ArrayList<Student> studentArrayList = StudentService.createStudentsArrayList();
        HashMap<Student, Integer> studentsArrayList = StudentService.getStudentsCountWithSameName(studentArrayList);
        studentService.printHashMap(studentsArrayList);

        System.out.println("\nThe number of students studying in the same faculty");
        Map<Faculty, Integer> facultyHashMap = StudentService.hashMapOfFaculties(studentArrayList);
        studentService.printHashMap(facultyHashMap);
    }
}
