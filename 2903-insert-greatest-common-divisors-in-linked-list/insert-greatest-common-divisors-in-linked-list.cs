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
        if (head == null || head.next == null) return head;
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
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }
}