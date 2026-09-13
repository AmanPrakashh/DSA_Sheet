package Graph.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BfsRecursiveMatrix {

    void bfs(int[][] adj, int start){
        int v = adj.length;
        boolean[] visited = new boolean[v];
        visited[start]= true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        bfsRecursive(adj, visited, queue);
    }

    private void bfsRecursive(int[][] adj, boolean[] visited, Queue<Integer> queue) {
        if(queue.isEmpty()) return;
        int node = queue.poll();
        for (int i = 0; i < adj[node].length; i++) {
            if (!visited[i] && adj[node][i] == 1) {
                visited[i] = true;
                queue.offer(i);
            }
        }
        bfsRecursive(adj, visited, queue);
    }

}
