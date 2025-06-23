// Java implementation for Boundary Traversal of Binary Tree
// using Iteration with Morris Traversal
import java.util.ArrayList;

class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}

class boundaryTraversal {

    static boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }
	
  	// Function to collect the left boundary nodes
    static void collectBoundaryLeft(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;

        Node curr = root;
        while (!isLeaf(curr)) {
            res.add(curr.data);

            if (curr.left != null)
                curr = curr.left;
            else
                curr = curr.right;
        }
    }

    // Function to collect the leaf nodes using Morris Traversal
    static void collectLeaves(Node root, ArrayList<Integer> res) {
        Node current = root;

        while (current != null) {
            if (current.left == null) {
              
                // If it's a leaf node
                if (current.right == null) 
                    res.add(current.data);

                current = current.right;
            } 
          	else {
              
                // Find the inorder predecessor
                Node predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    predecessor.right = current;
                    current = current.left;
                } 
              	else {
                  	// If it's predecessor is a leaf node
                    if (predecessor.left == null) 
                        res.add(predecessor.data);
                    
                    predecessor.right = null;
                    current = current.right;
                }
            }
        }
    }


    // Function to collect the right boundary nodes
    static void collectBoundaryRight(Node root, ArrayList<Integer> res) {
        if (root == null)
            return;

        Node curr = root;
        ArrayList<Integer> temp = new ArrayList<>();
        while (!isLeaf(curr)) {
            temp.add(curr.data);

            if (curr.right != null)
                curr = curr.right;
            else
                curr = curr.left;
        }

        for (int i = temp.size() - 1; i >= 0; --i)
            res.add(temp.get(i));
    }

    // Function to perform boundary traversal
    static ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null)
            return res;

        // Add root data if it's not a leaf
        if (!isLeaf(root))
            res.add(root.data);

        // Collect left boundary
        collectBoundaryLeft(root.left, res);

        // Collect leaf nodes
        collectLeaves(root, res);

        // Collect right boundary
        collectBoundaryRight(root.right, res);

        return res;
    }

    public static void main(String[] args) {
        // Hardcoded Binary tree
        //        20
        //       /  \
        //      8    22
        //     / \     \
        //    4   12    25
        //       /  \
        //      10   14
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right.right = new Node(25);

        ArrayList<Integer> boundary = boundaryTraversal(root);

        for (int x : boundary)
            System.out.print(x + " ");
    }
}