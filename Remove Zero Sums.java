/*
1171. Remove Zero Sum Consecutive Nodes from Linked List
Medium

Given the head of a linked list, we repeatedly delete consecutive sequences of nodes that sum to 0 until there are no such sequences.
After doing so, return the head of the final linked list.  You may return any such answer.

(Note that in the examples below, all sequences are serializations of ListNode objects.)

Example 1:

Input: head = [1,2,-3,3,1]
Output: [3,1]
Note: The answer [1,2,1] would also be accepted.
Example 2:

Input: head = [1,2,3,-3,4]
Output: [1,2,4]
Example 3:


Constraints:

The given linked list will contain between 1 and 1000 nodes.
Each node in the linked list has -1000 <= node.val <= 1000.

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(-1, 0);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode runner = head;
        int sum = 0;
        int index = 0;
        while(runner != null) {
            sum += runner.val;
            runner = runner.next;
            map.put(sum, index); //last node with sum
            index++;
        }
        runner = dummy;
        ListNode pre = dummy;
        index = -1;
        sum = 0;
        while(runner != null) {
            sum += runner.val;
            if(map.containsKey(sum) && (map.get(sum) != index)) {
                int nodesToSkip = map.get(sum) - index + 1;
                pre = runner;
                while(nodesToSkip-- > 0) {
                    runner = runner.next;
                    index++;
                }
                pre.next = runner;
            }
            else {
                pre = runner;
                runner = runner.next;
                index++;
            }
        }
        return dummy.next;
    }
}
