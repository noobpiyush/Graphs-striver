import java.util.ArrayList;
import java.util.List;

public class Rep {

    //representation of graph in java
    //if nodes lowest number is 1 then 1 based indexing if 0 then 0 based indexing

    //we will go for 0 based for now

    public static void addEdge(int mat[][], int i, int j){
        mat[i][j] = 1;
        mat[j][i] = 1;
    }

    public static void displayMatrix(int mat[][]){

        for(int row[]:mat){
            for (int val:row){
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void addEdgeList(List<List<Integer>> list,int i, int j){
        list.get(i).add(j);
        list.get(j).add(i);
    }

    public static void displayAdjList(List<List<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": "); // Print the vertex
            for (int j : adj.get(i)) {
                System.out.print(j + " "); // Print its adjacent
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Create a graph with 4 vertices and no edges
        // Note that all values are initialized as 0
        int V = 4;
        int[][] mat = new int[V][V];

        // Now add edges one by one
        addEdge(mat, 0, 1);
        addEdge(mat, 0, 2);
        addEdge(mat, 1, 2);
        addEdge(mat, 2, 3);

        System.out.println("Adjacency Matrix Representation");
        displayMatrix(mat);

        List<List<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Now add edges one by one
        addEdgeList(adj, 0, 1);
        addEdgeList(adj, 0, 2);
        addEdgeList(adj, 1, 2);
        addEdgeList(adj, 2, 3);

        System.out.println("Adjacency List Representation:");
        displayAdjList(adj);


    }

}
