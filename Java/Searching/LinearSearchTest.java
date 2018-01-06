/**
 * Created by gabriel on 7/21/17.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class LinearSearchTest {
    private LinearSearch ls;

    @Before
    public void setup() {
        ls = new LinearSearch();
    }

    @Test (timeout = 1000)
    public void testNoElementInList() {
        int[] list = {1, -3, 4, 2, 4, -2};
        int target = 7;
        int[] expected = {-1};
        int[] actual = ls.search(list, target);
        String message = "search(int[] list, int target): test search with element not in list";
        assertArrayEquals(message, actual, expected);
    }

    @Test (timeout = 1000)
    public void testEmptyList() {
        int[] list = {};
        int target = 7;
        int[] expected = {-1};
        int[] actual = ls.search(list, target);
        String message = "search(int[] list, int target): test search on an empty list";
        assertArrayEquals(message, actual, expected);
    }

    @Test(timeout = 1000)
    public void testSingleElementList() {
        int[] list = {10};
        int target = 10;
        int[] expected = {0};
        int[] actual = ls.search(list, target);
        String message = "search(int[] list, int target): test single element array target";
        assertArrayEquals(message, actual, expected);
    }

    @Test(timeout = 1000)
    public void testMultiElementList() {
        int[] list = {10,4,5,6,2,5,3,8,56,7,3,4,6,5};
        int target = 56;
        int[] expected = {8};
        int[] actual = ls.search(list, target);
        String message = "search(int[] list, int target): test multi-element array target";
        assertArrayEquals(message, actual, expected);
    }

    @Test(timeout = 1000)
    public void testMultiTargetList() {
        int[] list = {10,4,5,6,2,5,3,8,56,7,3,4,6,5};
        int target = 4;
        int[] expected = {1,11};
        int[] actual = ls.search(list, target);
        String message = "search(int[] list, int target): test a list with multiple instances of the target";
        assertArrayEquals(message, actual, expected);
    }
}
