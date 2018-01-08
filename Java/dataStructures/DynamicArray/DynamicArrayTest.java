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

    public void printArray() {
        int i = 0;
        while (list.getElement(i) != null) {
            System.out.println(list.getElement(i));
            i++;
        }
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
        list.clear();
        for(int i = 0; i < 12; i++) { //{a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,a11}
            list.append("a" + i);
        }

        list.deleteByIndex(3);
        list.deleteByIndex(3);
        list.deleteByIndex(3);
        String[] expected = {"a0", "a1", "a2", "a6"};
        //printArray();

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

    @Test (timeout = 1000)
    public void testPrepend() {
        list.clear();
        for (int i = 0; i < 8; i++) {
            list.prepend("a" + i);
        }

        assertTrue(list.getLength() == 10);
        assertTrue(list.getSize() == 8);
        String expected = "a7";
        String actual = list.getElement(0);
        String message = "test prepend() should insert new elements at index 0";
        assertEquals(message, expected, actual);
        assertTrue(list.getElement(7).equals("a0"));
    }

    @Test (timeout = 1000)
    public void testInsertBeginningMiddleEnd() {
        list.clear();
        for(int i = 0; i < 7; i++) {
            list.append("a" + i);
        }
        list.insert(0,"0");
        list.insert(3,"1");
        list.insert(9,"2");

        assertTrue(list.getElement(0).equals("0"));
        assertTrue(list.getElement(3).equals("1"));
        assertTrue(list.getElement(9).equals("2"));
    }

    @Test(timeout = 1000)
    public void testDeleteSingleMultiple() {
        list.clear();
        for(int i = 0; i < 7; i++) {
            list.append("a" + i);
        }

        list.append("0");
        list.delete("0");
        assertFalse(list.contains("0"));
        list.append("0");
        list.prepend("0");
        list.insert(3, "0");
        list.delete("0");
        assertFalse(list.contains("0"));
    }

    @Test (timeout = 1000)
    public void testindexOf() {
        list.clear();
        for(int i = 0; i < 12; i++) {
            list.append("a" + i);
        }
        assertTrue(list.indexOf("a4") == 4);
        assertTrue(list.indexOf("a11") == 11);
    }

    @Test (timeout = 1000)
    public void testIndexOfs() {
        list.clear();
        for(int i = 0; i < 12; i++) {
            list.append("a" + i);
        }

        list.insert(0, "0");
        list.insert(5, "0");
        list.insert(6, "0");
        list.insert(11, "0");
        int[] ind = list.indexOfs("0");
        int[] expected = {0,5,6,11};
        assertArrayEquals(expected, ind);
        int[] expected2 = {-1};
        int[] i = list.indexOfs("k");
        assertArrayEquals(expected2, i);
    }

    @Test (timeout = 1000)
    public void testClearBetween() {
        list.clear();
        for(int i = 0; i < 12; i++) { //{a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,a11}
            list.append("a" + i);
        }
        list.clearBetween(0, 3);
        String[] expected = {"a4", "a5", "a6", "a7", "a8", "a9", "a10", "a11"};
        assertTrue(list.getElement(0).equals("a4"));
        assertTrue(list.getElement(7).equals("a11"));

        list.clear();
        for(int i = 0; i < 12; i++) { //{a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,a11}
            list.append("a" + i);
        }
        list.clearBetween(9, 5);
        String[] expected2 = {"a0", "a1", "a2", "a3", "a4", "a10", "a11"};
        String[] actual = new String[list.getSize()];
        actual = list.toArray(actual);
        assertArrayEquals(expected2, actual);
    }

    @Test (timeout = 1000)
    public void testToArray() {
        list.clear();
        for(int i = 0; i < 5; i++) { //{a0, a1, a2, a3, a4}
            list.append("a" + i);
        }

        String[] arr = new String[5];
        arr = list.toArray(arr);
        String[] expected = {"a0", "a1", "a2", "a3", "a4"};
        assertArrayEquals(expected, arr);



    }
}

