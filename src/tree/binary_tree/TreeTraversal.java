package tree.binary_tree;

public class TreeTraversal {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int value) {
            this.data = value;
            this.left = this.right = null;
        }
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        preorderTraversal(root.left);
        System.out.print(root.data + " ");
        preorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        preorderTraversal(root.left);
        preorderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        preorderTraversal(root);
        System.out.println();
        inorderTraversal(root);
        System.out.println();
        postorderTraversal(root);
    }
}
