public class MinPathNum {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0)
            return 0;

        int m = grid.length, n = grid[0].length;

        int[] table = new int[n + 1];
        for (int i = 0; i < n + 1; i++) table[i] = Integer.MAX_VALUE;
        table[1] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                table[j + 1] = Math.min(table[j + 1], table[j]) + grid[i][j];
            }
        }
        return table[n];
    }

    public static void main(String[] args) {
        MinPathNum test = new MinPathNum();

        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

        System.out.println(test.minPathSum(grid));
    }
}
