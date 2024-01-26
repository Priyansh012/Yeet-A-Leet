/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    //space complexity O(N)
    /*public ListNode detectCycle(ListNode head) {
        ListNode cur=head;
        Map<ListNode, Integer> nodeCount = new HashMap<>();
        if(cur==null || cur.next==null)
            return null;
        while(cur.next!=null){
            nodeCount.put(cur, nodeCount.getOrDefault(cur,0)+1);
            if(nodeCount.get(cur)>1)
                return cur;
            cur=cur.next;
        }

        return null;
    }*/

    //space complexity: O(1)
    //slow and fast and l1+d intution
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            //cycle detected
            if(fast==slow){
                slow=head;
                //find the starting point of cycle
                while(fast!=slow){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;

            }
        }

        return null;
    }
}