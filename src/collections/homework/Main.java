package collections.homework;

import collections.homework.services.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.createArrayList();
        studentService.createLinkedList();
        studentService.createDynamicArray();
        studentService.createDoublyLinkedList();
    }
}
