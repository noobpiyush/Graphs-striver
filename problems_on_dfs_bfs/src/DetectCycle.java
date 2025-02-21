import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectCycle {

    private boolean detectBFS(int src,ArrayList<ArrayList<Integer>> adj, int vis[]){
        //mark the vis[src]
        vis[src] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));

        while (!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();

            for (int adjNode : adj.get(node)){

                if (vis[adjNode] == 0){
                    vis[adjNode] = 1;
                    q.add(new Pair(adjNode,node));
                }
                else if (parent != adjNode){
                    return true;
                }
            }
        }

        return false;
     }

     private boolean detectDFS(int node,int parent,ArrayList<ArrayList<Integer>> adj, int vis[]){
        //mark the vis[src]
        vis[node] = 1;

        for (int it:adj.get(node)){
            if (vis[it] == 0){
                if (detectDFS(it,node,adj,vis)) return true;
            }
            else if (it != parent) return true;
        }

        return false;
     }

    public boolean isCycleBFS(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        int vis[] = new int[n];

        for (int i =0;i<n;i++){
            if (vis[i] == 0){
                if (detectBFS(i,adj,vis)) return true;
            }
        }

        return false;
    }

    public boolean isCycleDFS(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int n = adj.size();
        int vis[] = new int[n];

        for (int i =0;i<n;i++){
            if (vis[i] == 0){
                if (detectDFS(i,-1,adj,vis)) return true;
            }
        }

        return false;
    }
}
