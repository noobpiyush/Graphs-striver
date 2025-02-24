import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];

        for (int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                //take boundary ele in consideration

                if (i == 0 || j == 0 || i == n-1 || j == m -1){

                    if (grid[i][j] == 1){
                        q.add(new Pair(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }

        int delRow[] = {-1,0,1,0};
        int delCol[] = {0,1,0,-1};

        while (!q.isEmpty()){

            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i =0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m &&
                    vis[nRow][nCol] != 1 && grid[nRow][nCol] == 1
                ){
                    q.add(new Pair(nRow,nCol));
                    vis[nRow][nCol] =1;
                }
            }
        }

        int cnt = 0;

        for (int i =0;i<n;i++){
            for (int j =0;j<m;j++){
                if (grid[i][j] == 1  && vis[i][j] == 0){
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
