import java.util.*;

public class connectedComponents {

    public ArrayList<ArrayList<Integer>> connectedcomponents(int v, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                Queue<Integer> q = new LinkedList<>();

                q.offer(i);
                vis[i] = true;

                while (!q.isEmpty()) {
                    Integer node = q.poll();
                    component.add(node);

                    for (int neighbour : adjList.get(node)) {
                        if (!vis[neighbour]) {
                            q.offer(neighbour);
                            vis[neighbour] = true;
                        }
                    }
                }

                // Sort each component
                Collections.sort(component);
                connectedComponents.add(component);
            }
        }

        // Sort all components based on the first element
        connectedComponents.sort(Comparator.comparingInt(a -> a.get(0)));

        return connectedComponents;

    }
}
