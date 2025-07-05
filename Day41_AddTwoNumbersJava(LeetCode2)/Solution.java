class Solution 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode dummyHeader = new ListNode(0);
        ListNode result = dummyHeader;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0)
        {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x+y+carry;
            carry = sum/10;
            result.next = new ListNode(sum%10);
            result = result.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        return dummyHeader.next;
    }
    public void printList(ListNode head) 
    {
        while (head != null) 
        {
            System.out.print(head.val);
            if (head.next != null) 
            {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode res = s.addTwoNumbers(l1,l2);
        s.printList(l1);
        s.printList(l2);
        s.printList(res);
        
    }
}