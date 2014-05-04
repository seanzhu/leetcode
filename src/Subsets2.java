import java.util.ArrayList;
import java.util.Arrays;

public class Subsets2 {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(final int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (num == null)
            return ret;
        Arrays.sort(num);
        ret.add(new ArrayList<Integer>());

        int start = 0;
        for (int i = 0; i < num.length; i++) {
            int size = ret.size();
            for (int j = start; j < size; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(ret.get(j));
                temp.add(num[i]);
                ret.add(temp);
            }
            if (i < num.length - 1 && num[i] == num[i + 1])
                start = size;
            else
                start = 0;
        }
        return ret;
    }
}
