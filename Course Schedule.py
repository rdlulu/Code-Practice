'''
207. Course Schedule
Medium
There are a total of n courses you have to take, labeled from 0 to n-1.
Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
'''
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        dp = {i : set() for i in range(numCourses)}
        indegree = [0 for i in range(numCourses)]
        for pair in prerequisites:
            dp[pair[1]].add(pair[0])
            indegree[pair[0]] += 1
        queue, visited = [], set()
        for i in range(len(indegree)):
            if indegree[i] == 0:
                queue.append(i)
        while queue:
            lenq = len(queue)
            for i in range(lenq):
                temp = queue.pop(0)
                nexts = dp[temp]
                for next in nexts - visited:
                    indegree[next] -= 1
                    if indegree[next] == 0:
                        queue.append(next)
                visited.add(temp)
        return len(visited) == numCourses
