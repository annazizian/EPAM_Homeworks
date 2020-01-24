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

        Collections.sort(arrayListOfStudents, new FirstNameComparator());
        System.out.println("Sorted by first name (in ascending order): ");
        printingArrayList(arrayListOfStudents);

        Collections.sort(arrayListOfStudents, new AgeComparator());
        System.out.println("\nSorted by age (in descending order): ");
        printingArrayList(arrayListOfStudents);

        //Test for Task 2
        LinkedList<Student> studentsLinkedList = new LinkedList<>(arrayListOfStudents);
        Collections.sort(studentsLinkedList);
        System.out.println("\nSorted by last name (in ascending order): ");
        printingArrayList(studentsLinkedList);

        //Test for Task 3
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(tyrion);
        dynamicArray.add(aegon);
        dynamicArray.add(jeor);
        dynamicArray.add(robb);
        System.out.println("\nPrinting dynamic array.");
        printDynamicArray(dynamicArray);

        //Test for task 4
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.push(aegon);
        doublyLinkedList.push(robb);
        doublyLinkedList.push(tyrion);
        doublyLinkedList.push(jeor);

        System.out.println("\nDoubly Linked List.");
        doublyLinkedList.printList();

        doublyLinkedList.addLast(tormund);
        System.out.println("\nList after adding an element to the end.");
        doublyLinkedList.printList();
        doublyLinkedList.pop();
        System.out.println("\nList after removing an element from front.");
        doublyLinkedList.printList();
        doublyLinkedList.removeLast();
        System.out.println("\nList after removing last element.");
        doublyLinkedList.printList();
        System.out.println(doublyLinkedList.getSize());
    }

    //for task 1
    public void printingArrayList(ArrayList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //for task 2
    private static void printingArrayList(LinkedList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    //for task 3
    private static void printDynamicArray(DynamicArray students) {
        for (int i = 0; i < students.getSize(); i++) {
            System.out.println(students.get(i));
        }
    }
}
