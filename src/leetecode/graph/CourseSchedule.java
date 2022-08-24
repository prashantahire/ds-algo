package leetecode.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/course-schedule/

//REF: https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        for(int i=0; i<prerequisites.length; i++){
            g.addEdge(prerequisites[i][0], prerequisites[i][1]);
        }

        boolean visited[] = new boolean[numCourses];
        boolean recStack[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++){
            if(isCycleDfs(i, g, visited, recStack))
                return false;
        }
        return true;
    }

    private boolean isCycleDfs(int u, Graph g, boolean visited[], boolean recStack[]){
        if(recStack[u])
            return true;
        if(visited[u])
            return false;
        visited[u] = true;
        recStack[u] = true;
        for(int v: g.graph[u]){
            if(isCycleDfs(v, g, visited, recStack))
                return true;
        }
        recStack[u] = false;
        return false;
    }
}

class Graph{

    List<Integer>[] graph;
    Queue q;

    Graph(int v){
        graph = new ArrayList[v];

        for(int i=0; i<v; i++){
            graph[i] = new ArrayList<Integer>();
        }
    }
    void addEdge(int u, int v){
        graph[u].add(v);
    }
}

