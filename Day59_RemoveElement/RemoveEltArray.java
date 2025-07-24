public class RemoveEltArray
{
    public int removeElement(int[] nums, int val) 
    {        
        int k = 0;  
        int n = nums.length;
        for (int i = 0; i < n; i++) 
        {            
            if(nums[i] != val)
            {                
                nums[k] = nums[i];                
                k++;            
            }        
        }        
        return k;    
    }
    public static void main(String[] args) 
    {
        RemoveEltArray r = new RemoveEltArray();
        int[] arr = {2,3,3,3,4,5,5};
        int newSize = r.removeElement(arr,3);

        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
