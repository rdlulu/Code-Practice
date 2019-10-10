/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
*/
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return s == null && p == null;
        boolean[][] check = new boolean[s.length() + 1][p.length() + 1];
        check[0][0] = true;
        for(int i = 1; i < p.length() + 1; i++) {
            if(check[0][i - 1] && p.charAt(i - 1) == '*') {
                check[0][i] = true;
            }
        }
        for(int j = 1; j < s.length() + 1; j++) {
            for(int i = 1; i < p.length() + 1; i++) {
                //case I
                if(s.charAt(j - 1) == p.charAt(i - 1) || p.charAt(i - 1) == '?') {
                    check[j][i] = check[j - 1][i - 1];
                }
                //case II
                if(p.charAt(i - 1) == '*') {
                    check[j][i] = check[j - 1][i] | check[j][i - 1];
                }
            }
            
        }
        return check[s.length()][p.length()];
    }
}
