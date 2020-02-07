package set.main;

import set.binarytree.AVLTree;
import set.helper.TreeHelper;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        TreeHelper treeHelper = new TreeHelper();
        treeHelper.createStudentsSet();
        treeHelper.printSet(treeHelper.createStudentsSet());
    }

}
