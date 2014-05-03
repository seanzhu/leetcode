import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    private class Cell {
        int x;
        int y;

        Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void solve(char[][] board) {
        if (board == null || board.length == 0)
            return;

        int m = board.length;
        int n = board[0].length;
        Queue<Cell> queue = new LinkedList<Cell>();

        // the outer layer
        for (int row = 0; row < m; row++) {
            if (board[row][0] == 'O')
                queue.add(new Cell(row, 0));
            if (board[row][n - 1] == 'O')
                queue.add(new Cell(row, n - 1));
        }

        for (int col = 1; col < n - 1; col++) {
            if (board[0][col] == 'O')
                queue.add(new Cell(0, col));
            if (board[m - 1][col] == 'O')
                queue.add(new Cell(m - 1, col));
        }
        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            // mark current cell
            board[curr.x][curr.y] = 'T';

            // find adjacent cells
            if (curr.x + 1 < m && board[curr.x + 1][curr.y] == 'O')
                queue.add(new Cell(curr.x + 1, curr.y));
            if (curr.x - 1 >= 0 && board[curr.x - 1][curr.y] == 'O')
                queue.add(new Cell(curr.x - 1, curr.y));
            if (curr.y + 1 < n && board[curr.x][curr.y + 1] == 'O')
                queue.add(new Cell(curr.x, curr.y + 1));
            if (curr.y - 1 >= 0 && board[curr.x][curr.y - 1] == 'O')
                queue.add(new Cell(curr.x, curr.y - 1));
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
                else if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }
}
