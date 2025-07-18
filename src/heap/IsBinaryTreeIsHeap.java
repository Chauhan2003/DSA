package heap;

public class IsBinaryTreeIsHeap {
    static class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }

    public static int countNodes(Node tree) {
        if (tree == null) return 0;
        return 1 + countNodes(tree.left) + countNodes(tree.right);
    }

    public static boolean isCompleteTree(Node tree, int index, int totalNodes) {
        if (tree == null) return true;
        if (index >= totalNodes) return false;
        return isCompleteTree(tree.left, 2 * index + 1, totalNodes) &&
                isCompleteTree(tree.right, 2 * index + 2, totalNodes);
    }

    public static boolean isHeapCondition(Node tree) {
        if (tree == null) return true;

        if (tree.right == null) {
            if (tree.left != null) {
                return (tree.data >= tree.left.data) && isHeapCondition(tree.left);
            }
            return true;
        }

        if (tree.left != null) {
            if (tree.data >= tree.left.data && tree.data >= tree.right.data) {
                return isHeapCondition(tree.left) && isHeapCondition(tree.right);
            } else {
                return false;
            }
        }

        return false;
    }

    public static boolean isHeap(Node tree) {
        int totalNodes = countNodes(tree);
        return isCompleteTree(tree, 0, totalNodes) && isHeapCondition(tree);
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);

        if(isHeap(root)) {
            System.out.println("Binary tree is a heap");
        } else {
            System.out.println("Binary tree is not a heap");
        }
    }
}
