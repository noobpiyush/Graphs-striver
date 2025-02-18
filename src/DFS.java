import java.util.ArrayList;

public class DFS {

    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(0,vis,adj,ans);
        return ans;
    }

    public static void dfs(int node, boolean vis[],ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> ans){

        vis[node] = true;
        ans.add(node);

        for (Integer it: adj.get(node)){
            if (!vis[it]){
                dfs(it,vis,adj,ans);
            }
        }
    }
}
