package leetecode.tree;

public class PopulateNextRightPointer {
    public Node connect(Node root) {
        if(root == null)
            return root;
        if(root.left != null && root.right != null)
            root.left.next = root.right;
        if(root.next != null){
            Node n1 = root.right != null ? root.right : root.left;
            Node n2 = root.next;
            while(n2 != null){
                if(n2.left != null || n2.right != null)
                    break;
                n2 = n2.next;
            }
            if(n1!= null && n2!= null)
                n1.next = n2.left != null ? n2.left:n2.right;
        }
        connect(root.left);
        connect(root.right);
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}