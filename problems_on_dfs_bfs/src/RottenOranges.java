import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0){
            return -1;
        }

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair1> q = new LinkedList<>();
        int vis[][] = new int[n][m];
        int countFresh = 0;

        //add all the initial rotten oranges in the queue

        for (int i =0;i<n;i++){
            for (int j = 0;j<m;j++){
                if (grid[i][j] == 2){
                    q.add(new Pair1(i,j,0));
                    vis[i][j] = 2;
                }
                else {
                    vis[i][j] = 0;
                }

                if (grid[i][j] == 1) countFresh++;
            }
        }
        int tm = 0;
        int dRow[] = {-1,0,1,0}; //4 direction start from up....
        int dCol[] = {0,1,0,-1};
        int cnt = 0;

        //bfs
        while (!q.isEmpty()){
            //pop out the elements
            int r = q.peek().first;
            int c = q.peek().second;
            int t = q.peek().time;

            //mark the max time
            tm = Math.max(t,tm);

            //remove from the q and travel to its 4 direct neighbour
            q.remove();
            for (int i = 0;i<4;i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                //check if valid
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m
                    && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1)
                {
                    q.add(new Pair1(nRow,nCol,t+1));
                    //mark vis
                    vis[nRow][nCol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != countFresh) return -1;

        return tm;
    }
}

class Pair1{
    int first;
    int second;
    int time;

    public Pair1(int first, int second, int time){
        this.first = first;
        this.second = second;
        this.time = time;
    }
}
