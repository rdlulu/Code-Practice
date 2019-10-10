/*Given an unsorted integer array, find the smallest missing positive integer.

Example 1:

Input: [1,2,0]
Output: 3
Example 2:

Input: [3,4,-1,1]
Output: 2
Example 3:

Input: [7,8,9,11,12]
Output: 1
Note:

Your algorithm should run in O(n) time and uses constant extra space.
*/

// unfortunately this solution is not O(n)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        Arrays.sort(nums);
        if (nums[nums.length-1] < 1)
            return 1;
        int tracker = 1;
        boolean hasOne = false;
        for(int i : nums) {
            if (i==1)
                hasOne = true;
            if (i>1) {
                if (i!=tracker) {
                    if (i==tracker+1 && hasOne) {
                        tracker++;
                    } else {
                        if (hasOne) 
                            return tracker+1;
                        else
                            return tracker;
                    }
                }
            }
        }
        return nums[nums.length-1]+1;
    }
}
