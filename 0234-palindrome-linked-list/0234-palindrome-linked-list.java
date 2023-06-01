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
        Stack<Integer> elements = new Stack<Integer>();
        ListNode traverse= head;

        while(traverse!=null){
            elements.push(traverse.val);
            traverse=traverse.next;
        }

        traverse=head;
        while(traverse!=null){
            if(traverse.val!=elements.peek())
                return false;
            traverse=traverse.next;
            elements.pop();
        }

        return true;
    }
}