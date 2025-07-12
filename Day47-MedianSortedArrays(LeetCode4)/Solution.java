
/**
 * Write a description of class Solution here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Solution
{
    public double findMedianSortedArrays_brute(int[] nums1, int[] nums2) 
    {
        int[] temp = new int[nums1.length+nums2.length];
        System.arraycopy(nums1,0,temp,0,nums1.length);
        System.arraycopy(nums2,0,temp,nums1.length,nums2.length);
        int len = temp.length;
        Arrays.sort(temp);
        if(len%2==0) return (temp[len/2]+temp[len/2-1])/2.0;
        else return temp[len/2];
    }
    public double findMedianSortedArrays_mergeProc(int[] nums1, int[] nums2) 
    {
        int m = nums1.length;
        int n = nums2.length;
        int i =0;
        int j = 0;
        int m1=-1,m2=-1;
        for(int c=0;c<=(m+n)/2;c++)
        {
            m2=m1;
            if(i!=m && j!=n) //Both arrays have elements left
            {
                m1=(nums1[i]<nums2[j])?nums1[i++]:nums2[j++];
                
            }
            else if(i<m) m1=nums1[i++];
            else m1=nums2[j++];
        }
        if((m+n)%2==0)  return (m1+m2)/2.0;
        else return m1;
        
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) 
    {
        
        int n1 = nums1.length;
        int n2=nums2.length;
        if(n2<n1) findMedianSortedArrays(nums2,nums1);
        int begin1=0,end1=n1;
        while(begin1<=end1)
        {
            int mid1 = (begin1+end1)/2;
            int mid2 = (n1+n2+1)/2-mid1;
            // Find elements to the left and right of partition in nums1[]
            //max1
            int l1 = (mid1==0)? Integer.MIN_VALUE:nums1[mid1-1];
            //min1
            int r1 = (mid1==n1)? Integer.MAX_VALUE:nums1[mid1];
            // Find elements to the left and right of partition in nums2[]
            //max2
            int l2 = (mid2==0)? Integer.MIN_VALUE:nums2[mid2-1];
            //min2
            int r2 =(mid2==n2)? Integer.MAX_VALUE:nums2[mid2];
            
            //Check if it is a valid partition 
            //ie All the elements in the left partition are less than the elements in the right partition
            
            if(l1<=r2 && l2<=r1) 
            {
                if((n1+n2)%2==1)    return Math.max(l1,l2);
                else return (Math.min(r1,r2)+Math.max(l1,l2))/2.0;
            }
            else if (l1>r2) end1=mid1-1;
            else begin1 = mid1+1;
        }
        return 0;
    }
    public static void main(String[] args)
    {
        Solution s = new Solution();
        int[] arr1 = {10,20,30};
        int[] arr2 = {5,15,25,35,45};
        int[] arr3 = {1,5,7};
        int[] arr4 = {2,3,4,6};
        System.out.println("{10 20 30} and {5 15 25 35 45} is "+s.findMedianSortedArrays_brute(arr1,arr2));
        System.out.println("{1 5 7} and {2 3 4 6} is "+s.findMedianSortedArrays_brute(arr3,arr4));
        System.out.println("{10 20 30} and {5 15 25 35 45} is "+s.findMedianSortedArrays_mergeProc(arr1,arr2));
        System.out.println("{1 5 7} and {2 3 4 6} is "+s.findMedianSortedArrays_mergeProc(arr3,arr4));
        System.out.println("{10 20 30} and {5 15 25 35 45} is "+s.findMedianSortedArrays(arr1,arr2));
        System.out.println("{1 5 7} and {2 3 4 6} is "+s.findMedianSortedArrays(arr3,arr4));

    }
}
