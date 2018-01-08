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
                if (o != null && array[i] != null) {
                    if (array[i].equals(o)) return true;
                }
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
            int size = 1;
            int[] indices = new int[size];
            if (!contains(e)) {
                indices[0] = -1;
                return indices;
            }
            size = 0;
            for (int i = 0; i < this.size; i++) {
                if (array[i].equals(e)) {
                    size++;
                }
            }
            indices = new int[size];
            int j = 0;
            for (int i = 0; i < this.size; i++) {
                if (array[i].equals(e)) {
                    indices[j++] = i;
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
                    if (((E)array[i]).equals(e)) {
                        deleteByIndex(i);
                    }
                }
            }
        }

        public void deleteByIndex(int index) throws IllegalArgumentException {
            if (index >= 0 && index < this.size) {
                if (index == (this.size - 1)) {
                    array[index] = null;
                } else {
                    if (this.size == array.length) {
                        for (int i = index; i < this.size - 1; i++) {
                            array[i] = array[i + 1];
                        }
                        array[this.size] = null;
                    } else {
                        for (int i = index; i < this.size; i++) {
                            array[i] = array[i + 1];
                        }
                    }
                }
                //array[this.size] = null;
                this.size--;
                resizeArray();
            } else {
                throw new IllegalArgumentException();
            }
        }

        public E getElement(int index) {
            if (index >= 0 && index < this.size) {
                return (E)array[index];
            }
            return null;
        }

        public void clear() {
            array = new Object[this.initialCapacity];
            this.size = 0;
        }

        public void clearBetween(int a, int b) {
            if (a < 0) {
                a = 0;
            } else if (b > this.size - 1) {
                b = this.size - 1;
            } else if (b < a) {
                int i = b;
                b = a;
                a = i;
            }
            if (b >= this.size && a == 0) {
                clear();
            } else if (a == b) {
                deleteByIndex(a);
            } else if (a == 0) {
                Object[] temp1 = new Object[this.size - b];
                int j = 0;
                for (int i = 1; i < this.size - b; i++) {
                    temp1[j++] = array[b + i];
                }
                array = temp1;
                this.size = this.size - b;
            } else if ( b == this.size - 1) {
                Object[] temp2 = new Object[a];
                for (int i = 0; i < a; i++) {
                    temp2[i] = array[i];
                }
                array = temp2;
                this.size = a;
            } else if ((b - a) == 1) {
                deleteByIndex(a);
                deleteByIndex(a);
            } else {
                for (int i = 0; i <= b - a; i++) {
                    deleteByIndex(a);
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
}
