public class Solution
{
    public int maxArea_BruteForce(int[] height) 
    {
        int n = height.length;
        int maxVol=0;
        int currVolume = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                currVolume = Math.min(height[i],height[j])*(j-i);
                maxVol = Math.max(currVolume,maxVol);
            }
        }
        return maxVol;
    }
    public int maxArea_Efficient(int[] height) 
    {
        int n = height.length;
        int l=0;
        int r=n-1;
        int maxVol =0;
        int currVol = 0;
        while(l<r)
        {
            currVol = Math.min(height[l],height[r])*(r-l);
            maxVol = Math.max(maxVol,currVol);
            if(height[l]<height[r]) l+=1;
            else r-=1;
        }
        return maxVol;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] input1 = {1, 5, 4, 3}; //solution 6
        int[] input2 = {3, 1, 2, 4, 5}; // solution 12
        int[] input3 = {2, 1, 8, 6, 4, 6, 5, 5}; //solution 25
        System.out.println("input1 {1, 5, 4, 3} maxVol is "+s.maxArea_BruteForce(input1));
        System.out.println("input2 {3, 1, 2, 4, 5} maxVol is "+s.maxArea_BruteForce(input2));
        System.out.println("input3 {2, 1, 8, 6, 4, 6, 5, 5} maxVol is "+s.maxArea_BruteForce(input3));
        
        System.out.println("input1 {1, 5, 4, 3} maxVol is "+s.maxArea_Efficient(input1));
        System.out.println("input2 {3, 1, 2, 4, 5} maxVol is "+s.maxArea_Efficient(input2));
        System.out.println("input3 {2, 1, 8, 6, 4, 6, 5, 5} maxVol is "+s.maxArea_Efficient(input3));

    }
    
}
