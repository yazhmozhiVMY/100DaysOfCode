public class Solution 
{

    // Function to merge two sorted linked 
    // lists iteratively
    public static Node sortedMerge(Node head1,Node head2) 
    {

        // Create a dummy node to simplify 
        // the merging process
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Iterate through both linked lists
        while (head1 != null && head2 != null) 
        {
          
            // Add the smaller node to the merged list
            if (head1.data <= head2.data) 
            {
                curr.next = head1;
                head1 = head1.next;
            } else 
            {
                curr.next = head2;
                head2 = head2.next;
            }
            curr = curr.next;
        }

        // If any list is left, append it to 
        // the merged list
        if (head1 != null) 
        {
            curr.next = head1;
        } 
        else 
        {
            curr.next = head2;
        }

        // Return the merged list starting from 
        // the next of dummy node
        return dummy.next;
    }

    public static void printList(Node head) 
    {
        while (head != null) 
        {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {

        // First linked list: 5 -> 10 -> 15 -> 40 -> 50 -> 60
        Node head1 = new Node(5);
        head1.next = new Node(10);
        head1.next.next = new Node(15);
        head1.next.next.next = new Node(40);
        head1.next.next.next.next = new Node(50);
        head1.next.next.next.next.next = new Node(60);

        // Second linked list: 2 -> 3 -> 20
        Node head2 = new Node(2);
        head2.next = new Node(3);
        head2.next.next = new Node(20);

        Node res = sortedMerge(head1, head2);
        printList(res);
    }
}