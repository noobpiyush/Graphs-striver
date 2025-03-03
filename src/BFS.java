import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> bfs = new ArrayList<>();

        boolean vis[] = new boolean[V];

        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);


            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for(Integer it: adj.get(node)){
                if (!vis[it]){
                    vis[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
}
