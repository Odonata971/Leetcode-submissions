/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode InsertGreatestCommonDivisors(ListNode head) {
        if (head == null) return head;

        ListNode dummy = head;
        while (dummy.next != null) {
            int d = gcd(dummy.val, dummy.next.val);
            ListNode newNode = new ListNode(d);

            newNode.next = dummy.next;
            dummy.next = newNode;
            dummy = dummy.next.next;
        }
        return head;
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}