/**
 * Created by gabriel on 6/28/17.
 */
public class BubbleSort {

    /**
     * This bubblesort function can sort integer arrays
     * @return void
     * @param array
     */
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++ ) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j-1]) {
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * The main method shows a use case for bubbleSort
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {4,3,4,3,5,4,3,4,6,4,3,4,6,7,3,7,5,3};
        bubbleSort(arr);
        System.out.printf("{");
        int i = 0;
        for (int num : arr) {
                if (i < arr.length - 1)
                    System.out.printf("%d, ", num);
                else
                    System.out.printf("%d", num);
                i++;
        }
        System.out.printf("}\n");
    }

}
