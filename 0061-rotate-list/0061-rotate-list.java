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
    public ListNode rotateRight(ListNode head, int k) {

        //if no rotations needed
        if(head==null || head.next==null || k==0)
            return head;
        
        ListNode cur= head;
        int length=1;

        //to compute the length of LL
        while(cur.next!=null){
            cur=cur.next;
            length+=1;
        }

        cur.next=head;

        //to reduce the repeated rotations as much as possible
        k=k%length;
        k=length-k;

        for(int i=0;i<k;i++){
            cur=cur.next;
        }

        head=cur.next;
        cur.next=null;

        return head;
    }
}