package set.helper;

import set.binarytree.AVLTree;
import set.model.Coffee;
import set.model.Glasses;
import set.model.Student;

public class TreeHelper {

    public class StudentCreation {
        Student student1 = new Student("Anna", "Azizyan", 20);
        Student student2 = new Student("Vazgen", "Abrahamyan", 26);
        Student student3 = new Student("Tsaghik", "Khachatryan", 19);
        Student student4 = new Student("Karine", "Gevorgyan", 18);
        Student student5 = new Student("Vahe", "Antonyan", 21);
        Student student6 = new Student("Ani", "Mazmanyan", 19);
    }

    public AVLTree<Student> createStudentsSet() {
        AVLTree<Student> tree = new AVLTree<Student>();
        StudentCreation studentCreation = new StudentCreation();
        tree.insert(new AVLTree.Node(studentCreation.student1));
        tree.insert(new AVLTree.Node(studentCreation.student2));
        tree.insert(new AVLTree.Node(studentCreation.student3));
        tree.insert(new AVLTree.Node(studentCreation.student4));
        tree.insert(new AVLTree.Node(studentCreation.student5));
        tree.insert(new AVLTree.Node(studentCreation.student6));
        return tree;
    }

    public class GlassesCreation {
        Glasses glasses1 = new Glasses("Ray-Ban", false, 150);
        Glasses glasses2 = new Glasses("Versace", false, 228);
        Glasses glasses3 = new Glasses("Michael Kors", false, 80);
        Glasses glasses4 = new Glasses("Gucci", true, 135);
        Glasses glasses5 = new Glasses("Gucci", true, 131);
        Glasses glasses6 = new Glasses("Ray-Ban", false, 155);
    }

    public AVLTree<Glasses> createGlassesSet() {
        AVLTree<Glasses> tree = new AVLTree<>();
        GlassesCreation glassesCreation = new GlassesCreation();
        tree.insert(new AVLTree.Node(glassesCreation.glasses1));
        tree.insert(new AVLTree.Node(glassesCreation.glasses2));
        tree.insert(new AVLTree.Node(glassesCreation.glasses3));
        tree.insert(new AVLTree.Node(glassesCreation.glasses4));
        tree.insert(new AVLTree.Node(glassesCreation.glasses5));
        tree.insert(new AVLTree.Node(glassesCreation.glasses6));
        return tree;
    }

    public class CoffeeCreation {
        Coffee coffee1 = new Coffee("Americano", 30, 20, false,
                true, false, false);
        Coffee coffee2 = new Coffee("Latte", 30, 0, true,
                false, false, false);
        Coffee coffee3 = new Coffee("Cappuccino", 40, 0, true,
                true, false, false);
        Coffee coffee4 = new Coffee("Irish Coffee", 40, 20, false,
                false, true, false);
        Coffee coffee5 = new Coffee("Affogato", 20, 10, false,
                false, false, true);
    }

    public AVLTree<Coffee> createCoffesSet() {
        AVLTree<Coffee> tree = new AVLTree<>();
        CoffeeCreation coffeeCreation = new CoffeeCreation();
        tree.insert(new AVLTree.Node(coffeeCreation.coffee1));
        tree.insert(new AVLTree.Node(coffeeCreation.coffee2));
        tree.insert(new AVLTree.Node(coffeeCreation.coffee3));
        tree.insert(new AVLTree.Node(coffeeCreation.coffee4));
        tree.insert(new AVLTree.Node(coffeeCreation.coffee5));
        return tree;
    }

    public void printSet(AVLTree tree) {
        for (Object object : tree) {
            System.out.println(object + "\n");
        }
    }
}
