import java.util.ArrayList;

public class Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null)
            return 0;
        int size = triangle.size();
        if (size == 0)
            return 0;

        int[] ret = new int[size];

        // initialization
        for (int i = 0; i < size; i++)
            ret[i] = triangle.get(size - 1).get(i);

        // DP
        for (int row = size - 2; row >= 0; row--) {
            for (int i = 0; i <= row; i++) {
                ret[i] = Math.min(ret[i], ret[i+1]) + triangle.get(row).get(i);
            }
        }

        return ret[0];

    }
}
