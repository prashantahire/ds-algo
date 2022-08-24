package leetecode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule2 {

    public static void main(String ...args){
        int a[][] = {{1, 0}};
        int b[][] = {{1,0},{2,0},{3,1},{3,2}};
        CourseSchedule2 cs = new CourseSchedule2();
        //cs.findOrder(2, a);
        cs.findOrder(4, b);
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph1 g = new Graph1(numCourses);
        for(int i = 0; i<prerequisites.length; i++){
            g.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }
        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];
        Stack<Integer> stack = new Stack<>();

        for(int u=0; u<numCourses; u++){
            if(dfsTopo(g, u, visited, recStack, stack))
                return new int[]{};
        }
        int ans[] = new int[stack.size()];
        int i=stack.size()-1;
        while (!stack.isEmpty()){
            ans[i] = stack.pop();
            i--;
        }
        return ans;
    }

    private boolean dfsTopo(Graph1 g, int u, boolean[] visited, boolean[] recStack, Stack stack){
        if(recStack[u])
            return true;
        if(visited[u])
            return false;
        visited[u] = true;
        recStack[u] = true;
        for(int v: g.adjEdges[u]){
            if(dfsTopo(g, v, visited, recStack, stack)){
                return true;
            }
        }
        stack.push(u);
        recStack[u] = false;
        return false;
    }
}

class Graph1 {

    List<Integer>[] adjEdges;

    Graph1(int v){
        adjEdges = new ArrayList[v];
        for(int i=0; i<v; i++){
            adjEdges[i] = new ArrayList<>();
        }
    }
    public void addEdge(int u, int v){
        adjEdges[u].add(v);
    }
}
