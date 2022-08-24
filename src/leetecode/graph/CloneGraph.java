package leetecode.graph;

import java.util.*;

public class CloneGraph {

    public static void main(String ...args){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        new CloneGraph().cloneGraph(n1);
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Map<Integer, Node> visited = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        Node copygr = new Node(node.val);
        que.offer(node);
        visited.put(node.val, copygr);
        while(!que.isEmpty()){
            Node tmp = que.poll();
            Node cpgr = visited.get(tmp.val);
            for(Node adj : tmp.neighbors){
                if(!visited.containsKey(adj.val)){
                    Node cpAdj = new Node(adj.val);
                    que.offer(adj);
                    visited.put(adj.val, cpAdj);
                }
                cpgr.neighbors.add(visited.get(adj.val));
            }
        }
        return copygr;
    }
}
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

