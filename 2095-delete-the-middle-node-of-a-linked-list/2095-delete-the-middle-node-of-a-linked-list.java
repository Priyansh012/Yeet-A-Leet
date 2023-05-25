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
    public ListNode deleteMiddle(ListNode head) {
         ListNode traverse = head;
         ListNode prev=traverse;
        int count=0, mid=0;
        while(traverse!=null)
        {
            count+=1;
            traverse=traverse.next;
        }
        if(count==1){
            head=null;
            return head;
        }


        mid=count/2;
        traverse=head;
        while(mid>=1){
            prev=traverse;
            traverse=traverse.next;
            mid-=1; 
        }

        prev.next=traverse.next;
        traverse.next=null;
        return head;
    }
}