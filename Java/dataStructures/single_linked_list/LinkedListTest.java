/**
 * Created by gabriel on 1/8/18.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class LinkedListTest {
    private LinkedList<String> list;

    @Before
    public void setup() {
        list = new LinkedList<String>();
    }

    @Test (timeout = 1000)
    public void testAppend() {
        list.clear();
        list.append("0");
        assertTrue(list.contains("0"));
        assertTrue(list.getLast().equals("0"));
        assertTrue(list.getSize() == 1);

        list.clear();

        for (int i = 0; i < 10; i++) {
            list.append("a" + i);
        }

        assertTrue(list.getSize() == 10);
        assertTrue(list.getFirst().equals("a0"));
        assertTrue(list.getLast().equals("a9"));
    }

    @Test (timeout = 1000)
    public void testContains() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.append("a" + i);
        }

        assertTrue(list.contains("a0"));
        assertFalse(list.contains("a"));
        assertTrue(list.contains("a9"));
        assertTrue(list.contains("a4"));
    }

    @Test (timeout = 1000)
    public void testPrepend() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.prepend("a" + i);
        }

        assertTrue(list.getSize() == 10);
        assertTrue(list.getFirst().equals("a9"));
        assertTrue(list.getLast().equals("a0"));
    }

    @Test (timeout = 1000)
    public void testDeleteLast() {
        list.clear();
        list.append("a0");
        list.deleteLast();
        assertTrue(list.getLast() == null);

        for (int i = 0; i < 10; i++) {
            list.append("a" + i);
        }

        list.deleteLast();
        list.deleteLast();
        assertTrue(list.getLast().equals("a7"));
    }

    @Test (timeout = 1000)
    public void testInsert() {
        list.clear();
        try {
            list.insert(3, "a0");
        } catch (IndexOutOfBoundsException in) {
            assertTrue(true);
        }

        list.insert(0, "a0");
        assertTrue(list.getLast().equals("a0"));

        list.insert(1, "a1");
        assertTrue(list.getLast().equals("a1"));

        list.clear();
        for (int i = 0; i < 10; i++) {
            list.append("a" + i);
        }
        list.insert(4, "b4");
        assertTrue(list.getElement(4).equals("b4"));
    }

    @Test (timeout = 1000)
    public void testDeleteFirst() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.append("a" + i);
        }
        list.deleteFirst();
        list.deleteFirst();
        assertTrue(list.getFirst().equals("a2"));
        assertTrue(list.getSize() == 8);
    }

    @Test (timeout = 1000)
    public void testToArray() {
        list.clear();
        for (int i = 0; i < 10; i++) {
            list.append("a" + i);
        }
        String[] array = new String[8];
        try {
            array = list.toArray(array);
        } catch (IndexOutOfBoundsException e) {
            assertTrue(true);
        }
        String[] actual = new String[10];
        actual = list.toArray(actual);

        String message = "test toArray(t[] t): 10 element array";
        String[] expected = {"a0", "a1", "a2", "a3", "a4", "a5", "a6", "a7", "a8", "a9"};
        assertArrayEquals(message, expected, actual);
    }

    @Test (timeout = 1000)
    public void testDelete() {
        list.clear();
        list.append("a0");
        list.delete("a1");
        assertTrue(list.getElement(0).equals("a0"));
        list.delete("a0");
        assertTrue(list.getElement(0) == null);
        for (int i = 0; i < 10; i++) {
            list.append("a" + i);
        }

        list.delete("a0");
        assertTrue(list.getFirst().equals("a1"));
        list.delete("a9");
        assertTrue(list.getLast().equals("a8"));
        list.delete("a4");

        list.insert(4, "a4");
        list.insert(7, "a4");
        list.insert(3, "a4");
        list.delete("a4");
        String[] expected = {"a1", "a2", "a3", "a5", "a6", "a7", "a8"};
        String message = "test delete(): delete multiple";
        String[] actual = new String[7];
        actual = list.toArray(actual);
        assertArrayEquals(message, expected, actual);
    }

    @Test (timeout = 1000)
    public void testDeleteByIndex() {
        list.clear();
        for (int i = 0; i < 5; i++) {
            list.append("a" + i);
        }

        String[] expected = {"a0", "a1", "a2", "a3"};
        String[] expected2= {"a1", "a2", "a3", "a4"};
        String[] expected3 = {"a0", "a1", "a3", "a4"};
        String message = "testDeleteByIndex";
        String[] actual = new String[4];

        list.deleteByIndex(4);
        assertArrayEquals(message, expected, list.toArray(actual));
        list.insert(4, "a4");
        list.deleteByIndex(0);
        assertArrayEquals(message, expected2, list.toArray(actual));
        list.insert(0, "a0");
        list.deleteByIndex(2);
        list.printList();
        assertArrayEquals(message, expected3, list.toArray(actual));

    }
}
