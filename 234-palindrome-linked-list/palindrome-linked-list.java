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
    public boolean isPalindrome(ListNode head) {
        List<Integer> array = new ArrayList<>();
        
        while (head != null) {
            array.add(head.val);
            head = head.next;
        }
        int n = array.size();
        
        for (int left = 0; left < n / 2; left++) {
            if (!array.get(left).equals(array.get(n - 1 - left))) {
                return false;
            }
        }
        return true;
    }
}