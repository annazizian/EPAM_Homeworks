package collections.homework;

public class StudentNode {
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
