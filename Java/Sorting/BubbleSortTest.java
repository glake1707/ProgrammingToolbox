/**
 * Created by gabriel on 6/28/17.
 */
import org.junit.*;
import static org.junit.Assert.*;



public class BubbleSortTest {
    private Sort sort;

    @Before
    public void setUp() throws Exception {
        sort = new Sort();
    }

    @Test(timeout = 100)
    public void testSingleElement() {
        int[] arr = {1};
        String message = "bubbleSort(int[] array): test sorting single element";
        sort.bubbleSort(arr);
        int[] expected = {1};
        assertArrayEquals(message, expected, arr);
    }

    @Test (timeout = 100)
    public void testTwoSameElement() {
        int[] arr = {5, 5};
        String message = "bubbleSort(int[] array): test sorting an array with duplicate elements";
        sort.bubbleSort(arr);
        int[] expected = {5, 5};
        assertArrayEquals(message, expected, arr);
    }

    @Test (timeout = 100)
    public void testBasicPositiveArray() {
        int[] arr = {4, 5, 2, 3, 8, 9, 8, 20, 8, 93};
        String message = "bubbleSort(int[] array): test  basic positive number sorting";
        sort.bubbleSort(arr);
        int[] expected = {2, 3, 4, 5, 8, 8, 8, 9, 20, 93};
        assertArrayEquals(message, expected, arr);
    }

    @Test (timeout = 100)
    public void testBasicArrayNegative() {
        int[] arr = {0, 2, 5, -3, 68, -12, -4, 90, -100, 45, 3, 3, 3, -3, -10};
        String message = "bubbleSort(int[] array): test basic mixed array";
        sort.bubbleSort(arr);
        int[] expected = {-100, -12, -10, -4, -3, -3, 0, 2, 3, 3, 3, 5, 45, 68, 90};
        assertArrayEquals(message, expected, arr);
    }

}
