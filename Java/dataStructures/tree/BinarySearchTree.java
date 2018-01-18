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

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(bst.root, 10);
        bst.insert(bst.root, 5);
        bst.insert(bst.root, 11);
        bst.insert(bst.root, 15);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 12);bst.insert(bst.root, 11);
        bst.printPreOrder(bst.root);
    }

}
