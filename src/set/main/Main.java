package set.main;

import set.helper.TreeHelper;
import set.model.Student;

public class Main {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        treeHelper.createCoffeeSet();
        treeHelper.createStudentsSet();
        treeHelper.createGlassesSet();

        treeHelper.getTreeOfStudents().printInOrder(treeHelper.getTreeOfStudents().getRoot());
        System.out.println(treeHelper.getTreeOfStudents().size());
    }

}
