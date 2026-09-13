package Graph.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class bfsIterativeMatrix {
    public static void main(String[] args) {

        int[][] adj = new int[5][5];
        bfs(adj, 0);
    }

    private static void bfs(int[][] adj, int start) {
        int v = adj.length;
        boolean[] visited = new boolean[v];
        visited[start]= true;
        Queue<Integer> queue = new LinkedList();
        queue.offer(start);

        while(!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < adj[node].length; i++) {
                if (adj[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}
