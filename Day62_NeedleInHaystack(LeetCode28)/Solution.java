class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        // If needle is empty, the index to return is 0 (as per the problem statement).
        if (needle.isEmpty()) {
            return 0;
        }

        // Get the lengths of haystack and needle.
        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Initialize pointers for haystack and needle.
        int haystackPointer = 0;
        int needlePointer = 0;

        // Iterate through the haystack.
        while (haystackPointer < haystackLength) {
            // Check if the current characters in the haystack and needle are the same.
            if (haystack.charAt(haystackPointer) == needle.charAt(needlePointer)) {
                // Special case: if needle length is 1 and characters match, we found the needle.
                if (needleLength == 1) {
                    return haystackPointer;
                }
                // Move both pointers forward.
                haystackPointer++;
                needlePointer++;
            } else {
                // Current characters do not match. Reset haystackPointer back by the amount
                // needlePointer had advanced, then move forward by one to search from next position.
                haystackPointer -= needlePointer - 1;
                // Reset needlePointer back to the start of the needle.
                needlePointer = 0;
            }

            // Check if the needle has been found within the haystack.
            if (needlePointer == needleLength) {
                // The start of the substring in haystack that matches the needle
                // is at the difference between current haystackPointer and the length of the needle.
                return haystackPointer - needlePointer;
            }
        }
      
        // Needle was not found in the haystack. Return -1 as specified in the problem statement.
        return -1;
    }
}

Reference: Algo monster
