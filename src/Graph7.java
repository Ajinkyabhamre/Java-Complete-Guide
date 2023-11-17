import java.util.*; 
public class Graph7 {
static class Edge{
    int src ;
    int dest ;
    public Edge(int s, int d) {
        this.src = s;
        this.dest = d;
    }
}

static void createGraph(ArrayList<Edge> graph[]){
    for (int i = 0; i < graph.length; i++) {
        graph[i] = new ArrayList<>();
    }
    graph[2].add(new Edge(2,3));

     graph[3].add(new Edge(3,1));

     graph[4].add(new Edge(4,0));
     graph[4].add(new Edge(4,1));

     graph[5].add(new Edge(5,0));
     graph[5].add(new Edge(5,2));
     
}
//Topological Sorting - (Using DFS) TC = O(V+E) = O(V)
public static void topSort(ArrayList<Edge>[] graph){
    boolean[] vis = new boolean[graph.length];
    Stack<Integer> s = new Stack<>();
    for (int i = 0; i < graph.length; i++) {
        if (!vis[i]) {
            topSortUtil(vis, s, graph, i); //modified dfs
        }
    }
    while (!s.isEmpty()) {
        System.out.print(s.pop() + " ");
    }
}

public static void topSortUtil(boolean[] vis, Stack<Integer> s, ArrayList<Edge>[] graph, int curr){
    vis[curr] = true;
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        if (!vis[e.dest]) {
            topSortUtil(vis, s, graph, e.dest);
        }
    }
    s.push(curr);

}

//Topological Sort (Using BFS) Kahn's Algorithm

public static void calcInd(ArrayList<Edge> graph[], int indegree[]){
    for (int i = 0; i < graph.length; i++) {
        int v = i;
        for (int j = 0; j < graph[v].size(); j++) {
            Edge e = graph[v].get(j);
            indegree[e.dest]++;
        }
    }
}
public static void topSort2(ArrayList<Edge> graph[]){
int indegree[] = new int[graph.length];
calcInd(graph, indegree);
Queue<Integer> q = new LinkedList<>();
for (int i = 0; i < indegree.length; i++) {
    if (indegree[i] == 0) {
        q.add(i);
    }
}
//bfs
while (!q.isEmpty()) {
    int curr = q.remove();
    System.out.print(curr + " ");
    for (int i = 0; i < graph[curr].size(); i++) {
        Edge e = graph[curr].get(i);
        indegree[e.dest]--;
        if (indegree[e.dest] == 0) {
            q.add(e.dest);
        }
    }
}
System.out.println();
}

public static int[] findOrder(int numCourses, int[][] prerequisites) {
    int[] indeg = new int[numCourses];
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
    for (int i = 0; i < numCourses; i++) {
        adj.add(new ArrayList<>());
    }

    for (int i = 0; i < prerequisites.length; i++) {
        int firstInt = prerequisites[i][0];
        int secondInt = prerequisites[i][1];
        adj.get(secondInt).add(firstInt); // Build the adjacency list
        indeg[firstInt]++;
    }

    Queue<Integer> q = new LinkedList<>();
    ArrayList<Integer> res = new ArrayList<>();

    for (int i = 0; i < indeg.length; i++) {
        if (indeg[i] == 0) {
            q.add(i);
        }
    }

    while (!q.isEmpty()) {
        int curr = q.remove();
        res.add(curr);

        for (int neighbor : adj.get(curr)) {
            indeg[neighbor]--;
            if (indeg[neighbor] == 0) {
                q.add(neighbor);
            }
        }
    }

    if (res.size() == numCourses) {
        // Convert ArrayList to int[]
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = res.get(i);
        }
        return result;
    } else {
        return new int[0]; // No valid course order is possible
    }
}


    public static void main(String[] args) {
        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);
        //topSort(graph);
        //topSort2(graph);
        int[][] pre = {{1,0},{2,0}, {3,1}, {3,2}};
System.out.println(findOrder(4, pre));
     


    }
}
