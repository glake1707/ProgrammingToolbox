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

        list.printList();
        assertTrue(list.getSize() == 10);
        assertTrue(list.getFirst().equals("a0"));
        assertTrue(list.getLast().equals("a9"));


    }

}
