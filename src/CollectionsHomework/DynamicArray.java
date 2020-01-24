package CollectionsHomework;

public class DynamicArray {
    private Student[] array;
    private int size;

    public DynamicArray() {
        array = new Student[1];
        size = 0;
    }

    private void resizeIfFull() {
        if (size < array.length) {
            return;
        }
        Student[] biggerArray = new Student[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            biggerArray[i] = array[i];
        }
        array = biggerArray;
    }

    boolean add(Student student) {
        resizeIfFull();
        array[size++] = student;
        return true;
    }

    public void removeAt(int index) {
        if (size > 0) {
            for (int i = index; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
        }
    }

    public boolean remove(Student student) {
        int found = this.indexOf(student);
        if (found < 0) {
            return false;
        }
        this.removeAt(found);
        return true;
    }

    public int indexOf(Student student) {
        if (student == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (student.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Student get(int index) {
        return array[index];
    }

    public int getSize() {
        return size;
    }
}

