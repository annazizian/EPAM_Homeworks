package map.task.model;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;
    private Faculty faculty;

    public Student(String first_name, String last_name, int age, String phoneNumber, Faculty faculty) {
        firstName = first_name;
        lastName = last_name;
        setAge(age);
        setPhoneNumber(phoneNumber);
        this.faculty = faculty;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
        return Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + firstName + '\'' +
                ", Surname='" + lastName + '\'' +
                '}';
    }
}
