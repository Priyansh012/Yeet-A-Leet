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
        if(head == null || head.next == null)
            return true;
        ListNode slow=head;
        ListNode fast=head;
        int count = 0;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            count++;
            fast=fast.next.next;

        }
        //System.out.println(slow.val + "," + slow.next.val);
        if(slow.next == null)   
            return head.val == slow.val; 
        ListNode prev=slow;
        ListNode cur=slow.next;
        ListNode next=cur.next;


        while(cur.next!=null){
            cur.next=prev;
            prev=cur;
            cur=next;
            next=next.next;
        }
        cur.next=prev;


        while(head!=cur && count > 0){
            if(cur.val!=head.val)
                return false;
            
            cur=cur.next;
            head=head.next;
            count--;
        }
        // while(head != cur && count > 0){
        //     System.out.println(head.val + " , " + cur.val);
        //     head = head.next;
        //     cur = cur.next;
        //     count--;
        // }
        return true;
    }
}