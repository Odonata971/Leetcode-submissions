/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] result = new int[] {-1, -1};
        int prevCriticalInd = 0;
        int firstCriticalInd = 0;
        ListNode prev = head;
        ListNode curr = head.next;
        int currInd = 1;

        while (curr.next != null) {
            if (isLocalExtremum(prev, curr)) {
                if (prevCriticalInd != 0) {
                    result[0] = (result[0] == -1) 
                    ? currInd - prevCriticalInd 
                    : Math.min(result[0], currInd - prevCriticalInd);
                } else {
                    firstCriticalInd = currInd;
                }
                prevCriticalInd = currInd;
            }
            prev = curr;
            curr = curr.next;
            currInd++;
        }

        if (prevCriticalInd != 0 && prevCriticalInd != firstCriticalInd) {
            result[1] = prevCriticalInd - firstCriticalInd;
        }

        return result;
    }

    private boolean isLocalExtremum (ListNode prev, ListNode curr) {
        return (prev.val < curr.val && curr.next.val < curr.val) 
        || (prev.val > curr.val && curr.next.val > curr.val);
    }
}