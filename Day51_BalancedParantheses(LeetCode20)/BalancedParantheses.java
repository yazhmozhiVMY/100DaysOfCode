/**
 * BalancedParantheses.
 * Has 2 methods - With and without a Stack
 * @author Yazh
 * @version (1.0 16th July Day 14 of 100DaysOfLeetCode)
 */
import java.util.Stack;
public class BalancedParantheses
{
    public boolean isValid_WithStack(String s) 
    {
        Stack<Character> openParanthesesStack = new Stack<Character>();
        int len = s.length();
        for(int i=0;i<len;i++)
        {
            char currentChar = s.charAt(i);
            if(currentChar=='(' || currentChar == '[' || currentChar == '{') openParanthesesStack.push(currentChar);
            else
            {
                if ((!openParanthesesStack.isEmpty()) && ((currentChar == ')' && openParanthesesStack.peek()=='(') || (currentChar == ']' && openParanthesesStack.peek()=='[') || (currentChar == '}' && openParanthesesStack.peek()=='{'))) openParanthesesStack.pop(); 
                else return false;
            }
                
        }
        return openParanthesesStack.isEmpty();
    }
   
    public static void main(String[] args)
    {
        BalancedParantheses b = new BalancedParantheses();
        System.out.println("[(){}] balanced? "+b.isValid_WithStack("[(){}]"));
        System.out.println("[} balanced? "+b.isValid_WithStack("[}"));
        System.out.println("[ balanced? "+b.isValid_WithStack("["));
        System.out.println("[]} balanced? "+b.isValid_WithStack("[]}"));
    }
}
