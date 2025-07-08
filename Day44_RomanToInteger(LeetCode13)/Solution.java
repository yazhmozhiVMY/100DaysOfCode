import java.util.HashMap;
class Solution 
{
    public static int roman(char c)
    {
        if(c=='I') return 1;
        if(c=='V') return 5;
        if(c=='X') return 10;
        if(c=='L') return 50;
        if(c=='C') return 100;
        if(c=='D') return 500;
        if(c=='M') return 1000;
        return -1;
    }
    //Method 1 - without hashing
    public int romanToInt_noHashing(String s) 
    {
        int result= 0;
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            int first = roman(s.charAt(i));
            if((i+1) < n)
            {
                int second =roman(s.charAt(i+1));
                if(first<second)
                {
                    result+=(second-first);
                    i++;
                }
                else result+=first;
            }
            else result+=first;
        }
        return result;
    }
    //Method 2 - with hashing
    public int romanToInt_Hashing(String s) 
    {
        int result =0;
        HashMap<Character,Integer> hashTable = new HashMap<Character,Integer>();
        hashTable.put('I',1);
        hashTable.put('V',5);
        hashTable.put('X',10);
        hashTable.put('L',50);
        hashTable.put('C',100);
        hashTable.put('D',500);
        hashTable.put('M',1000);
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            if(i+1<n && (hashTable.get(s.charAt(i))<hashTable.get(s.charAt(i+1))))
            {
                result+=hashTable.get(s.charAt(i+1))-hashTable.get(s.charAt(i));
                i++;
            }
            else result+=hashTable.get(s.charAt(i));
        }
        return result;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println("No hashing LVIII is "+s.romanToInt_noHashing("LVIII"));
        System.out.println("IX is "+s.romanToInt_noHashing("IX"));
        System.out.println("XC is "+s.romanToInt_noHashing("XC"));
        System.out.println("Hashing LVIII is "+s.romanToInt_Hashing("LVIII"));
        System.out.println("IX is "+s.romanToInt_Hashing("IX"));
        System.out.println("XC is "+s.romanToInt_Hashing("XC"));
    }
}