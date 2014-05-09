public class ClimbStairs {
    public int climbStairs(int n) {
        int[] table = new int[n + 1];
        table[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i >= 1)
                table[i] += table[i - 1];
            if (i >= 2)
                table[i] += table[i - 2];
        }

        return table[n];
    }
}
