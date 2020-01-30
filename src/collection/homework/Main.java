package collection.homework;

import collection.homework.service.StudentService;

public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        studentService.createArrayList();
        studentService.createLinkedList();
        studentService.createDynamicArray();
        studentService.createDoublyLinkedList();
    }
}
