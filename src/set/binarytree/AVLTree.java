package set.binarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static java.lang.Math.max;

/**
 * AVL Binary search tree implementation in Java
 *
 * @author Anna Azizyan
 */

public class AVLTree<T extends Comparable<T>> implements Iterable<T> {
    private Node root;
    private int size = 0;

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

    /**
     * Add method that can be accessed by the user in order
     * to add elements to AVL tree.
     *
     * @param node that is inserted into the tree
     */

    public void insert(Node node) {
        insert(root, node);
        size++;
    }

    /**
     * Add method compares data with code and recursively goes through the tree structure
     * until the correct position is found where the new data gets added.
     *
     * @param current tree that new node is added to
     * @param node    that is inserted to the tree
     */

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

    /**
     * Remove method that can be accessed by the user in order
     * to remove elements from AVL tree.
     *
     * @param node that is removes from the tree
     * @return
     */

    public Node remove(Node node) {
        // conditions for node with one child
        if (node.leftChild == null) {
            return node.rightChild;
        }
        // no right child return left child
        else if (node.rightChild == null) {
            return node.leftChild;
        } else {
            // node with two children
            T key = getPredecessor(node);
            node.key = (Comparable) node;
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
    private T getPredecessor(Node node) {

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

    public Node<T> remove(Node current, Node node) {
        if (current == null) {
            ; //do nothing
        } else if (current.key.compareTo(node.key) < 0) {
            current.rightChild = remove(current.rightChild, node);
        } else if (current.key.compareTo(node.key) > 0) {
            current.leftChild = remove(current.leftChild, node);
        } else {
            current = remove(current);
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
        }
        return current;
    }

    /**
     * Contains method is for checking whether
     * a piece of data exists in the tree structure.
     *
     * @param node that is searched for in the tree.
     * @return true if data is found in the tree.
     */
    public boolean contains(Node node) {

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
    private boolean contains(Node current, Node node) {
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

    /**
     * Iterator method allows user to traverse and print out
     * elements in the AVL tree.
     *
     * @return iterator<T> object
     */
    @Override
    public Iterator<T> iterator() {
        return (new TreeIterator());
    }

    /**
     * Private iterator class that implements methods hasNext() and next()
     * that is required in order for user to traverse through the AVl tree.
     * The inner iterator class allows it to access
     * the tree and maintain object oriented principles.
     */
    private class TreeIterator implements Iterator<T> {

        // instantiate data feel or iterator
        private Node<T> tree;
        private ArrayList<T> inOrderArray;
        private T dataReturned;

        // keep at counter
        int counter;
        int lastElement;

        /**
         * Constructor sets tree to root of the AVL tree.
         * It also calls inOrder method to add data to the array list
         * in an in order traversal way.
         */
        public TreeIterator() {

            this.tree = root;
            inOrderArray = new ArrayList<T>();
            // add elements to array
            inOrder(tree);
            // set counter to zero
            counter = 0;
            lastElement = inOrderArray.size();
        }

        /**
         * Allows user to check whether the tree contains another element.
         * The method must be called before next method is called.
         *
         * @return true if there is another element in the tree.
         */
        @Override
        public boolean hasNext() {
            // check size of array to see whether there are any more elements
            return (counter != lastElement);
        }

        /**
         * The next method accesses and returns the next data found in the tree.
         *
         * @return the next data in the tree.
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements");
            }
            // keep data
            dataReturned = inOrderArray.get(counter);
            counter++;
            // return the next data
            return dataReturned;
        }

        /**
         * In order traversal of data in the AVL tree.
         * Adds data to array list in order.
         *
         * @param node tree that the method traverse through.
         */
        private void inOrder(Node<T> node) {
            if (node == null) {
                return;
            }
            // go all the way to the left
            inOrder(node.leftChild);
            // add to array
            inOrderArray.add(node.key);
            // go right
            inOrder(node.rightChild);
        }
    }

    public Node getRoot() {
        return root;
    }

    public int getSize() {
        return size;
    }
}