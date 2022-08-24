package leetecode.tree.perfectbt;

public class PopulateNextRighPointers {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Node left = connect(root.left);
        Node right = connect(root.right);
        if(left != null && right != null){
            left.next = right;
            Node rightMost = left.right;
            Node leftMost = right.left;
            while (rightMost != null && leftMost != null){
                rightMost.next = leftMost;
                rightMost = rightMost.right;
                leftMost = leftMost.left;
            }
        }
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