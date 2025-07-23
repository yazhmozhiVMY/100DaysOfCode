public class SwapPairsLL
{
    public ListNode swapPairs(ListNode head) 
    {
        // Dummy node to simplify head swaps
        ListNode dummy = new ListNode(0);
        dummy.next = head;
    
        ListNode prev = dummy;
    
        while (prev.next != null && prev.next.next != null) 
        {
            
            ListNode first = prev.next;
            ListNode second = prev.next.next;
    
            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;
    
            // Move to the next pair
            prev = first;
        }
    
        return dummy.next;  
    }
    public void printList(ListNode head) 
    {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) 
    {

        // Creating the linked list: 
      	// 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> NULL
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        SwapPairsLL s = new SwapPairsLL();
        
        ListNode h = s.swapPairs(head);
        
        s.printList(h);
    }
}
