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
    public ListNode middleNode(ListNode head) {
        ListNode traverse = head;
        int count=0, mid=0;
        while(traverse!=null)
        {
            count+=1;
            traverse=traverse.next;
        }

        mid=count/2;

        while(mid>=1){
           head=head.next;
           mid-=1; 
        }

        return head;
    }
}