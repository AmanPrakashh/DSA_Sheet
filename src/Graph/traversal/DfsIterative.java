package Graph.traversal;

import java.util.List;
import java.util.Stack;

public class DfsIterative {

    void dfsIteative(List<List<Integer>> adj, int start){

        int v = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean [] visited = new boolean[v];
        visited[start]=  true;
        stack.push(start);

        while(!stack.isEmpty()){
            int node = stack.pop();
            System.out.print(node +" ");
            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    stack.push(neigh);
                    visited[neigh]=true;
                }
            }
        }
    }
}
