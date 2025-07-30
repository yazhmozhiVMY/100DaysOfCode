class Solution 
{
    public int longestValidParentheses(String s)  
    {
        int maxLen = 0;
        
        // Left to Right Traversal
        int open = 0, close = 0;
        for (char ch : s.toCharArray()) 
        {
            if (ch == '(') 
            {
                open++;
            } 
            else if (ch == ')') 
            {
                close++;
            }

            if (open == close) 
            {
                maxLen = Math.max(maxLen, 2 * close);
            } 
            else if (close > open) 
            {
                open = close = 0;
            }
        }

        // Right to Left Traversal
        open = close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                close++;
            }

            if (open == close) {
                maxLen = Math.max(maxLen, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return maxLen;
    }
}
