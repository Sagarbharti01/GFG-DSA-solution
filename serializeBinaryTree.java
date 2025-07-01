// Java program to serialize and 
// deserialize a binary tree.
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Node {
    int data;
    Node left, right;
    Node (int x) {
        data = x;
        left = null;
        right = null;
    }
}

class serializeBinaryTree {
    
    // Function which traverse the tree in preorder 
    // manner and adds nodes into result.
    static void serializePreOrder(Node root, ArrayList<Integer> arr) {
        
        // Push -1 if root is null.
        if (root == null) {
            arr.add(-1);
            return;
        }
        
        // Push the root into result.
        arr.add(root.data);
        
        // Recursively traverse the 
        // left and right subtree.
        serializePreOrder(root.left, arr);
        serializePreOrder(root.right, arr);
    }

    // Main function to serialize a tree.
    static ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        serializePreOrder(root, arr);
        return arr;
    }

    // Function which traverse the array in preorder 
    // manner and constructs the tree.
    static Node deserializePreOrder(int[] i, ArrayList<Integer> arr) {
        
        // -1 meres null.
        if (arr.get(i[0]) == -1) {
            i[0]++;
            return null;
        }
        
        // Create the root node.
        Node root = new Node(arr.get(i[0]));
        i[0]++;
        
        // Create the left and right subtree.
        root.left = deserializePreOrder(i, arr);
        root.right = deserializePreOrder(i, arr);
        
        return root;
    }

    // Main function to deserialize a tree.
    static Node deSerialize(ArrayList<Integer> arr) {
       int[] i = {0};
       return deserializePreOrder(i, arr);
    }

    // Print tree as level order
    static void printLevelOrder(Node root) {
        if (root == null) {
            System.out.print("N ");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int nonNull = 1;

        while (!queue.isEmpty() && nonNull > 0) {
            Node curr = queue.poll();

            if (curr == null) {
                System.out.print("N ");
                continue;
            }
            nonNull--;

            System.out.print(curr.data + " ");
            queue.add(curr.left);
            queue.add(curr.right);
            if (curr.left != null)
                nonNull++;
            if (curr.right != null)
                nonNull++;
        }
    }

    public static void main(String[] args) {

        // Create a hard coded tree
        //       10
        //     /    \
        //    20    30
        //  /   \
        // 40  60
        Node root = new Node(10);        
        root.left = new Node(20);        
        root.right = new Node(30);       
        root.left.left = new Node(40);
        root.left.right = new Node(60); 
        
        ArrayList<Integer> arr = serialize(root);
        Node res = deSerialize(arr);
        
        printLevelOrder(res);
    }
}