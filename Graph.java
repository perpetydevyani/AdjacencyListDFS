import java.util.*;

class Graph {
    private int vertices;
    private LinkedList<Integer>[] adjList;

    // Constructor to initialize graph
    public Graph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++)
            adjList[i] = new LinkedList<>();
    }

    // Add an edge from source to destination
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }

    // DFS traversal
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.print("DFS Traversal: ");
        DFSUtil(start, visited);
        System.out.println();
    }

    private void DFSUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adjList[node]) {
            if (!visited[neighbor])
                DFSUtil(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5); // Create graph with 5 vertices (0 to 4)

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);

        g.DFS(0); // Start DFS from vertex 0
    }
}
