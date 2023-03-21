/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode intersect = new ListNode();
        ListNode traverseA= headA;
        ListNode traverseB= headB;
        int countA=0;
        int countB=0;

        while(traverseA!=null){
            countA+=1;
            traverseA=traverseA.next;
        }

        while(traverseB!=null){
            countB+=1;
            traverseB=traverseB.next;
        }
        
        traverseA= headA;
        traverseB= headB;
        int tempCount=Math.abs(countA-countB);
        
        while(tempCount!=0){
            if(countA<countB)
                traverseB=traverseB.next;
            else
                traverseA=traverseA.next;
            tempCount-=1;
        }
        
        while(countA>0){
            if(traverseA==traverseB){
                intersect=traverseA;
                return intersect;
            }
            traverseB=traverseB.next;
            traverseA=traverseA.next;
            countA-=1;
        }

        return null;
    }
}