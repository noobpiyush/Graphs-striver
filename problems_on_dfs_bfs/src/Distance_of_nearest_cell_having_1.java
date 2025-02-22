import java.util.LinkedList;
import java.util.Queue;



public class Distance_of_nearest_cell_having_1 {

    public int[][] nearest(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int dist[][] = new int[n][m];
        Queue<Pair1> q = new LinkedList<>();

        // Initialize queue with all '1' cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = 1;
                    q.add(new Pair1(i, j, 0));
                } else {
                    vis[i][j] = 0;
                }
            }
        }

        // Direction arrays for moving up, right, down, left
        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        // BFS Traversal
        while (!q.isEmpty()) {
            Pair1 curr = q.poll();
            int row = curr.first;
            int col = curr.second;
            int steps = curr.time;

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0) {
                    vis[nRow][nCol] = 1;  // Mark as visited
                    q.offer(new Pair1(nRow, nCol, steps + 1));
                }
            }
        }

        return dist;
    }
}
