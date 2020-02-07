package set.main;

import set.helper.TreeHelper;
import set.model.Student;

public class Main {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        treeHelper.createCoffeeSet();
        treeHelper.createStudentsSet();
        treeHelper.createGlassesSet();

        treeHelper.getTreeOfStudents().inOrder();
        System.out.println(treeHelper.getTreeOfStudents().size());
        treeHelper.getTreeOfStudents().remove(treeHelper.studentCreation.student1);
        treeHelper.getTreeOfStudents().inOrder();
        System.out.println(treeHelper.getTreeOfStudents().size());

        System.out.println("------------------------------");

        treeHelper.getTreeOfCoffees().inOrder();
        System.out.println(treeHelper.getTreeOfCoffees().size());

        System.out.println("------------------------------");

        treeHelper.getTreeOfGlasses().inOrder();
        System.out.println(treeHelper.getTreeOfGlasses().size());
    }

}
