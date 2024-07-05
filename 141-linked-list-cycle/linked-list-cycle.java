/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        
        int gotThrough = Integer.MAX_VALUE;
        while (head.next != null) {
            if (head.next.val == gotThrough) {
                return true;
            }
            head.val = gotThrough;
            head = head.next;
        }
        return false;
    }
}