import java.util.HashSet;
import java.util.Arrays;
class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
       int maxLen=0;
       int left=0, right=0;
       int len = s.length();
       HashSet<Character> visited = new HashSet<Character>();
       while(right<len)
       {
            char curr = s.charAt(right);
            if(!(visited.contains(curr)))
            {
                visited.add(curr);
                maxLen = Math.max(maxLen,right-left+1);
                right++;
            }
            else
            {
                visited.remove(s.charAt(left));
                left++;
            }
       }
       return maxLen;
    } 

    public int lengthOfLongestSubstring_best(String s) 
    {
        int maxLen=0,st=0;
        int[] visited = new int[128];
        Arrays.fill(visited,-1);
        int len = s.length();
        for(int i=0;i<len;i++)
        {
            char ch = s.charAt(i);
            if(visited[ch]>=st)
            {
                st = visited[ch] + 1; //am shifting the starting index of the curr.window
            }
            visited[ch]=i;
            maxLen = Math.max(maxLen,i-st+1);
        }
        return maxLen;

    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("Üsing method 1");
        System.out.println("abcabcbb substring length is "+s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("abcabcbb substring length is "+s.lengthOfLongestSubstring("abcbadbd"));
        System.out.println("Üsing method 2");
        System.out.println("abcabcbb substring length is "+s.lengthOfLongestSubstring_best("abcabcbb"));
        System.out.println("abcabcbb substring length is "+s.lengthOfLongestSubstring_best("abcbadbd"));
    }
}