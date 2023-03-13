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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        ListNode dummy=null;
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null){
            dummy=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        dummy.next=null; //to give an end condition to left half
        ListNode left=sortList(head);
        ListNode right=sortList(slow);

        return merge(left, right);
    }

    public ListNode merge(ListNode left, ListNode right){
        ListNode ptr= new ListNode(0);
        ListNode temp=ptr;

        while(left!=null && right!=null){
            if(left.val<=right.val){
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }
        
        while(left!=null){
            temp.next=left;
            left=left.next;
            temp=temp.next;
        }
        
        while(right!=null){
            temp.next=right;
            right=right.next;
            temp=temp.next;
        }
        
        return ptr.next;
    }    
}