/**
 * Created by gabriel on 1/8/18.
 */
public class LinkedList<E> {

    private static class Node<E> {
        public E value;
        public Node next;
    }

    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void printList() {
        Node t = head;
        System.out.print("{ ");
        while (t != null) {
            System.out.print(t.value + " ");
            t = t.next;
        }
        System.out.print("}");
    }

    public int getSize() {
        return this.size;
    }

    public void append(E e) {
        Node<E> temp = new Node<>();
        temp.value = e;
        temp.next = null;
        if (head == null) {
            head = temp;
            this.size++;
        } else  {
            Node t = head;
            while (t.next != null ) {
                t = t.next;
            }
            t.next = temp;
            this.size++;
        }
    }
    public void prepend(E e) {
        Node<E> temp = new Node<E>();
        temp.value = e;
        temp.next = head;
        this.size++;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        }
        Node t = head.next;
        while(t.next != null) {
            t = t.next;
        }
        t.next = null;
        this.size--;
    }

    public boolean contains(Object o) {
        Node t = head;
        while(t !=  null) {
            if (t.value.equals(o)) {
                return true;
            }
            t = t.next;
        }
        return false;
    }

    public E getFirst() {
        return (E)head.value;
    }

    public E getLast() {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return (E) head.value;
        } else {
            Node t = head.next;
            while (t.next != null) {
                t = t.next;
            }
            return (E)t.value;
        }
    }
}
