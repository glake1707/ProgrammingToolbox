/**
 * Created by gabriel on 7/21/17.
 */
import org.junit.*;
import static org.junit.Assert.*;

public class BubbleSortAlphaTest {
    private Sort sort;

    @Before
    public void setup() throws Exception {
        sort = new Sort();
    }

    @Test(timeout = 1000)
    public void testTwoElementArrayBasic() {
        String[] arr = {"b", "a"};
        sort.bubbleSortAlpha(arr);
        String[] expected = {"a", "b"};
        String message = "bubbleSortAlpha(String[] array): test sorting two single letter strings";
        assertArrayEquals(message, expected, arr);
    }

    @Test(timeout = 1000)
    public void testTwoElementArraySameLength() {
        String[] arr = {"monday", "friday"};
        sort.bubbleSortAlpha(arr);
        String[] expected = {"friday", "monday"};
        String message = "bubbleSortAlpha(String[] array): test sorting two words of the same length";
        assertArrayEquals(message, expected, arr);
    }

    @Test(timeout = 1000)
    public void testTwoElementArrayDifLength() {
        String[] arr = {"monday", "friday night"};
        sort.bubbleSortAlpha(arr);
        String[] expected = {"friday night", "monday"};
        String message = "bubbleSortAlpha(String[] array): test sorting two different length words";
        assertArrayEquals(message, expected, arr);
    }

    @Test(timeout = 1000)
    public void testThreeElementArray() {
        String[] arr = {"tuesday", "monday", "friday night"};
        sort.bubbleSortAlpha(arr);
        String[] expected = {"friday night", "monday", "tuesday"};
        String message = "bubbleSortAlpha(String[] array): test sorting more than two words";
        assertArrayEquals(message, expected, arr);
    }

    @Test(timeout = 1000)
    public void testMultiElementArrayCapitalLetters() {
        String[] arr = {"Tony Stark", "avengers", "CAPTain AmeriCa"};
        sort.bubbleSortAlpha(arr);
        String[] expected = {"avengers", "CAPTain AmeriCa", "Tony Stark"};
        String message = "bubbleSortAlpha(String[] array): test sorting words with capitals";
        assertArrayEquals(message, expected, arr);
    }

    @Test(timeout = 1000)
    public void testMultiElementArrayWithNumbers() {
        String[] arr = {"abc1", "abc3", "abc1"};
        sort.bubbleSortAlpha(arr);
        String[] expected = {"abc1", "abc1", "abc3"};
        String message = "bubbleSortAlpha(String[] array): test sorting words with numbers";
        assertArrayEquals(message, expected, arr);
    }

}
