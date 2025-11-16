import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class linkedlist_floyd_cycle_detection_user_input {

    // Floyd's Algorithm → Detect first node of cycle
    public ListNode firstNodeOfCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Step 1 → Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Cycle found
                slow = head;

                // Step 2 → Find cycle entry
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null; // No cycle
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid list!");
            return;
        }

        System.out.println("Enter " + n + " values:");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;

        // Storing all nodes in a list to create cycle easily
        List<ListNode> nodeList = new ArrayList<>();
        nodeList.add(head);

        for (int i = 1; i < n; i++) {
            ListNode newNode = new ListNode(sc.nextInt());
            current.next = newNode;
            current = newNode;
            nodeList.add(newNode);
        }

        System.out.print("Enter position to create cycle (0 for no cycle): ");
        int pos = sc.nextInt();

        if (pos > 0 && pos <= n) {
            current.next = nodeList.get(pos - 1);  // Create cycle
        }

        linkedlist_floyd_cycle_detection_user_input obj = new linkedlist_floyd_cycle_detection_user_input();
        ListNode entry = obj.firstNodeOfCycle(head);

        if (entry != null) {
            System.out.println("Cycle starts at node with value: " + entry.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}
