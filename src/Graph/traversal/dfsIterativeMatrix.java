package Graph.traversal;

import java.util.Stack;

public class dfsIterativeMatrix {

    public static void main(String[] args){

        int[][] adj = new int[5][5];
        dfs(adj, 0);
    }

    private static void dfs(int[][] adj, int start) {

        int v=adj.length;
        boolean[] visited = new boolean[v];

        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        visited[start]=true;

        while(!stack.isEmpty()) {
            int node = stack.pop();
            System.out.print(node + " ");

            for (int i = 0; i < adj[node].length; i++) {
                if (adj[node][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}
