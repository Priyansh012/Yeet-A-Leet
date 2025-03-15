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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // Dummy node to track new head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode traverse = head;

        while (traverse != null && traverse.next != null) {
            ListNode first = traverse;
            ListNode second = traverse.next;

            // Swap nodes
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // Move pointers forward
            prev = first;
            traverse = first.next;
        }

        return dummy.next;

    }
}