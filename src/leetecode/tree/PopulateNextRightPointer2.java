package leetecode.tree;

public class PopulateNextRightPointer2 {
    public Node connect(Node root) {
        if(root == null)
            return root;
        if(root.left != null) {
            root.left.next = root.right != null ? root.right : getNext(root.next);
        }
        if(root.right != null) {
            root.right.next = getNext(root.next);
        }
        connect(root.right);
        connect(root.left);
        return root;
    }

    private Node getNext(Node root){
        while(root != null) {
            if(root.left != null)
                return root.left;
            if(root.right != null)
                return root.right;
            root = root.next;
        }
        return null;
    }

}
