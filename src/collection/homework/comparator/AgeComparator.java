package collection.homework.comparator;

import collection.homework.model.Student;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return student2.getAge() - student1.getAge();
    }
}
