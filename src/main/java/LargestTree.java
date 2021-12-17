import java.util.*;
class LargestTree{
    static void addEdge(LinkedList<Integer> adj[], int u, int v)
    {
        //TO-DO:
        //adding edges in an undirected graph
        adj[u].add(v);
        adj[v].add(u);
    }

    static int DFS(int u, LinkedList<Integer> adj[], Vector<Boolean> visited)
    {
        visited.add(u, true);
        int size = 1;

        // Iterate through all the nodes and perform DFS if the node is not yet visited
        //TO-DO:
        for (int j = 0; j < adj[u].size(); j++)
            if (visited.get(adj[u].get(j)) == false) {
                //performing DFS if the node is still not yet visited
                size += DFS(adj[u].get(j), adj, visited);
            }
        return size;
    }

    public int largestTree(LinkedList<Integer> adj[], int V)
    {
        //TO-DO:
        Vector<Boolean> visited = new Vector<>();
        for(int i = 0; i < V; i++)
        {
            visited.add(false);
        }
        int result = 0;

        // iterate through all the vertices
        for (int u = 0; u < V; u++)
        {
            if (visited.get(u) == false)
            {
                // finding the size of the largest tree in the forest provided as the adjacency list
                result = Math.max(result, DFS(u, adj, visited));
            }
        }
        return result;
    }
}