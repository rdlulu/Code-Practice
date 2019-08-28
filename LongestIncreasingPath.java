329. Longest Increasing Path in a Matrix

Share
Given an integer matrix, find the length of the longest increasing path.
From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].
Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.


class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] memory = new int[matrix.length][matrix[0].length];
	    for(int i = 0; i < memory.length; i++) {
		Arrays.fill(memory[i], -1);
	    }
	    int[] max = new int[]{-1};
	    for(int i = 0; i < matrix.length; i++) {
		    for(int j = 0; j < matrix[0].length; j++) {
			    memory[i][j] = dfs(matrix, memory, max, i, j);
		    }
	    }
	    return max[0];
    }
    private int dfs(int[][] matrix, int[][] memory, int[] max, int i, int j) {
	    if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) return 0;
        if(memory[i][j] >= 0) {
            return memory[i][j];
        }
		int top = (j > 0 && matrix[i][j - 1] > matrix[i][j]) ? dfs(matrix, memory, max, i, j - 1) : 0;
		int bot = (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) ?  dfs(matrix, memory, max, i, j + 1) : 0;
		int left = (i > 0 && matrix[i - 1][j] > matrix[i][j]) ? dfs(matrix, memory, max, i - 1, j) : 0;
		int right = (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) ? dfs(matrix, memory, max, i + 1, j) : 0;
		memory[i][j] = Math.max(top, Math.max(bot, Math.max(left, right))) + 1;
	    max[0] = Math.max(max[0], memory[i][j]);
	    return memory[i][j];
    }
	
}
