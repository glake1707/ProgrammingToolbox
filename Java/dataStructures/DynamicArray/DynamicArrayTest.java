/**
 * Created by gabriel on 7/23/17.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    private DynamicArray<String> list;

    @Before
    public void setup() {
        list = new DynamicArray<String>(5);
    }

    @Test (timeout = 1000)
    public void testContructor() {
        int length = list.getLength();
        int numElements = list.getSize();
        int expectedLength = 5;
        int expectedSize = 0;
        String message1 = "test if the data structure is propper length";
        String message2 = "test for empty initial data structure";
        assertEquals(message1, expectedLength, length);
        assertEquals(message2, expectedSize, numElements);
    }

    @Test (timeout = 1000)
    public void testAppendFirst() {
        list.append("first element");
        assertFalse(!list.getElement(0).equals("first element")); //other append test
        String expected = "first element";
        String actual = list.getElement(0);
        assertFalse(!list.contains(expected)); //test contains method
        assertEquals(expected, actual); //test append method
        assertTrue(list.getSize() == 1); //test correct size
    }

    @Test (timeout = 1000)
    public void testClear() {
        list.clear();
        int expectedSize = 0;
        int actualSize = list.getSize();
        int expectedLength = list.initialCapacity;
        int actualLength = list.getLength();
        assertFalse(actualLength != expectedLength);
        assertFalse(actualSize != expectedSize);
    }

    @Test (timeout = 1000)
    public void testDeleteOne() {
        list.append("A");
        assertFalse(!list.getElement(0).equals("A"));
        assertTrue(list.getSize() == 1);
        list.deleteByIndex(0);
        String message = "test void deleteByIndex(int index)";
        assertEquals(message, null, list.getElement(0));
        assertTrue(list.getSize() == 0);
    }

    @Test (timeout = 1000)
    public void testResizeOutOfSpace() {
        list.clear();
        list.append("a");
        list.append("a");
        list.append("a");
        list.append("a");
        list.append("a");
        list.append("a");
        assertTrue(list.getSize() == 6);
        assertTrue(list.getLength() == 10);
        assertTrue(list.getElement(6) == null);
    }

    @Test (timeout = 1000)
    public void testDeleteByIndexMultiple() { //also test shrinking the array, resize called by deleteByIndex()
        list.clear();
        for(int i = 0; i < 7; i++) {
            list.append("a" + i);
        }
        assertTrue(list.getLength() == 10);
        for (int i = 5; i > 0; i--) {
            list.deleteByIndex(i);
        }

        assertTrue(list.getElement(0 ).equals("a0"));
        assertTrue(list.getElement(1).equals("a6"));
        assertTrue(list.getElement(2) == null);
        assertTrue(list.getSize() == 2);
        assertTrue(list.getLength() == 3);
    }

    @Test (timeout = 1000)
    public void testDeleteOneByIndexInvalid(){
        list.clear();
        try {
            list.deleteByIndex(0);
        } catch (IllegalArgumentException il) {
            assertTrue(true);
        }

        try {
            list.deleteByIndex(-1);
        } catch (IllegalArgumentException i) {
            assertTrue(true);
        }
    }

}
