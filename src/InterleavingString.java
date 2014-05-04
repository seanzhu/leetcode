public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length();
        int n = s2.length();
        int t = s3.length();

        if (m + n != t)
            return false;

        boolean[][] table = new boolean[m + 1][n + 1];

        table[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1))
                table[0][i] = table[0][i] || table[0][i - 1];
        }

        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1))
                table[i][0] = table[i][0] || table[i - 1][0];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    table[i][j] = table[i - 1][j];
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1))
                    table[i][j] = table[i][j - 1] || table[i][j];
            }
        }

        return table[m][n];
    }
}
