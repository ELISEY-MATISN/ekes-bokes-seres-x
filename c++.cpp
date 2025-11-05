#include <iostream>
#include <vector>
using namespace std;

class Graph {
    int vertices;
    vector<vector<int>> adj_list;
    vector<bool> visited;
    vector<int> entry_time;
    vector<int> exit_time;
    int timer;

public:
    Graph(int v) : vertices(v), adj_list(v), visited(v, false), 
                   entry_time(v, 0), exit_time(v, 0), timer(1) {}

    void addEdge(int u, int v) {
        adj_list[u].push_back(v);
        adj_list[v].push_back(u);
    }

    void dfs(int node) {
        visited[node] = true;
        entry_time[node] = timer++;
        
        for (int neighbor : adj_list[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
        
        exit_time[node] = timer++;
    }

    void printTimes() {
        for (int i = 0; i < vertices; i++) {
            cout << "Вершина " << i << ": вход = " << entry_time[i] 
                 << ", выход = " << exit_time[i] << endl;
        }
    }
};

int main() {
    Graph g(5);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 3);
    g.addEdge(2, 4);
    
    g.dfs(0);
    g.printTimes();
    
    return 0;
}