/**
 * Created by gabriel on 7/21/17.
 */
public class Sort implements SortInterface {
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
    public static void bubbleSortAlpha(String[] array) {
        for (int i = 0; i < array.length; i++) {
            for(int j = 1; j < array.length; j++) {
                String first = array[j-1].toLowerCase();
                String second = array[j].toLowerCase();
                boolean exitFlag = false;
                for (int index = 0; ((index < first.length()) && (index < second.length())) && !exitFlag; index++) {
                    if (second.charAt(index) < first.charAt(index)) {
                        String temp = array[j-1];
                        array[j-1] = array[j];
                        array[j] = temp;
                        exitFlag = true;
                    } else if(second.charAt(index) != first.charAt(index)) {
                        exitFlag = true;
                    }
                }
            }
        }
    }

    /**
     * The main method shows a use case for bubbleSort
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {4,3,4,3,-2,-34,5,4,3,4,6,4,3,4,6,7,3,7,5,3};
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

        String[] array = {"abc1", "abc0", "abc12", "abc3"};
        bubbleSortAlpha(array);
        System.out.println("" + array[0] + " " + array[1] + " " + array[2] + " " + array[3]);
    }

}
