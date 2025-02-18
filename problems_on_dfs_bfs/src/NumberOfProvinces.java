import java.util.ArrayList;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {

        //first converting adj matrix to an adj list

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>();

        for (int i = 0;i<isConnected.length;i++){
            adjLs.add(new ArrayList<>());
        }

        for (int i =0;i<isConnected.length;i++){
            for (int j =0;j<isConnected[0].length;j++){
                if (isConnected[i][j] == 1 && i != j){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        int vis[] = new int[isConnected.length];
        int cnt = 0;

        for (int i =0;i<isConnected.length;i++){
            if (vis[i] == 0){
                cnt++;
                dfs(i,adjLs,vis);
            }
        }
        return cnt;

        //tc o(n) + (v + 2e)
    }

    public static void dfs(int node, ArrayList<ArrayList<Integer>> adjLs, int vis[] ){
        vis[node] = 1;

        for (int it : adjLs.get(node)){
            if (vis[it] == 0){
                dfs(it,adjLs,vis);
            }
        }
    }
}
