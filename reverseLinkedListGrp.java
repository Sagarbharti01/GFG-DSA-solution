class node {
    int val;
    node next;
    node(int val) { this.val = val; }
}

public class reverseLinkedListGrp {

    public node reverseInGroups(node head, int k) {
        if (head == null) return null;

        node current = head;
        node prev = null;
        node next = null;
        int count = 0;

        // Reverse first k nodes
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Recursively reverse remaining list and connect
        if (next != null) {
            head.next = reverseInGroups(next, k);
        }

        // prev is new head of reversed group
        return prev;
    }

    // Helper method to print list
    public void printList(node head) {
        node curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    // Example usage
    public static void main(String[] args) {
        reverseLinkedListGrp sol = new reverseLinkedListGrp();

        // Creating linked list 1->2->3->4->5->6
        node head = new node(1);
        head.next = new node(2);
        head.next.next = new node(3);
        head.next.next.next = new node(4);
        head.next.next.next.next = new node(5);
        head.next.next.next.next.next = new node(6);

        System.out.println("Original list:");
        sol.printList(head);

        int k = 2;
        node reversedHead = sol.reverseInGroups(head, k);

        System.out.println("Reversed in groups of " + k + ":");
        sol.printList(reversedHead);
    }
}
