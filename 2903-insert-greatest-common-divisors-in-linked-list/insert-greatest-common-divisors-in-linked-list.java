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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null) return head;
        ListNode dummy = head;

        while (head.next != null) {
            int g = gcd(head.val, head.next.val);
            ListNode newNode = new ListNode(g);

            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
        return dummy;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}