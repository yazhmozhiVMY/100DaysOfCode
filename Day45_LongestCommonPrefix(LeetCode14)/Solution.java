
/**
 * Write a description of class Solution here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Solution
{
    public String longestCommonPrefix_sorting(String[] strs) 
    {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length-1];
        int min = Math.min(first.length(),last.length());
        int i=0;
        while(i < min && first.charAt(i) == last.charAt(i))
        {
            i++;
        }
        return first.substring(0,i);
    }
    public String longestCommonPrefix_verticalScanning(String[] strs) 
    {
        if(strs.length==0) return "";
        for(int i=0;i<strs[0].length();i++)
        {
            char ch = strs[0].charAt(i);
            for(int j=0;j<strs.length;j++)
            {
                if(i==strs[j].length() || ch!=strs[j].charAt(i)) return strs[0].substring(0,i);
            }
        }
        return strs[0];
        
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        String[] input1 = {"flower","flow","flight"};
        String[] input2 = {"dog","racecar","car"};
        System.out.println("Sorting [flower,flow,flight] prefix is "+s.longestCommonPrefix_sorting(input1));
        System.out.println("Vertical Scanning [flower,flow,flight] prefix is "+s.longestCommonPrefix_verticalScanning(input1));
        System.out.println("Sorting [car,dog,racecar] prefix is "+s.longestCommonPrefix_sorting(input2));
        System.out.println("Vertical Scanning [car,dog,racecar] prefix is "+s.longestCommonPrefix_verticalScanning(input2));

    }
}
