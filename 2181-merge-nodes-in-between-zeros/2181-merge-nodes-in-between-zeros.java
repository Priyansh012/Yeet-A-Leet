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
    public ListNode mergeNodes(ListNode head) {
        ListNode traverse= new ListNode();
        ListNode result=traverse;
        int curSum=0;
        while(head!=null){
            if(head.val==0 && curSum>0){
                traverse.next =new ListNode(curSum);
                traverse=traverse.next; 
                curSum=0;
            }
            
            curSum+=head.val;
            head=head.next;
        }

        return result.next;
    }
}