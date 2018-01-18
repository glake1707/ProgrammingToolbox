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
        head = temp;
        this.size++;
    }

    public void deleteLast() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            clear();
            return;
        }
        Node t = head;
        while(t.next.next != null) {
            t = t.next;
        }
        t.next = null;
        this.size--;
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
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

    public E getElement(int index) {
        if (head == null) {
            return null;
        }
        if (index < 0 || index >= getSize()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            return getFirst();
        }
        if (index == getSize() - 1) {
            return getLast();
        }

        Node t = head;
        for (int i = 0; i < index; i++) {
            t = t.next;
        }
        return (E)t.value;
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

    public void insert(int index, E e) {
        if (index < 0 || index > getSize()) {
            throw new IndexOutOfBoundsException();
        }
        if(head == null) {
            prepend(e);
        }
        Node<E> temp = new Node<>();
        temp.value = e;

        if (index == getSize() - 1) {
            append(e);
            return;
        }
        if (index == 0) {
            prepend(e);
            return;
        }
        Node t = head;
        for (int i = 0; i < index - 1; i++ ) {
            t = t.next;
        }
        temp.next = t.next;
        t.next = temp;
        this.size++;
    }

    public void delete(E e) {
        if (head == null) {
            return;
        } else if (!contains(e)) {
            return;
        }
        if (getSize() == 1) {
            clear();
            return;
        }


        if (getFirst().equals(e)) {
            deleteFirst();
            delete(e);
        }
        if (getLast().equals(e)) {
            deleteLast();
            delete(e);
        }
        Node t = head;
        while (t.next != null) {
            if (t.next.value.equals(e)) {
                t.next = t.next.next;
                this.size--;
            }
            t = t.next;
        }
    }

    public <T> T[] toArray(T[] t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (t.length < getSize()) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;
        int i = 0;
        while (current != null) {
            t[i] = (T)current.value;
            i++;
            current = current.next;
        }
        return t;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            for (Node t = head; t.next != null; t = t.next) {
                if (t.value != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public void deleteByIndex(int index) {
        if (head == null) {
            return;
        } else if (index < 0 || index > getSize()) {
            return;
        } else {
            if (index == 0) {
                deleteFirst();
                return;
            } else if (index == getSize() - 1) {
                deleteLast();
                return;
            }
            int i = 0;
            for (Node t = head; t.next != null; t = t.next) {
                if (index-1 == i) {
                    t.next = t.next.next;
                    this.size--;
                    return;
                }
                i++;
            }
        }
    }

}
