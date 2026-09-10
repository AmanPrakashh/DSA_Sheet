package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class RecursiveAndIterativeBfsDfs {


    void bfsIterative(int v, List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[v];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbour : graph.get(node)) {
                if (!visited[neighbour]) {
                    queue.offer(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    void dfsIterative(int v, List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[v];
        visited[start] = true;
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");

            for (int neighbour : graph.get(node)) {
                if (!visited[neighbour]) {
                    stack.push(neighbour);
                    visited[neighbour] = true;
                }
            }
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    void bfs(int v, List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        bfsRecursion(graph, visited, queue);
    }

    private void bfsRecursion(List<List<Integer>> graph, boolean[] visited, Queue<Integer> queue) {
        if (queue.isEmpty()) return;   // base case

        int node = queue.poll();
        System.out.print(node + " ");

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                visited[neighbour] = true;   // mark before enqueue
                queue.offer(neighbour);
            }
        }

        bfsRecursion(graph, visited, queue);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    private void dfs(int v, List<List<Integer>> graph, int start) {
        boolean[] visited = new boolean[v];
        dfsRecursion(graph, visited, start);
    }

    private void dfsRecursion(List<List<Integer>> graph, boolean[] visited, int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int neighbour : graph.get(start)) {
            if (!visited[neighbour]) {
                dfsRecursion(graph, visited, neighbour);
            }
        }
    }
}
