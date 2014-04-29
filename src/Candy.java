import java.lang.reflect.Array;
import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] ret = new int[length];
        Arrays.fill(ret, 1);

        // scan from left to right
        for (int i = 0; i < length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                ret[i + 1] = ret[i] + 1;
            }
        }

        // scan from right to left
        int total = ret[length - 1];
        for (int i = length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i-1]) {
                ret[i -1] = Math.max(ret[i - 1], ret[i] + 1);
            }
            total += ret[i-1];
        }

        return total;
    }

    public static void main(String[] args) {
        int[] ratings = new int[] {2, 2};
        System.out.println(candy(ratings));
    }

}

