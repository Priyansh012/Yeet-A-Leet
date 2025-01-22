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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode node=head;
        int gcdValue=0;

        while(node.next!=null){
            int a=node.val;
            int b=node.next.val;
            gcdValue=findGCD(a,b);
            
            ListNode gcdNode= new ListNode(gcdValue);
            ListNode temp=node.next;
            node.next=gcdNode;
            gcdNode.next=temp;
            node=node.next.next;
        }

        return head;
    }

    //Euclidean GCD approach
    private int findGCD(int a, int b){
        while(b!=0){
            int remainder=a%b;
            a=b;
            b=remainder;
        }

        return a;
    }
}