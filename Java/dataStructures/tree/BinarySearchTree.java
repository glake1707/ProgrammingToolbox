/**
 * Created by gabriel on 1/17/18.
 */
public class BinarySearchTree<E extends Comparable<E>> {
//getInDegree, getOutDegree, getDegree, checkCorrupt (indegree > 1), countLeaves, getLevel
    //getHeight,
    private int count = 0;
    static class Node<E> {
        public E value;
        public Node right;
        public Node left;

        public Node(E value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    private Node root;

    public void clear() {
        this.root = null;
    }

    /*
        insert a node into the tree following the rules of a binary search tree
     */
    public Node<E> insert(Node current, E e) {
        Node<E> t = new Node<>(e, null, null);
        if(this.root == null) {
            this.root = t;
        } else if (current == null) {
            current = t;
        } else if (e.compareTo((E)current.value) >= 0) {
            current.right = insert(current.right, e);
        } else {
            current.left = insert(current.left, e);
        }
        return current;
    }


    public void printPreOrder(Node current) {
        if (current != null) {
            System.out.println("" + current.value);
            printPreOrder(current.left);
            printPreOrder(current.right);
        }
    }

    public void printInOrder(Node current) {
        if (current != null) {
            printInOrder(current.left);
            System.out.println("" + current.value);
            printInOrder(current.right);
        }
    }

    public void delete() {

    }

    public <T> T[] preOrderArray(T[] t) {

    }

    public <T> T[] inOrderArray(T[] t) {

    }


    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 5);
        bst.insert(bst.root, 11);
        bst.insert(bst.root, 15);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 12);
        bst.insert(bst.root, 11);
        bst.printPreOrder(bst.root);
        bst.printInOrder(bst.root);
        bst.clear();
        bst.printInOrder(bst.root);
        bst.insert(bst.root, 0);
        bst.printPreOrder(bst.root);
    }


}
