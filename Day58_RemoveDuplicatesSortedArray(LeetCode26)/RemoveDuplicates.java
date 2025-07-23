
public class RemoveDuplicates
{
    public int removeDuplicates(int[] nums) 
    {
        int n = nums.length;
        if (n <= 1)
            return n;
		
      	// Start from the second element
        int idx = 1; 
      
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[idx++] = nums[i];
            }
        }
        return idx;
    }
    public static void main(String[] args) 
    {
        RemoveDuplicates r = new RemoveDuplicates();
        int[] arr = {1,1,1,1, 2, 2, 3, 4, 4, 4, 5, 5};
        int newSize = r.removeDuplicates(arr);

        for (int i = 0; i < newSize; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
