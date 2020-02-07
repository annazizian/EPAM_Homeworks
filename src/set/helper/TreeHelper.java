package set.helper;

import set.binarytree.BinarySearchTree;
import set.model.Coffee;
import set.model.Glasses;
import set.model.Student;

public class TreeHelper {

    public static class StudentCreation {
        public Student student1 = new Student("Anna", "Azizyan", 20);
        public Student student2 = new Student("Vazgen", "Abrahamyan", 26);
        public Student student3 = new Student("Tsaghik", "Khachatryan", 19);
        public Student student4 = new Student("Karine", "Gevorgyan", 18);
        public Student student5 = new Student("Vahe", "Antonyan", 21);
        public Student student6 = new Student("Ani", "Mazmanyan", 19);
        public Student student7 = new Student("Ani", "Mazmanyan", 19);
    }

    BinarySearchTree<Student> treeOfStudents = new BinarySearchTree<>();
    public StudentCreation studentCreation = new StudentCreation();

    public void createStudentsSet() {
        treeOfStudents.add(studentCreation.student1);
        treeOfStudents.add(studentCreation.student2);
        treeOfStudents.add(studentCreation.student3);
        treeOfStudents.add(studentCreation.student4);
        treeOfStudents.add(studentCreation.student5);
        treeOfStudents.add(studentCreation.student6);
        treeOfStudents.add(studentCreation.student7);
    }

    public BinarySearchTree<Student> getTreeOfStudents() {
        return treeOfStudents;
    }

    public static class GlassesCreation {
        Glasses glasses1 = new Glasses("Ray-Ban", false, 150);
        Glasses glasses2 = new Glasses("Versace", false, 228);
        Glasses glasses3 = new Glasses("Michael Kors", false, 80);
        Glasses glasses4 = new Glasses("Gucci", true, 135);
        Glasses glasses5 = new Glasses("Gucci", true, 131);
        Glasses glasses6 = new Glasses("Ray-Ban", false, 155);
    }

    BinarySearchTree<Glasses> treeOfGlasses = new BinarySearchTree<>();
    GlassesCreation glassesCreation = new GlassesCreation();

    public void createGlassesSet() {
        treeOfGlasses.add(glassesCreation.glasses1);
        treeOfGlasses.add(glassesCreation.glasses2);
        treeOfGlasses.add(glassesCreation.glasses3);
        treeOfGlasses.add(glassesCreation.glasses4);
        treeOfGlasses.add(glassesCreation.glasses5);
        treeOfGlasses.add(glassesCreation.glasses6);
    }

    public BinarySearchTree<Glasses> getTreeOfGlasses() {
        return treeOfGlasses;
    }

    public static class CoffeeCreation {
        public Coffee coffee1 = new Coffee("Americano", 61, 20, false,
                true, false, false);
        public Coffee coffee2 = new Coffee("Latte", 30, 0, true,
                false, false, false);
        Coffee coffee3 = new Coffee("Cappuccino", 45, 0, true,
                true, false, false);
        Coffee coffee4 = new Coffee("Irish Coffee", 40, 20, false,
                false, true, false);
        Coffee coffee5 = new Coffee("Affogato", 20, 10, false,
                false, false, true);
    }

    CoffeeCreation coffeeCreation = new CoffeeCreation();
    public BinarySearchTree<Coffee> treeOfCoffees = new BinarySearchTree<>();

    public void createCoffeeSet() {
        treeOfCoffees.add(coffeeCreation.coffee1);
        treeOfCoffees.add(coffeeCreation.coffee2);
        treeOfCoffees.add(coffeeCreation.coffee3);
        treeOfCoffees.add(coffeeCreation.coffee4);
        treeOfCoffees.add(coffeeCreation.coffee5);
    }

    public BinarySearchTree<Coffee> getTreeOfCoffees() {
        return treeOfCoffees;
    }

    public void print(BinarySearchTree tree) {
        tree.toString();
    }
}
