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
    public ListNode swapNodes(ListNode head, int k) {
        int count=1;
        ListNode fast=head;
        ListNode slow= head;
        ListNode firstK= head;
        ListNode lastK= head;
        
        for(int i=1;i<k;i++)
        {
            fast=fast.next;
        }

        firstK=fast;

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }

        lastK=slow;

        int temp=firstK.val;
        firstK.val=lastK.val;
        lastK.val=temp;
       

        return head;
    }
}