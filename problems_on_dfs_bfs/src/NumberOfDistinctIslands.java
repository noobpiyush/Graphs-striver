import java.util.ArrayList;
import java.util.HashSet;

public class NumberOfDistinctIslands {

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private void dfs(int row, int col, int vis[][], int grid[][], ArrayList<String> vec,
                     int row0, int col0){
        vis[row][col] = 1;
        vec.add(toString(row - row0,col - col0));
        int n = grid.length;
        int m = grid[0].length;

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,-1,0,1};

        for (int i =0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1
            ){
                dfs(nRow,nCol,vis,grid,vec,row0,col0);
            }
        }
    }


    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i,j,vis,grid,list,i,j);
                    set.add(list);
                }
            }
        }

        return set.size();
    }
}
