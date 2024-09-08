/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
struct ListNode** splitListToParts(struct ListNode* head, int k, int* returnSize) {
    struct ListNode* dummy = head;
    int count = 0;

    while (dummy != NULL) {
        count++;
        dummy = dummy->next;
    }

    int parts = count / k;
    int rest = count % k;
    struct ListNode** ans = (struct ListNode**)malloc(k * sizeof(struct ListNode*));
    *returnSize = k;

    int i = 0;
    while (k > 0) {
        int t = parts;
        if (rest > 0) {
            t++;
            rest--;
        }
        struct ListNode* newHead = head;
        struct ListNode* current = newHead;
        while (newHead != NULL && t > 1) {
            newHead = newHead->next;
            t--;
        }

        if (newHead != NULL) {
            head = newHead->next;
            newHead->next = NULL;
        }
        ans[i] = current;
        i++;
        k--;
    }
    return ans;
}