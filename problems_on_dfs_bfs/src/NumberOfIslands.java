import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;

    public Pair(int first, int seccond){

        this.first = first;
        this.second = seccond;
    }
}
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int cnt = 0;

        for (int row = 0;row<n;row++){
            for (int col = 0;col<m;col++){

                if (vis[row][col] == 0 && grid[row][col] == '1'){
                    cnt++;
                    bfs(row,col,vis,grid);
                }
            }
        }

        return cnt;
    }

    public void bfs(int row, int col, int vis[][], char [][] grid){
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = 1;
        q.add(new Pair(row,col));

        int n = grid.length;
        int m = grid[0].length;

        while (!q.isEmpty()){
            int r = q.peek().first;
            int c = q.peek().second;

            q.remove();

            // traverse in the neighbours and mark them if its a land

            for (int delRow = -1;delRow<=1;delRow++){
                for(int delCol = -1; delCol <= 1; delCol++) {

                    int nRow = r + delRow;
                    int nCol = c + delCol;

                    // check if neighbour row and column is valid, and is an unvisited land

                    if (nRow >= 0 && nRow < n && nCol >=  0 && nCol < m
                        && grid[nRow][nCol] == '1' &&  vis[nRow][nCol] == 0) {

                        vis[nRow][nCol] = 1;
                        q.add(new Pair(nRow,nCol));
                    }

                }
            }

        }
    }
}
