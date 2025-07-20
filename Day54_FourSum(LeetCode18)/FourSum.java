import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class FourSum
{
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<n-3;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            // Early termination
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            for(int j=i+1;j<n-2;j++)
            {
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                // Early termination
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                int left = j+1;
                int right = n-1;
                while(left<right)
                {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum==target)
                    {
                        result.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                        while(left<right && nums[left]==nums[left-1]) left++;
                        while(left<right && nums[right]==nums[right+1]) right--;
                    }
                    else if(sum<target) left++;
                    else right--; //sum>target
                }
            }
        }
        return result;
    }
    public static void main(String[] args)
    {
        int[] ip1={1,0,-1,0,-2,2};
        int[] ip2={2,2,2,2,2};
        FourSum t = new FourSum();
        System.out.println("Input [1,0,-1,0,-2,2] and target 0 : "+t.fourSum(ip1,0));
        System.out.println("Input [2,2,2,2,2] and target 8: "+t.fourSum(ip2,8));
    }
}
