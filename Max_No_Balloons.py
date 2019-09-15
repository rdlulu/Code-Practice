'''
1189. Maximum Number of Balloons
Difficulty:Easy
Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
You can use each character in text at most once. Return the maximum number of instances that can be formed.
'''
class Solution(object):
    def maxNumberOfBalloons(self, text):
        """
        :type text: str
        :rtype: int
        balloon
        """
        dic = {'b': 1, 'a': 1, 'n':1, 'l': 2, 'o': 2}
        temp = {i : 0 for i in dic}
        for c in text:
            if c in temp:
                temp[c] += 1
        minx = sys.maxint
        for k in temp:
            minx = min(minx, temp[k] / dic[k])
        return minx
