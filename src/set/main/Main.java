package set.main;

import set.binarytree.AVLTree;

public class Main {
    public static void main(String[] args) {
        AVLTree<Integer> tree = new AVLTree<>(50);
        tree.insert(new AVLTree.Node(13));
        tree.insert(new AVLTree.Node(41));
        tree.insert(new AVLTree.Node(5));
        tree.insert(new AVLTree.Node(11));
        tree.insert(new AVLTree.Node(36));
        tree.insert(new AVLTree.Node(2));
        tree.insert(new AVLTree.Node(41));
        tree.inOrder(tree.getRoot());
    }
}
