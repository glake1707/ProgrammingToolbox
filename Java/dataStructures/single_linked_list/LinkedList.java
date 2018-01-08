/**
 * Created by gabriel on 1/8/18.
 */
public class LinkedList<E> {

    private static class Node<E> {
        public E value;
        public Node next;
    }

    private Node head = null;
    private int size = 0;

    public void clear() {
        head = null;
        size = 0;
    }

    public void append(E e) {
        Node<E> temp = new Node<E>();
        temp.value = e;
        temp.next = null;
        if (head == null) {
            head = temp;
            this.size++;
        } else {
            Node t = head.next;
            while (t != null ) {
                t = t.next;
            }
            t = temp;
            this.size++;
        }
    }
    public void prepend(E e) {

    }
}
