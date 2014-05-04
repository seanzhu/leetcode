import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        if (S == null)
            return ret;

        Arrays.sort(S);

        ret.add(new ArrayList<Integer>());
        for (int i = 0; i < S.length; i++) {
            int size = ret.size();
            for (int j = 0; j < size; j++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(ret.get(j));
                temp.add(S[i]);
                ret.add(temp);
            }
        }

        return ret;
    }

}
