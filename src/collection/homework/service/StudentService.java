package collection.homework.service;

import collection.homework.comparator.AgeComparator;
import collection.homework.comparator.FirstNameComparator;
import collection.homework.model.Student;
import collection.homework.list.DoublyLinkedList;
import collection.homework.list.DynamicArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class StudentService {
    final Student aegon = new Student("Aegon", "Targaryen", 30);
    final Student robb = new Student("Robb", "Stark", 31);
    final Student tyrion = new Student("Tyrion", "Lannister", 39);
    final Student jeor = new Student("Jeor", "Mormont", 58);
    final Student tormund = new Student("Tormund", "Giantsbane", 49);
    ArrayList<Student> arrayListOfStudents = new ArrayList<>();

    public void createArrayList() {
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
    }

    public void printingArrayList(ArrayList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void createLinkedList() {
        LinkedList<Student> studentsLinkedList = new LinkedList<>(arrayListOfStudents);
        Collections.sort(studentsLinkedList);
        System.out.println("\nSorted by last name (in ascending order): ");
        printingLinkedList(studentsLinkedList);
    }

    private static void printingLinkedList(LinkedList<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void createDynamicArray() {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.add(tyrion);
        dynamicArray.add(aegon);
        dynamicArray.add(jeor);
        dynamicArray.add(robb);
        System.out.println("\nPrinting dynamic array.");
        dynamicArray.printDynamicArray(dynamicArray);
    }

    public void createDoublyLinkedList() {
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
}
