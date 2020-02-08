package set.main;

import set.helper.TreeCreator;

public class Main {
    public static void main(String[] args) {
        TreeCreator treeHelper = new TreeCreator();
        treeHelper.createCoffeeSet();
        treeHelper.createStudentsSet();
        treeHelper.createGlassesSet();

        treeHelper.getTreeOfStudents().inOrder();
        System.out.println(treeHelper.getTreeOfStudents().size());
        treeHelper.getTreeOfStudents().remove(treeHelper.studentCreation.student3);
        treeHelper.getTreeOfStudents().inOrder();
        System.out.println(treeHelper.getTreeOfStudents().size() + "\n");

        treeHelper.getTreeOfCoffees().inOrder();
        System.out.println(treeHelper.getTreeOfCoffees().size() + "\n");

        treeHelper.getTreeOfGlasses().inOrder();
        System.out.println(treeHelper.getTreeOfGlasses().size());
    }

}
