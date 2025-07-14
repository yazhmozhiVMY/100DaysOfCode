
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Write a description of class PhoneNumberCombos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhoneNumberCombos
{
    private static final String[] keyChars = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations_Improved(String digits) 
    {
        List<String> output = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return output;

        backtrack(digits, 0, new StringBuilder(), output);
        return output;
    }

    private void backtrack(String digits, int index, StringBuilder path, List<String> output) 
    {
        if (index == digits.length()) 
        {
            output.add(path.toString());
            return;
        }

        String letters = keyChars[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) 
        {
            path.append(c);
            backtrack(digits, index + 1, path, output);
            path.deleteCharAt(path.length() - 1); // backtrack
        }
    }
    public List<String> letterCombinations(String digits) 
    {
        //Check if input is an empty string
        if (digits == null || digits.isEmpty()) return new ArrayList<>();
        //Array to store the characters on the keys 
        //index is the number on the key and keyChars[index]=chars on the key
        String[] keyChars = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        //Storing output here
        List<String> output = new ArrayList<String>();
        //Queue for storing the intermediate permutations
        Queue<String> que = new LinkedList<String>();
        que.add("");
        while(!que.isEmpty())
        {
            
            //Reason for using poll instead of remove - PollVsRemoveExample 
            String prefix = que.poll();
            //Check if prefix is a valid candidate for the output list
            if(prefix.length() == digits.length()) output.add(prefix);
            else //generate combinations
            {
                
                int number = Character.getNumericValue(digits.charAt(prefix.length()));
                if(number<2 || number>9) continue;
                else
                {
                    for(char c:keyChars[number].toCharArray())
                    {
                        que.add(prefix+c);
                    }
                }
            }
        }
        //if(output.get(0)=="") output.clear();
        return output;
        
    }
    public static void main(String[] args)
    {
        PhoneNumberCombos p = new PhoneNumberCombos();
        System.out.println("Method 1 BFS Output for 23 is "+p.letterCombinations("23"));
        System.out.println("Method 1 BFS Output for empty is "+p.letterCombinations(""));
        System.out.println("Method 1 BFS Output for 235 is "+p.letterCombinations("235"));
        System.out.println("Method 2 DFS Output for 23 is "+p.letterCombinations_Improved("23"));
        System.out.println("Method 2 DFS Output for empty is "+p.letterCombinations_Improved(""));
        System.out.println("Method 2 DFS Output for 235 is "+p.letterCombinations_Improved("235"));
    }
}
