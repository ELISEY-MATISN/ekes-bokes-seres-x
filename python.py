class Graph:
    def __init__(self, vertices):
        self.vertices = vertices
        self.adj_list = [[] for _ in range(vertices)]
        self.visited = [False] * vertices
        self.entry_time = [0] * vertices
        self.exit_time = [0] * vertices
        self.timer = 1
    
    def add_edge(self, u, v):
        self.adj_list[u].append(v)
        self.adj_list[v].append(u)
    
    def dfs(self, node):
        self.visited[node] = True
        self.entry_time[node] = self.timer
        self.timer += 1
        
        for neighbor in self.adj_list[node]:
            if not self.visited[neighbor]:
                self.dfs(neighbor)
        
        self.exit_time[node] = self.timer
        self.timer += 1
    
    def print_times(self):
        for i in range(self.vertices):
            print(f"Вершина {i}: вход = {self.entry_time[i]}, выход = {self.exit_time[i]}")

# Пример использования
if __name__ == "__main__":
    g = Graph(5)
    g.add_edge(0, 1)
    g.add_edge(0, 2)
    g.add_edge(1, 3)
    g.add_edge(2, 4)
    
    g.dfs(0)
    g.print_times()