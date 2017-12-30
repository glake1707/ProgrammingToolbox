/**
 * Created by gabriel on 12/27/17.
 */
public class DynamicArray<E> implements DataStructureInterface {
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


}
