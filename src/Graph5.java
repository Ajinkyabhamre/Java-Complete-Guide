import java.util.*;
public class Graph5 {
    static class Edge{
        int src;
        int dest;


        public Edge(int s, int d){
            this.src = s;
            this.dest = d;

        }
    }
    static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
 

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
      
    }

    public static boolean isBipartite(ArrayList<Edge> graph[]){ //O(V+E)
        int[] colour = new int[graph.length];
        for (int i = 0; i < colour.length; i++) {
            colour[i] = -1; //no color
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == -1) {//BFS
                q.add(i);
                colour[i] = 0; // 0-> yellow
                while (!q.isEmpty()) {
                    int curr = q.remove();
                    for (int j = 0; j < graph[curr].size(); j++) {
                        Edge e = graph[curr].get(j); //e.dest
                        if (colour[e.dest] == -1) {
                            int nextColour = colour[curr] == 0 ? 1 : 0 ;
                            colour[e.dest] = nextColour;
                            q.add(e.dest);
                        }else if(colour[e.dest] == colour[curr]){
                            return false ; //NOT bipartite
                        }
                    }
                }
            }
        }
        return true ;

    }
    public static void main(String[] args) {
/*  
          0
         / \
        /   \
       1     2
       |     |
       |     |
       3-----4
       False

*/        
//if graph doesnt have cycle, it is bipartite
int V = 5;
ArrayList<Edge> graph[] = new ArrayList[V];
createGraph(graph);
System.out.println(isBipartite(graph));



    }
}
