import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            if (i > 0) {
                for (int j = 0; j < ret.get(i - 1).size() - 1; j++) {
                    temp.add(ret.get(i - 1).get(j) + ret.get(i - 1).get(j + 1));
                }
                temp.add(1);
            }
            ret.add(temp);
        }
        return ret;
    }

}
