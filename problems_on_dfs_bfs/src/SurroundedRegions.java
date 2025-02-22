public class SurroundedRegions {

    static char[][] fill(char mat[][]) {
        int n = mat.length;
        int m = mat[0].length;

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};
        int vis[][] = new int[n][m];

        // Traverse first and last row
        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delRow, delCol);
            }
            if (vis[n - 1][j] == 0 && mat[n - 1][j] == 'O') {
                dfs(n - 1, j, vis, mat, delRow, delCol);
            }
        }

        // Traverse first and last column
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delRow, delCol);
            }
            if (vis[i][m - 1] == 0 && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, vis, mat, delRow, delCol);
            }
        }

        // Convert unvisited 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                }
            }
        }

        return mat;
    }

    public static void dfs(int row, int col, int vis[][], char mat[][], int delRow[], int delCol[]) {
        int n = mat.length;
        int m = mat[0].length;

        // Mark node as visited
        vis[row][col] = 1;

        // Explore 4 directions
        for (int i = 0; i < 4; i++) {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && mat[nRow][nCol] == 'O') {
                dfs(nRow, nCol, vis, mat, delRow, delCol);
            }
        }
    }
}
