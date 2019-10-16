/*Text Justification

Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

Note:

A word is defined as a character sequence consisting of non-space characters only.
Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
The input array words contains at least one word.
Example 1:

Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
*/
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        String temp = "";
        int index = 0;
        while(index < words.length) {
            int len = words[index].length();
            if(len + temp.length() > maxWidth) {
                temp = justify(temp, maxWidth);
                res.add(temp);
                temp = "";
            }
            temp += words[index] + " ";
            index++;
        }
        String lastline = temp.trim();
        for(int i = lastline.length(); i < maxWidth; i++) {
            lastline += " ";
        }
        res.add(lastline);
        return res;
    }
    private String justify(String s, int maxWidth) {
        String[] strs = s.trime().split(" ");
        int cntSpaces = maxWidth - s.length() + strs.length - 1;
        String str = "";
        if(strs.length == 1) {
            str += strs[0];
            for(int i = 0; i < cntSpaces; i++) {
                str += " ";
            }
            return str;
        }
        int base = cntSpaces / (strs.length - 1);
        int residue = cntSpaces % (strs.length - 1);
        int i = 0;
        while(i < strs.length) {
            str += strs[i++];
            for(int k = 0; k < base; k++) {
                str += " ";
            }
            if(residue > 0) {
                str += " ";
                residue--;
            };
        }
        return str.trim();   
    }
}
