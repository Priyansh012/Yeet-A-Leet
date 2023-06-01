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
    public ListNode removeNodes(ListNode head) {
    
        int count=0;
        ListNode traverse = head;
        ArrayList<Integer> nodeValList = new ArrayList<Integer>();
        if(head.next==null)
            return head;


        while(traverse!=null){
            count=count+1;
            nodeValList.add(traverse.val);
            traverse=traverse.next;
        }
        int nodeValArray []= new int [count];
        for(int i=0;i<count;i++){
            nodeValArray[i]= nodeValList.get(i);
        }
        int max [] = new int [count];
        max[count-1]=nodeValArray[count-1];
        for(int i=count-2;i>=0;i--){
            max[i]=Math.max(nodeValArray[i],max[i+1]);
        }
        traverse=head;
        ListNode prev=head;
        for(int i=0;i<count;i++){
            if(max[i]>traverse.val && traverse==head){
                head=head.next;
                prev=head;
                traverse=head;
            }
            else if(max[i]>traverse.val && traverse!=head){
                prev.next=traverse.next;
                traverse=traverse.next;
            }
            else{
                prev=traverse;
                traverse=traverse.next;
            }
        }

        return head;
    }
}