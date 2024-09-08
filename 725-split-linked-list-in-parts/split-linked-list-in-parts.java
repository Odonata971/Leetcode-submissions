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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode dummy = head;
        int count = 0;

        while (dummy != null) {
            count++;
            dummy = dummy.next;
        }
        
        int parts = count / k;
        int rest = count % k;
        ListNode[] ans = new ListNode[k];

        int i = 0;
        while (k-- > 0) {
            int t = parts;
            if (rest > 0) {
                t++;
                rest--;
            }
            ListNode newHead = head;
            ListNode current = newHead;
            while (newHead != null && t-- > 1) {
                newHead = newHead.next;
            }

            if (newHead != null) {
                head = newHead.next;
                newHead.next = null;
            }
            ans[i] = current;
            i++;
        }
        return ans;
    }
}