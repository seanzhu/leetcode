import java.util.ArrayList;
import java.util.Arrays;

public class PascalTriangle2 {
    public ArrayList<Integer> getRow(int rowIndex) {
        int[] ret = new int[rowIndex + 1];
        ret[0] = 1;
        if (rowIndex == 0)
            return getList(ret);
        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                ret[j] = ret[j] + ret[j - 1];
            }
            ret[i + 1] = 1;
        }

        return getList(ret);
    }

    public ArrayList<Integer> getList(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
        }
        return res;
    }
}
