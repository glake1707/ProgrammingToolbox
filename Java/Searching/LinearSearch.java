/**
 * Created by gabriel on 7/21/17.
 */
public class LinearSearch extends Search {

    public int[] search(int[] list, int target) { //override method from super class
        if (list.length < 1) {
            int[] result = {-1};
            return result;
        }
        int[] temp = new int[list.length];
        temp[0] = -1;
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                temp[index++] = i;
            }
        }
        int[] result = {-1};
        if (index == 0) {
            return result;
        } else {
            result = new int[index];
        }
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    public static void printArray(int[] arr) {
        System.out.print("{ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
        }
        System.out.print("}\n");
    }

    /* example main
    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 5, 5, 6};
        int[] list2 = {1, 2, 3, 4, 5, 6};
        LinearSearch lin = new LinearSearch();
        printArray(lin.search(list, 5));
        printArray(lin.search(list2, 5));
        printArray(lin.search(list, -1));
    }
    */
}

