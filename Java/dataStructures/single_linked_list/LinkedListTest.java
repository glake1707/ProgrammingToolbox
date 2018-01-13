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
        assertTrue(list.getIndex(4).equals("b4"));
    }

}
