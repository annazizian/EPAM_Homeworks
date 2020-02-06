package set.binarytree;

import static java.lang.Math.max;

/**
 * AVL Binary search tree implementation in Java
 *
 * @author Anna Azizyan
 */

public class AVLTree<T extends Comparable<T>> {
    private Node root;

    public AVLTree(T root) {
        this.root = new Node(root);
    }

    /**
     * data structure that represents a node in the tree
     */

    public static class Node<T extends Comparable<T>> {
        T key;
        Node leftChild;
        Node rightChild;
        int height;

        public Node(T value) {
            key = value;
            leftChild = null;
            rightChild = null;
            height = 0;
        }

        public Node(Node<T> node) {
            this.key = node.key;
            this.rightChild = node.rightChild;
            this.leftChild = node.leftChild;
            this.height = 0;

        }
    }

    public void insert(Node node) {
        insert(root, node);
    }

    public Node<T> insert(Node current, Node node) {
        if (current == null) {
            current = node;
            return current;
        } else if (current.key.compareTo(node.key) < 0) {
            current.rightChild = insert(current.rightChild, node);
        } else if (current.key.compareTo(node.key) > 0) {
            current.leftChild = insert(current.leftChild, node);
        }

        calculateHeight(current);
        if (current.leftChild == null) {
            if (current.rightChild == null) {
                return current;
            } else {
                if (current.rightChild.height > 0) {
                    current = balance(current);
                }
            }
        } else if (current.rightChild == null) {
            if (current.leftChild.height > 0) {
                current = balance(current);
            }
        } else if (Math.abs(current.leftChild.height - current.rightChild.height) > 1) {
            current = balance(current);
        }
        return current;
    }

    public void calculateHeight(Node node) {
        int height = 0;
        if (node.leftChild != null) {
            height = node.leftChild.height + 1;
        }
        if (node.rightChild != null) {
            height = max(height, node.rightChild.height + 1);
        }
        node.height = height;
    }

    public Node<T> balance(Node node) {
        if (node.leftChild == null) {
            if (node.rightChild.leftChild != null) {
                node.rightChild = rotateRight(node.rightChild);
            }
            node = rotateLeft(node);
        } else if (node.rightChild == null) {
            if (node.leftChild.rightChild != null) {
                node.leftChild = rotateLeft(node.leftChild);
            }
            node = rotateRight(node);
        } else {
            if (node.leftChild.height - node.rightChild.height > 1) {
                node = rotateRight(node);
            } else {
                node = rotateLeft(node);
            }
        }
        calculateHeight(node);
        return node;
    }

    public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.leftChild);
        System.out.println(node.key + " ");
        inOrder(node.rightChild);
    }

    public Node<T> rotateRight(Node node) {
        boolean check = (node == root);
        Node temp = new Node(node);
        temp.leftChild = node.leftChild.rightChild;
        node = node.leftChild;
        node.rightChild = temp;
        if (check) {
            root = node;
        }
        calculateHeight(temp);
        return node;
    }

    public Node<T> rotateLeft(Node node) {
        boolean check = node == root;
        Node temp = new Node(node);
        node = node.rightChild;
        temp.rightChild = node.leftChild;
        node.leftChild = temp;
        if (check == true) {
            root = node;
        }
        calculateHeight(temp);
        return node;
    }

    public Node getRoot() {
        return root;
    }
}
