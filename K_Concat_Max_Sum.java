/*
1191. K-Concatenation Maximum Sum
Difficulty:Medium
Given an integer array arr and an integer k, modify the array by repeating it k times.
For example, if arr = [1, 2] and k = 3 then the modified array will be [1, 2, 1, 2, 1, 2].
Return the maximum sub-array sum in the modified array. Note that the length of the sub-array can be 0 and its sum in that case is 0.
As the answer can be very large, return the answer modulo 10^9 + 7.
Example 1:
Input: arr = [1,2], k = 3
Output: 9
Example 2:
Input: arr = [1,-2,1], k = 5
Output: 2
Example 3:
Input: arr = [-1,-2], k = 7
Output: 0

Constraints:
1 <= arr.length <= 10^5
1 <= k <= 10^5
-10^4 <= arr[i] <= 10^4
*/
class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int leftMin = 0;
        int rightMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        int delta = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(sum > max) max = sum;
            if(sum < leftMin) {
                leftMin = sum;
                rightMax = sum;
            }
            else if(sum > rightMax) {
                rightMax = sum;
            }
            delta = Math.max(rightMax - leftMin, delta);
        }
        int ans1 = Math.max(max - leftMin + (int)(((long)(k - 1) * (long)sum) % 1000000007), delta);
        int ans2 = k > 1 ? (max - leftMin + sum) % 1000000007 : 0;
        return Math.max(ans1, ans2);
    
    }
}
