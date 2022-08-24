package leetecode.tree;

public class NextRightTemp {
    public Node connect(Node root) {
        return connectRight(root, null);
    }

    private Node connectRight(Node root, Node parent) {
        if(root == null)
            return root;
        Node rootTemp = root;
        while(rootTemp != null) {
            rootTemp.next = parent.left != null ? parent.left : getNext(parent);
            rootTemp = rootTemp.next;
            if(parent != null)
                parent = parent.next;
        }
        connectRight(root.left, root);
        connectRight(root.right, root);
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

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.right = new Node(7);
        NextRightTemp n = new NextRightTemp();
        n.connect(node);
    }
}
