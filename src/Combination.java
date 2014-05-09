import com.sun.org.apache.bcel.internal.generic.AALOAD;

import java.util.ArrayList;

public class Combination {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();

        getCombHelper(n, 1, k, temp, ret);
        return ret;
    }

    private void getCombHelper(int n,
                               int level,
                               int k,
                               ArrayList<Integer> temp,
                               ArrayList<ArrayList<Integer>> ret) {
        if (temp.size() == k) {
            ArrayList<Integer> insert = new ArrayList<Integer>(temp);
            ret.add(insert);
            return;
        }

        for (int i = level; i <= n; i++) {
            temp.add(i);
            getCombHelper(n, i + 1, k, temp, ret);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combination test = new Combination();
        System.out.println(test.combine(1, 1));
    }
}
