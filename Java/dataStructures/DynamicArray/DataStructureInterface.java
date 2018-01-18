/**
 * Created by gabriel on 7/23/17.
 */
public interface DataStructureInterface<E> {

    public void append(E e); //appends the object to the data structure
    public void insert(int index, E e); //inserts the object at index
    public void prepend(E e); //prepends the object to the data structure
    public E getElement(int index); //returns the object at the specified index
    public void deleteByIndex(int index); //deletes the object at index
    public void delete(E e); //deletes all instances of specified object
    public void clear(); //clear the contents and resizes the structure to speficified size
    public <T> T[] toArray(T[] t); //returns an array containing the objects in the structure
    public int indexOf(E e); // returns the index of the first element
    public int[] indexOfs(E e); //returns the indices of all elements in an int array
    public void clearBetween(int a, int b); //deletes the section between a and b inclusive
    public boolean contains(Object o); //returns true if the element exists in the structure
    public boolean isEmpty(); //returns true if the structure is empty
    public int getSize(); //returns the number of elements in the data structure
}
