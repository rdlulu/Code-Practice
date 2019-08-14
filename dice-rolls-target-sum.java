/*
1155. Number of Dice Rolls With Target Sum

You have d dice, and each die has f faces numbered 1, 2, ..., f.
Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.

Example 1:
Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
*/
 
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d][target];
        for(int i = 0; i < target; i++) { // i == target - 1
            if(i < f) {
                dp[0][i] = 1;
            }
        }
        for(int i = 1; i < d; i++) {
            for(int j = i; j < target; j++) {
                long temp = 0L;
                for(int k = 1; k <= f; k++) {
                    if(j - k >= 0) {
                        temp += dp[i - 1][j - k];
                    }
                }
                //System.out.println("dp at i=" + i + " and j= " + j + " is " + dp[i][j]);
                dp[i][j] = (int)(temp % 1000000007);
            }
        }
        return dp[d - 1][target - 1];
    }
}
