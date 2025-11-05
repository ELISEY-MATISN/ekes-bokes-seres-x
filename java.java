#import java.util.*;

class Graph {
    private int vertices;
    private List<List<Integer>> adj_list;
    private boolean[] visited;
    private int[] entry_time;
    private int[] exit_time;
    private int timer;

    public Graph(int v) {
        vertices = v;
        adj_list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj_list.add(new ArrayList<>());
        }
        visited = new boolean[v];
        entry_time = new int[v];
        exit_time = new int[v];
        timer = 1;
    }

    public void addEdge(int u, int v) {
        adj_list.get(u).add(v);
        adj_list.get(v).add(u);
    }

    public void dfs(int node) {
        visited[node] = true;
        entry_time[node] = timer++;
        
        for (int neighbor : adj_list.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        
        exit_time[node] = timer++;
    }

    public void printTimes() {
        for (int i = 0; i < vertices; i++) {
            System.out.println("Вершина " + i + ": вход = " + entry_time[i] + 
                             ", выход = " + exit_time[i]);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        
        g.dfs(0);
        g.printTimes();
    }
}