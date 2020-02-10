package set.binarytree;

import java.util.NoSuchElementException;

/**
 * Binary search tree implementation in Java
 *
 * @author Anna Azizyan
 */

public class BinarySearchTree<T extends Comparable<T>> {
    private Node<T> root;
    private int size = 0;

    public Node<T> getRoot() {
        return root;
    }

    /**
     * data structure that represents a node in the tree
     */

    private class Node<T> {
        T key;
        Node<T> leftChild;
        Node<T> rightChild;

        public Node(T key) {
            this.key = key;
        }

        @Override
        public String toString() {
            return "Node [data=" + key + "]";
        }
    }

    /**
     * Method to add a node to tree
     *
     * @param value that is inserted into the tree
     */
    public void add(T value) {
        if (value == null) {
            throw new IllegalArgumentException("Can not contain null value");
        }
        if (size == 0) {
            root = new Node<T>(value);
            size++;
        } else if (!contains(value)) {
            add(root, value);
        }
    }

    /**
     * Method to add the node in a tree
     *
     * @param rootNode tree that new node is added to
     * @param value    that is inserted to the tree
     * @return {@link Node}
     */
    private Node<T> add(Node<T> rootNode, T value) {
        if (rootNode == null) {
            return null;
        }
        Node<T> newNode = new Node<T>(value);
        if ((newNode.key).compareTo(rootNode.key) < 0) {
            if (rootNode.leftChild != null) {
                rootNode.leftChild = add(rootNode.leftChild, value);
            } else {
                rootNode.leftChild = newNode;
            }
        } else {
            if (rootNode.rightChild != null) {
                rootNode.rightChild = add(rootNode.rightChild, value);
            } else {
                rootNode.rightChild = newNode;
            }
        }
        size++;
        return rootNode;
    }

    /**
     * Method to check size of tree
     */
    public int size() {
        return size(root);
    }

    /**
     * Find the size of the tree from a given node
     */
    private int size(Node<T> root) {
        if (root == null) {
            return 0;
        } else {
            return (size(root.leftChild)) + 1 + (size(root.rightChild));
        }
    }

    /**
     * Method to print the tree InOrder
     * InOrder : Left -> Root -> Right
     *
     * @param node tree that the method traverse through.
     */
    private void printInOrder(Node<T> node) {
        if (node == null) {
            return;
        }
        printInOrder(node.leftChild);
        System.out.print(node.key + "\n");
        printInOrder(node.rightChild);
    }

    public void inOrder() {
        printInOrder(getRoot());
    }

    /**
     * Remove method that can be accessed by the user in order
     * to remove elements from AVL tree.
     * <p>
     *
     * @param t that is removes from the tree
     */

    public void remove(T t) {
        if (t == null) {
            throw new IllegalArgumentException("Can not remove null value");
        }
        remove(root, t);
    }

    /**
     * Retrieves the node that will replaced removed node. Gets the rightmost
     * node in the left subtree of the given node.
     *
     * @param node that data is being removed from
     * @return data of rightmost node in the left subtree.
     */
    private T getPredecessor(Node<T> node) {

        if (node.leftChild == null) {
            throw new NoSuchElementException("Error: there should be a left chlid");
        } else {
            Node<T> current = node.leftChild;
            while (current.rightChild != null) {
                current = current.rightChild;
            }
            return current.key;
        }
    }

    /**
     * Searchers through the tree to find node that needs
     * to be removed and calls remove method when data is found.
     *
     * @param current that data is being removed from.
     * @param value    that is removed from the tree structure.
     * @return The new tree structure after data has been removed.
     */

    public Node<T> remove(Node<T> current, T value) {
        if (current == null) {
           return null;
        }
        if (value.compareTo(current.key) < 0) {
            current.leftChild = remove(current.leftChild, value);
        } else if (value.compareTo(current.key) > 0) {
            current.rightChild = remove(current.rightChild, value);
        } else {
            if (current.leftChild == null && current.rightChild == null) {
                return null;
            }
            else if (current.leftChild == null) {
                return current.rightChild;
            }
            else if (current.rightChild == null) {
                return current.leftChild;
            } else {
                current.key = getPredecessor(current);
                current.leftChild = remove(current.leftChild, current.key);
                size--;
                return current;
            }
        }
        return current;
    }

    /**
     * Contains method is for checking whether
     * a piece of data exists in the tree structure.
     *
     * @param t that is searched for in the tree.
     * @return true if data is found in the tree.
     */
    public boolean contains(T t) {
        Node<T> node = new Node<>(t);
        return contains(root, node);
    }

    /**
     * Contains method which searchs through the tree structure
     * in order to find whether data exists in the tree.
     *
     * @param current tree that is being searched.
     * @param node    that is searched for in the tree.
     * @return true if data is found.
     */
    private boolean contains(Node<T> current, Node<T> node) {
        if (current == null) {
            return false;
        } else if (current.key.compareTo(node.key) < 0) {
            return contains(current.rightChild, node);
        } else if (current.key.compareTo(node.key) > 0) {
            return contains(current.leftChild, node);
        } else {
            return true;
        }
    }
}