class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class linkedlist_floyd_cycle_detection {

    // Function to detect cycle and return starting node
    public ListNode firstNodeOfCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean found = false;

        // Step 1: Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                found = true;
                break;
            }
        }

        if (!found) return null; // No cycle

        // Step 2: Find starting node of cycle
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow; // starting node of cycle
    }

    public static void main(String[] args) {
        // Create example list
        // 1 -> 2 -> 3 -> 4 -> 5
        //            ↑       |
        //            |_______|

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Creating a cycle manually: 5.next = 3
        head.next.next.next.next.next = head.next.next; 

        // Calling algorithm
        linkedlist_floyd_cycle_detection obj = new linkedlist_floyd_cycle_detection();
        ListNode startNode = obj.firstNodeOfCycle(head);

        if (startNode != null) {
            System.out.println("Cycle starts at node with value: " + startNode.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}
