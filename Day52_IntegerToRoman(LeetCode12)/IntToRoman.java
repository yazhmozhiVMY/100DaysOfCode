
/**
 * Write a description of class IntToRoman here.
 * Converts an integer in the range 1 <= num <= 3999 to roman 
 * @author Yazh
 * @version (1.0 17 July 2025)
 * Day 15 of 100 days of leet code
 */
public class IntToRoman
{
    public String intToRoman(int num) 
    {
        String str_romans[] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 13; ++i) {
            while (num - values[i] >= 0) {
                result.append(str_romans[i]);
                num -= values[i];
            }
        }

        return result.toString();
    
    }
    public static void main(String[] args)
    {
        IntToRoman ir=new IntToRoman();
        String output;
        int[] inputs = {1994,58,3749,9,700};
        for(int i=0;i<inputs.length;i++)
        {
            output=ir.intToRoman(inputs[i]);
            System.out.println(inputs[i] +": "+output);
            
        }
    }
}
