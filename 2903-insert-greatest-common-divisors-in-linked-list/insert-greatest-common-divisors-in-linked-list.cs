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