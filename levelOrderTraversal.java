import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrderTraversal {

    // Static inner class for Node
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    public static List<List<Integer>> levelOrder(Node root) {
        if (root == null)
            return new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int len = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < len; i++) {
                Node node = q.poll();
                level.add(node.data);

                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }

            res.add(level);
        }

        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(12);
        root.right = new Node(13);
        root.left.left = new Node(7);
        root.left.right = new Node(14);
        root.right.right = new Node(2);
        root.left.left.left = new Node(17);
        root.left.left.right = new Node(23);
        root.left.right.left = new Node(27);
        root.left.right.right = new Node(3);
        root.right.right.left = new Node(8);
        root.right.right.right = new Node(11);

        List<List<Integer>> res = levelOrder(root);

        for (List<Integer> level : res) {
            System.out.println(level);
        }
    }
}
