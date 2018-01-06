/**
 * Created by gabriel on 12/27/17.
 */
public class DynamicArray<E> implements DataStructureInterface<E> {
    private Object[] array;
    private int size;
    public int initialCapacity;

    /*
        to instantiate: DynamicArray<E> array = new DynamicArray<E>(size);
     */
    public DynamicArray(int size) throws IllegalArgumentException {
        this.size = 0;
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        this.array = new Object[size];
        this.initialCapacity = size;
    }

        public int getSize() {
            return this.size;
        }
        public int getLength() {
            return this.array.length;
        }

        public boolean isEmpty() {
            if (this.size != 0) return false;
            return true;
        }

        public boolean contains(Object o) {
            for (int i = 0; i < array.length; i++) {
                if(array[i].equals(o)) return true;
            }
            return false;
        }

        public int indexOf(E e) {
            for (int i = 0; i < this.size; i++) {
                if (array[i].equals(e)) {
                    return i;
                }
            }
            return -1;
        }
        public int[] indexOfs(E e) {
            int size = 0;
            int[] indices = new int[size];
            if (!contains(e)) {
                indices[0] = -1;
                return indices;
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals(e)) {
                    indices[++size] = i;
                }
            }
            return indices;
        }

        public void resizeArray() {
            if (this.size == array.length) {
                Object[] temp = array;
                array = new Object[2 * temp.length];
                for (int i = 0; i < this.size; i++) {
                    array[i] = temp[i];
                }
            } else if (this.size < array.length / 3) {
                Object[] temp = array;
                array = new Object[temp.length / 3];
                for (int i = 0; i < this.size; i++) {
                    array[i] = temp[i];
                }
            }
        }

        public void append(E e) {
            if (this.size < array.length) {
                array[this.size] = e;
                this.size++;
            } else {
                resizeArray();
                append(e);
            }
        }

        public void prepend(E e) {
            if (this.size < array.length) {
                for (int i = 0; i < this.size; i++) {
                    array[this.size - i] = array[this.size - i - 1];
                }
                array[0] = e;
                this.size++;
            } else {
                resizeArray();
                prepend(e);
            }
        }

        public void insert(int index, E e) throws IllegalArgumentException {
            if (index < 0 || index > this.size) throw new IllegalArgumentException();
            if (this.size < array.length) {
                    for (int i = this.size - 1; i >= index; i--) {
                        array[i + 1] = array[i];
                    }
                array[index] = e;
                this.size++;
                resizeArray();
            } else {
                resizeArray();
                insert(index, e);
            }
        }

        public void delete(E e) {
            if (contains(e)) {
                for (int i = 0; i < this.size; i++) {
                    if (array[i].equals(e)) {
                        deleteByIndex(i);
                    }
                }
            }
        }

        public void deleteByIndex(int index) throws IllegalArgumentException {
            if (index >= 0 && index < this.size) {
                for (int i = index + 1; i < this.size; i++) {
                    array[i-1] = array[i];
                }
                this.size--;
                resizeArray();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public E getElement(int index) {
            return (E)array[index];
        }

        public void clear() {
            array = new Object[this.initialCapacity];
        }

        public void clearBetween(int a, int b) {
            Object[] temp1 = new Object[a];
            Object[] temp2 = new Object[this.size - b];
            for (int i = 0; i <= a; i++) {
                temp1[i] = array[i];
            }
            for (int i = b+1; i < this.size; i++) {
                temp2[i] = array[i];
            }

            for (int i = 0; i < a + this.size - b; i++) {
                if (i < temp1.length) {
                    array[i] = temp1[i];
                } else if (i >= temp1.length) {
                    array[i] = temp2[i];
                }
            }
            resizeArray();
        }

        public <T> T[] toArray(T[] t) throws NullPointerException, IndexOutOfBoundsException, ArrayStoreException {
            if (t == null) {
                throw new NullPointerException();
            }
            if (t.length < this.size) {
                throw new IndexOutOfBoundsException();
            }
                for (int i = 0; i < this.size; i++) {
                    if (t instanceof Object){
                        t[i] = (T) array[i];
                    } else {
                        throw new ArrayStoreException();
                    }

                }
            return t;
        }

    public static void printArray(Object[] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", (int)arr[i]);
        }
        System.out.print("}\n");
    }

        public static void main(String[] args) {
            DynamicArray<String> arr = new DynamicArray<String>(10);
            arr.append("1");
            String array[] = new String[1];
            array = arr.toArray(array);
            printArray(array);

        }
}
