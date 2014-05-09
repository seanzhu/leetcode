public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] table = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++)
            table[i][0] = i;
        for (int i = 0; i <= len2; i++)
            table[0][i] = i;

        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);
                if (c1 == c2)
                    table[i + 1][j + 1] = table[i][j];
                else {
                    int insert = table[i][j + 1] + 1;
                    int delete = table[i + 1][j] + 1;
                    int replace = table[i][j] + 1;

                    int min = Math.min(insert, delete);
                    min = Math.min(min, replace);
                    table[i + 1][j + 1] = min;
                }
            }
        }
        return table[len1][len2];
    }
}
