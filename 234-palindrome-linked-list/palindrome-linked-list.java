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
        
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            if (!array.get(left++).equals(array.get(right--))) {
                return false;
            }
        }
        return true;
    }
}