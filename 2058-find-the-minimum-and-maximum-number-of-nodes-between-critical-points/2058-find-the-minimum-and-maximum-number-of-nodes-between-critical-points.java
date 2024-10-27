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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode node = prev.next;
        int result [] = new int [] {-1,-1};
        if(prev==null || node==null){
            return result;
        }

        List<Integer> criticalPointsList = new ArrayList<>();
        int i=1;
        while(node.next!=null){
            if((prev.val<node.val && node.next.val<node.val) || (prev.val>node.val && node.next.val>node.val)){
                criticalPointsList.add(i);
            }
            i+=1;
            prev=node;
            node=node.next;
        }

        if(criticalPointsList.size()<2){
            return result;
        }

        result[0]= Integer.MAX_VALUE;
        result[1]= criticalPointsList.get(criticalPointsList.size()-1) - criticalPointsList.get(0);
        int localMinima=0;
        for(int j=0;j<criticalPointsList.size()-1;j++){
            localMinima=criticalPointsList.get(j+1)-criticalPointsList.get(j);
            if(localMinima<result[0]){
                result[0]=localMinima;
            }
        }

        return result;
    }
}