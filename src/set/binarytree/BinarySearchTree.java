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

    public class Node<T> {
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
        /* If size is zero, make it a root node */
        if (size == 0) {
            root = new Node<T>(value);
            size++;
        } else {
            /* Add the node */
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
        /* If root is null, return null */
        if (rootNode == null) {
            return null;
        }
        /* Create a new node */
        Node<T> newNode = new Node<T>(value);
        /* Compare with the root, if small, insert left else insert right */
        if ((newNode.key).compareTo(rootNode.key) <= 0) {
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
        /* Increase the size and return rootNode */
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
        /* If root is null, return 0 else
         * size of left subtree + size of right subtree
         * + 1 for root */
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
    public void printInOrder(Node<T> node) {
        /* If root is null, return , else print in order */
        if (node == null) {
            return;
        }
        printInOrder(node.leftChild);
        System.out.print(node.key + "\n");
        printInOrder(node.rightChild);
    }

    /**
     * Remove method that can be accessed by the user in order
     * to remove elements from AVL tree.
     * <p>
     *
     * @param t that is removes from the tree
     */

    public Node<T> remove(T t) {
        Node<T> node = new Node<>(t);
//         conditions for node with one child
        if (node.leftChild == null) {
            return node.rightChild;
        }
        // no right child return left child
        else if (node.rightChild == null) {
            return node.leftChild;
        } else {
//             node with two children
            T key = getPredecessor(node);
            node.key = (T) node;
            node.leftChild = remove(node.leftChild, node);
            size--;
            return node;
        }
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
            // there should be a left child
            throw new NoSuchElementException("Error: there should be a left chlid");
        } else {
            // keep current node
            Node<T> current = node.leftChild;
            // while there is still more right children
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
     * @param node    that is removed from the tree structure.
     * @return The new tree structure after data has been removed.
     */

    public Node<T> remove(Node<T> current, Node<T> node) {
        if (current == null) {
            ; //do nothing
        } else if (current.key.compareTo(node.key) < 0) {
            current.leftChild = remove(current.leftChild, node);
        } else if (current.key.compareTo(node.key) > 0) {
            current.rightChild = remove(current.rightChild, node);
        } else {
            current = remove(current, node);
            if (current.leftChild == null) {
                if (current.rightChild == null) {
                    return current;
                }
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
        // if tree is empty
        if (current == null) {
            return false;
        } else if (current.key.compareTo(node.key) < 0) {
            return contains(current.rightChild, node);
        } else if (current.key.compareTo(node.key) > 0) {
            return contains(current.leftChild, node);
        } else {
            // true if found
            return true;
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }
}