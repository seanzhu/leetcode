public class PalindromePartitioning2 {

    public int minCut(String s) {
        int n = s.length();
        int[] ret = new int[n];
        boolean[][] isPalindrome = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--)
            for (int j = i; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j)) &&
                        (j - i < 2 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                } else
                    isPalindrome[i][j] = false;
            }

        for (int i = 0; i < n; i++) {
            int temp = n - 1;
            if (isPalindrome[0][i])
                ret[i] = 0;
            else {
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i] && temp > ret[j] + 1)
                        temp = ret[j] + 1;
                }
                ret[i] = temp;
            }
        }
        return ret[n - 1];
    }
}
