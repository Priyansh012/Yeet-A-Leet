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

    //Bruteforce
    // public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    //     ListNode cur1 = list1;
    //     ListNode cur2 = list2;
    //     ListNode mergedListHead = null;
        
    //     if(cur1!=null && cur2!=null){
    //         if(cur1.val<=cur2.val){
    //             mergedListHead=cur1;
    //             cur1=cur1.next;
    //         }
        
    //         else{
    //             mergedListHead=cur2;
    //             cur2=cur2.next;
    //         }
    //     }

    //     else if(cur1==null && cur2!=null){
    //         mergedListHead=cur2;
    //         cur2=cur2.next;
    //     }

    //     else if(cur1!=null && cur2==null){
    //         mergedListHead=cur1;
    //         cur1=cur1.next;
    //     }

    //     else{
    //         return mergedListHead;
    //     }

    //     ListNode mainPointer = mergedListHead;
    //     while(cur1!=null && cur2!=null){
    //         if(cur1.val <= cur2.val){
    //             mainPointer.next=new ListNode(cur1.val);
    //             mainPointer=mainPointer.next;
    //             cur1=cur1.next;
    //         }
    //         else{
    //             mainPointer.next=new ListNode(cur2.val);
    //             mainPointer=mainPointer.next;
    //             cur2=cur2.next;
    //         }
    //     }

    //     if(cur1==null && cur2!=null){
    //         while(cur2!=null){
    //             mainPointer.next=new ListNode(cur2.val);
    //             mainPointer=mainPointer.next;
    //             cur2=cur2.next;
    //         }
    //     }

    //     else if(cur1!=null && cur2==null){
    //         while(cur1!=null){
    //             mainPointer.next=new ListNode(cur1.val);
    //             mainPointer=mainPointer.next;
    //             cur1=cur1.next;
    //         }
    //     }

    //     return mergedListHead;
    // }

    //Optimal
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null)
            return list2;
        
        if(list2==null)
            return list1;

        //ensure l1 points to this list with the smallest value
        if(list1.val>list2.val){
            ListNode temp=list1;
            list1=list2;
            list2=temp;
        }

        ListNode head=list1;
    
        while(list1!=null && list2!=null){

            //temp always stores the previous node so that
            // we can point easily the next node
            ListNode temp=null;

            //iterate until list1's elements are greater than list2's elements
            while(list1!=null && list1.val<=list2.val){
                temp=list1;
                list1=list1.next;
            }

            //list2 found smaller so point previous pointer to current list2
            //and now start all over again with list2
            temp.next=list2;

            //but for us list1 will always move so lets swap list1 with list2
            ListNode NewTemp=list1;
            list1=list2;
            list2=NewTemp;

        }
        
        return head;
    }
}