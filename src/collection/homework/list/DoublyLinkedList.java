package collection.homework.list;

import collection.homework.model.Student;

public class DoublyLinkedList {

    private class StudentNode {
        private Student student;
        private StudentNode next;
        private StudentNode previous;

        public StudentNode(Student student) {
            this.student = student;
        }

        public StudentNode getNext() {
            return next;
        }

        public void setNext(StudentNode next) {
            this.next = next;
        }

        public StudentNode getPrevious() {
            return previous;
        }

        public void setPrevious(StudentNode previous) {
            this.previous = previous;
        }

        public String toString() {
            return student.toString();
        }
    }

    private StudentNode head;
    private StudentNode tail;
    private int size;

    public void push(Student student) {
        if (student != null) {
            StudentNode node = new StudentNode(student);
            node.setNext(head);

            if (head == null) {
                tail = node;
            } else {
                head.setPrevious(node);
            }

            head = node;
            size++;
        }
    }

    public void addLast(Student student) {
        if (student != null) {
            StudentNode node = new StudentNode(student);
            if (tail == null) {
                head = node;
            } else {
                tail.setNext(node);
                node.setPrevious(tail);
            }

            tail = node;
            size++;
        }
    }

    public StudentNode pop() {
        if (isEmpty()) {
            return null;
        }

        StudentNode removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public StudentNode removeLast() {
        if (isEmpty()) {
            return null;
        }
        StudentNode removedNode = tail;

        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printList() {
        StudentNode current = head;
        System.out.println("head -> ");
        while (current != null) {
            System.out.println(current + " <=> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
