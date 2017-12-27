/**
 * Created by gabriel on 7/21/17.
 */
public class LinearSearch extends Search {

    public int[] search(int[] list, int target) { //override method from super class
        int[] res = new int[list.length];
        res[0] = -1;
        int index = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target)
                res[index] = i;
                index++;
        }
        return res;
    }
}

