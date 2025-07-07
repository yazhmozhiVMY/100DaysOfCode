class Solution 
{
    //This is method 1 - reversing the number
    public boolean isPalindrome(int x) 
    {
        int reverse = 0;
        int temp = x;
        if(x<0)
        {
            return false;
        }
        else
        {
            while(temp>0)
            {
                reverse = (reverse*10)+(temp%10);
                temp = temp/10;
            }
            if(reverse==x) return true;
            else return false;
        }
    }
    //Method 2- number as a string - not accepted in leet code
    public boolean isPalindromeASstring(int x)
    {
        if (x<0) 
        {
            return false;
        }
        else
        {
            String s = Integer.toString(x);
            int len = s.length();
            for(int i=0;i<len/2;i++)
            {
                if(s.charAt(i)!=s.charAt(len-i-1)) return false;
            }
            return true;
        }
    }
    // Method 3 - This checks half of the number to avoid overflows
    public boolean isPalindrome_BEST(int x) 
    {
        int reverse = 0;
        if(x<0 || (x%10==0 && x!=0)) return false;
        while(x>reverse)
        {
                reverse = (reverse*10)+(x%10);
                x/=10;
        }
        if(x==reverse || x==reverse/10) return true;
        else return false;
      
    }
    
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("1st Method 121 "+s.isPalindrome(121));
        System.out.println("1st Method -121 "+s.isPalindrome(-121));
        System.out.println("1st Method 1214 "+s.isPalindrome(1214));
        System.out.println("2nd Method 121 "+s.isPalindromeASstring(121));
        System.out.println("2nd Method -121 "+s.isPalindromeASstring(-121));
        System.out.println("2nd Method 1214 "+s.isPalindromeASstring(1214));
        System.out.println("3rd Method 121 "+s.isPalindrome_BEST(121));
        System.out.println("3rd Method -121 "+s.isPalindrome_BEST(-121));
        System.out.println("3rd Method 1214 "+s.isPalindrome_BEST(1214));
    }
}
