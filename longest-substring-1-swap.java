/*
1156. Swap For Longest Repeated Character Substring
Given a string text, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.

Example 1:
Input: text = "ababa"
Output: 3
Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa", which its length is 3.
*/

class Solution {
    public int maxRepOpt1(String text) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> counts = new LinkedList<>();
        List<Character> chars = new LinkedList<>();
        //keep two lists at same length
        int index = 0;
        while(index < text.length()) {
            char c = text.charAt(index);
            int cnt = 1;
            while(index < text.length() - 1 && text.charAt(index + 1) == c) {
                cnt++;
                index++;
            }
            counts.add(cnt);
            chars.add(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
            index++;
        }
        int max = 0;
        for(int i = 0; i < counts.size(); i++) {
            int precount = i > 0 ? counts.get(i - 1) : 0;
            int postcount = (i < counts.size() - 1) ? counts.get(i + 1) : 0;
            int curcount = counts.get(i);
            if(precount + curcount + postcount <= max) continue;
            max = Math.max(max, curcount + (map.get(chars.get(i)) >= 2 ? 1 : 0));
            if(curcount == 1 && precount != 0  && postcount != 0 && chars.get(i - 1) == chars.get(i + 1)) {
                int temp = precount + postcount + (map.get(chars.get(i - 1)) >= 3 ? 1 : 0);
                if(max < temp) {
                    max = temp;
                }
            }
        }
        return max;
    }
}
