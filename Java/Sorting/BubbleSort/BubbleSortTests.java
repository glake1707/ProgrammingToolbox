/**
 * Created by gabriel on 6/28/17.
 */
import org.junit.*;
import static org.junit.Assert.*;



public class BubbleSortTests {
    private BubbleSort bub;

    @Before
    public void setUp() throws Exception {
        bub = new BubbleSort();
    }

    @Test(timeout = 100)
    public void testSingleElement() {
        int[] arr = {1};
        String message = "bubbleSort(int[] array): test sorting single element";
        bub.bubbleSort(arr);
        int[] expected = {1};
        assertArrayEquals(message, expected, arr );
    }

    @Test (timeout = 100)
    public void testTwoSameElement() {
        int[] arr = {5, 5};
        String message = "bubbleSort(int[] array): test sorting an array with duplicate elements";
        bub.bubbleSort(arr);
        int[] expected = {5, 5};
        assertArrayEquals(message, expected, arr);
    }

}
