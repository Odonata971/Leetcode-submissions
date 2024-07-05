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
    /*
    This is brute force (down below another approach with fast and slow pointer)

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        int gotThrough = Integer.MAX_VALUE;
        while (head.next != null) {
            if (head.next.val == gotThrough) {
                return true;
            }
            head.val = gotThrough;
            head = head.next;
        }
        return false;
    }*/

    public boolean hasCycle (ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}