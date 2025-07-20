public class RemoveNthNodeFromEnd
{
    public ListNode removeNthFromEnd(ListNode head, int n) 
    {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++)
            fast = fast.next;
        if (fast == null)
            return head.next;
        while (fast.next != null) 
        {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) 
    {
        RemoveNthNodeFromEnd r = new RemoveNthNodeFromEnd();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = r.removeNthFromEnd(head, 2);

        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
