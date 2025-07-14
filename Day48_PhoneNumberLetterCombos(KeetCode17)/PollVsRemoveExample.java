import java.util.LinkedList;
import java.util.Queue;
//https://medium.com/@AlexanderObregon/javas-queue-poll-method-explained-0cb3aa71258a
public class PollVsRemoveExample 
{
    public static void main(String[] args) 
    {
        Queue<String> queue = new LinkedList<>();

        // Poll returns null
        System.out.println(queue.poll()); // Output: null

        // Remove throws an exception
        try 
        {
            queue.remove(); // Throws NoSuchElementException
        } catch (Exception e) 
        {
            System.out.println("Exception: " + e);
        }
        queue.add("");
        System.out.println("is q empty "+queue.isEmpty());
        System.out.println("q poll "+queue.poll());
        
        
    }
}