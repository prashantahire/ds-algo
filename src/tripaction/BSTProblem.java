package tripaction;

import java.io.*;
import java.util.*;

/*
 * Given a node in a binary search tree, find its successor in in-order-traversal.
 * Note that each node contains a link to its parent.
 * Also assume that the input node is always present in the tree
 */

/**
 15
 12    18
 11   14     20

 successor(11) -> 12
 successor(14) -> 15
 successor(18) -> 20
 successor(20) -> null
 **/

class BSTProblem {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int val){
            this.val = val;
        }

    }

    public static void main(String[] args) {

        Node eleven = new Node(11);
        Node fourteen = new Node(14);
        Node twelve = new Node(12);
        Node fifteen = new Node(15);
        Node eighteen = new Node(18);
        Node twenty = new Node(20);

        twelve.left = eleven;
        twelve.right = fourteen;
        eighteen.right = twenty;
        fifteen.left = twelve;
        fifteen.right = eighteen;

        eleven.parent = twelve;
        fourteen.parent = twelve;
        twelve.parent = fifteen;
        twenty.parent = eighteen;
        eighteen.parent = fifteen;


        assert successor(eleven).val == 12;
        assert successor(twelve).val == 14;
        assert successor(fourteen).val == 15;
        assert successor(eighteen).val == 20;
        assert successor(twenty) == null;

        System.out.println("Completed!");
    }

    // TODO Return inorder successor of node
    public static Node successor(Node n) {

        // Node root = findRoot(n);
        // List<Node> inOrderList = new ArrayList<>();
        // inOrderTraversal(root, inOrderList);
        // int indexOfN = -1;
        // for(int i=0; i<inOrderList.size(); i++){
        //   if(inOrderList.get(i).val == n.val){
        //     indexOfN = i;
        //     break;
        //   }
        // }
        // if(indexOfN == -1 || indexOfN >= inOrderList.size()-1)
        //   return null;
        // else{
        // return inOrderList.get(indexOfN+1);
        return successorRec(n);
    }

    private static void inOrderTraversal(Node root, List<Node> inOrderList){
        if(root == null)
            return;
        inOrderTraversal(root.left, inOrderList);
        inOrderList.add(root);
        inOrderTraversal(root.right, inOrderList);
    }
    private static Node findRoot(Node n){
        Node temp = n;
        while(temp.parent != null){
            temp = temp.parent;
        }
        return temp;
    }


    public static Node successorRec(Node n){
        if(n.right != null){
            return n.right;
        }
        if(n.parent.left == n){
            return n.parent;
        }else{
            Node temp = n;
            while(temp != null){
                temp = temp.parent;
                if(temp.val > n.val){
                    return temp;
                }
            }
            return temp;
        }
    }
}
