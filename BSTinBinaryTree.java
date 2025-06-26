// Java program to check if a tree is 
// BST using Morris Traversal

class Node {
	int data;
	Node left, right;

	Node(int value) {
        data = value;
        left = right = null;
	}
}

class BSTinBinaryTree {

    // Function to check if the binary tree 
  	// is a BST using Morris Traversal
    static boolean isBST(Node root) {
        Node curr = root;
        Node pre;
        int prevValue = Integer.MIN_VALUE;

        while (curr != null) {
            if (curr.left == null) {
              
                // Process curr node
                if (curr.data <= prevValue) {
                  
                    // Not in ascending order
                    return false;
                }
                prevValue = curr.data;
                curr = curr.right;
            } else {
              
                // Find the inorder predecessor of curr
                pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                  
                    // Create a temporary thread to the curr node
                    pre.right = curr;
                    curr = curr.left;
                } else {
                  
                    // Remove the temporary thread
                    pre.right = null;

                    // Process the curr node
                    if (curr.data <= prevValue) {
                      
                        // Not in ascending order
                        return false;
                    }
                    prevValue = curr.data;
                    curr = curr.right;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
      
        // Create a sample binary tree
        //     10
        //    /  \
        //   5    20
        //        / \
        //       9   25
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(20);
        root.right.left = new Node(9);
        root.right.right = new Node(25);
      
      	if (isBST(root)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }
}