package map.task.model;

import java.util.Objects;

public class Student {
    private final String FIRST_NAME;
    private final String LAST_NAME;
    private int age;
    private String phoneNumber;
    private Faculty faculty;

    public Student(String first_name, String last_name, int age, String phoneNumber, Faculty faculty) {
        FIRST_NAME = first_name;
        LAST_NAME = last_name;
        setAge(age);
        setPhoneNumber(phoneNumber);
        this.faculty = faculty;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setAge(int age) {
        if (age >= 0 && age <= 80) {
            this.age = age;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.charAt(0) == '0' && phoneNumber.length() == 10) {
            this.phoneNumber = phoneNumber;
        }
    }

    public Faculty getFaculty() {
        return faculty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(FIRST_NAME, student.FIRST_NAME) &&
                Objects.equals(LAST_NAME, student.LAST_NAME);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FIRST_NAME, LAST_NAME);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + FIRST_NAME + '\'' +
                ", Surname='" + LAST_NAME + '\'' +
                '}';
    }
}
