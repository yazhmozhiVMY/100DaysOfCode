import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

public class MergeKsortedLLs
{
    public ListNode mergeKLists(ListNode[] lists) 
    {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Insert the head nodes of k lists 
        for (ListNode head : lists) {
            if (head != null) pq.add(head);
        }

        // Initialize a dummy head 
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!pq.isEmpty()) {

            // Pop the min node 
            ListNode top = pq.poll();

            // Append the node into list 
            tail.next = top;
            tail = top;

            // If top node has next node,
            // add it to the heap.
            if (top.next != null) {
                pq.add(top.next);
            }
        }

        return dummy.next;
    }
    public void printList(ListNode node) 
    {
        while (node != null) 
        {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
    public static void main(String[] args) {
        int k = 3;
        MergeKsortedLLs m = new MergeKsortedLLs();
        ListNode[] arr = new ListNode[k];

        arr[0] = new ListNode(1);
        arr[0].next = new ListNode(3);
        arr[0].next.next = new ListNode(5);
        arr[0].next.next.next = new ListNode(7);

        arr[1] = new ListNode(2);
        arr[1].next = new ListNode(4);
        arr[1].next.next = new ListNode(6);
        arr[1].next.next.next = new ListNode(8);

        arr[2] = new ListNode(0);
        arr[2].next = new ListNode(9);
        arr[2].next.next = new ListNode(10);
        arr[2].next.next.next = new ListNode(11);

        ListNode head = m.mergeKLists(arr);

        m.printList(head);
    }
}
