package collection.homework.comparator;

import collection.homework.model.Student;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getFirstName().compareTo(student2.getFirstName());
    }
}
