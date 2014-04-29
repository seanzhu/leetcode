import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public static int longestConsecutive(int[] num) {
        Set<Integer> hashSet = new HashSet<Integer>();
        int max = 1;

        for (int i : num)
            hashSet.add(i);

        int left, right;
        for (int cur : num) {
            int count = 1;

            left = cur - 1;
            right = cur + 1;

            while (hashSet.contains(left)) {
                ++count;
                hashSet.remove(left);
                --left;
            }

            while (hashSet.contains(right)) {
                ++count;
                hashSet.remove(right);
                ++right;
            }

            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] test = new int[] {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(test));
    }
}
