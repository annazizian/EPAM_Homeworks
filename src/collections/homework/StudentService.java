package collections.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class StudentService {
    public void testing() {
        //Test for Task 1
        Student aegon = new Student("Aegon", "Targaryen", 30);
        Student robb = new Student("Robb", "Stark", 31);
        Student tyrion = new Student("Tyrion", "Lannister", 39);
        Student jeor = new Student("Jeor", "Mormont", 58);
        Student tormund = new Student("Tormund", "Giantsbane", 49);

        ArrayList<Student> arrayListOfStudents = new ArrayList<>();
        arrayListOfStudents.add(aegon);
        arrayListOfStudents.add(robb);
        arrayListOfStudents.add(tyrion);
        arrayListOfStudents.add(jeor);

        Collections.sort(arrayListOfStudents, new SortingByFirstName());
        System.out.println("Sorted by first name (in ascending order): ");
        printingArrayList(arrayListOfStudents);

        Collections.sort(arrayListOfStudents, new SortingByAge());
        System.out.println();
        System.out.println("Sorted by age (in descending order): ");
        printingArrayList(arrayListOfStudents);

        //Test for Task 2
        LinkedList<Student> studentsLinkedList = new LinkedList<>(arrayListOfStudents);
        Collections.sort(studentsLinkedList);
        System.out.println();
        System.out.println("Sorted by last name (in ascending order): ");
        printingArrayList(studentsLinkedList);

        //Test for Task 3
        DynamicArray da = new DynamicArray();
        da.add(tyrion);
        da.add(aegon);
        da.add(jeor);
        da.add(robb);
        System.out.println();
        System.out.println("Printing dynamic array.");
        printDynamicArray(da);

        //Test for task 4
        DLL list = new DLL();
        list.push(aegon);
        list.push(robb);
        list.push(tyrion);
        list.push(jeor);

        System.out.println();
        System.out.println("Doubly Linked List.");
        list.printList();
        System.out.println();

        list.addLast(tormund);
        System.out.println("List after adding an element to the end.");
        list.printList();
        System.out.println();
        list.pop();
        System.out.println("List after removing an element from front.");
        list.printList();
        System.out.println();
        list.removeLast();
        System.out.println("List after removing last element.");
        list.printList();
        System.out.println(list.getSize());
    }

    //for task 1
    public void printingArrayList(ArrayList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            iterator.next().printStudent();
        }
    }

    //for task 2
    private static void printingArrayList(LinkedList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            iterator.next().printStudent();
        }
    }

    //for task 3
    private static void printDynamicArray(DynamicArray students) {
        for (int i = 0; i < students.getSize(); i++) {
            students.get(i).printStudent();
        }
    }
}
