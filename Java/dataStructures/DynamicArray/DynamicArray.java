/**
 * Created by gabriel on 12/27/17.
 */
public class DynamicArray<E> implements DataStructureInterface<E> {
    private Object[] array;
    private int size;

    /*
        to instantiate: DynamicArray<E> array = new DynamicArray<E>(size);
     */
    public DynamicArray(int size) throws IllegalArgumentException {
        this.size = size;
        if (size < 0) {
            throw new IllegalArgumentException();
        }
        this.array = new Object[size];
    }

        public int getSize() {
            return this.size;
        }

        public boolean isEmpty() {
            if (this.size == 0) return false;
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
                array = new Object[2 * this.size];
                for (int i = 0; i < this.size; i++) {
                    array[i] = temp[i];
                }
            } else if (this.size < array.length / 3) {
                Object[] temp = array;
                array = new Object[this.size / 3];
                for (int i = 0; i < this.size; i++) {
                    array[i] = temp[i];
                }
            }
        }

        public void append(E e) {
            if (this.size < array.length) {
                array[this.size] = e;
            } else {
                resizeArray();
            }
        }

        public void prepend(E e) {
            if (this.size < array.length) {

            }
        }
}
