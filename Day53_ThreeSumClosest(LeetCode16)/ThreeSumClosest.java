
/**
 * Write a description of class ThreeSumClosest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class ThreeSumClosest
{
   public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int diff=Integer.MAX_VALUE;
        int result=0;
        int n = nums.length;
        for(int i=0;i<n-2;i++)
        {
            int left=i+1,right=n-1;
            while(left<right)
            {
                int sum = nums[i]+nums[left]+nums[right];
                int currentDiff = sum - target;
                currentDiff = currentDiff >= 0 ? currentDiff : -currentDiff;
                if(currentDiff<diff)
                {
                    diff = currentDiff;
                    result=sum;
                }
                if(currentDiff==0) return sum;
                else if(sum>target) right--;
                else left++;
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] ip1={-1,2,1,-4};
        int[] ip2={-1, 2, 2, 4};
        ThreeSumClosest t = new ThreeSumClosest();
        System.out.println("Input [-1,2,1,-4] and target 1 : "+t.threeSumClosest(ip1,1));
        System.out.println("Input [-1, 2, 2, 4] and target 4: "+t.threeSumClosest(ip2,4));
    }
}
