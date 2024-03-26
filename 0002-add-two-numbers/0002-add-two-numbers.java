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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode cur1= l1;
        ListNode cur2= l2;
        int carry=0;
        int currentSum=0;
        int initialAddition=cur1.val+cur2.val;
        ListNode result=null;
        if(initialAddition<=9)
            result=new ListNode(initialAddition);
        
        else{
            carry= initialAddition/10;
            result= new ListNode(initialAddition%10);
        }
        cur1=cur1.next;
        cur2=cur2.next;

        ListNode temp=result;
        
        while(cur1!=null && cur2!=null){
            currentSum=0;
            if(carry>0){
                currentSum=cur1.val+cur2.val+carry;
            }
            else{
                currentSum=cur1.val+cur2.val;
                carry=0;
            }
            if(currentSum<=9){
                temp.next=new ListNode(currentSum);
                carry=0;
            }

            else{
                carry=currentSum/10;
                temp.next= new ListNode(currentSum%10);
            }
            temp=temp.next;
            cur1=cur1.next;
            cur2=cur2.next;
        }

        if(cur2==null){
            currentSum=0;
            while(cur1!=null){
                if(carry>0){
                    currentSum=cur1.val+carry;
                }
                else{
                    currentSum=cur1.val;
                    carry=0;
                }
                if(currentSum<=9){
                    temp.next=new ListNode(currentSum);
                    carry=0;
                }

                else{
                    carry=currentSum/10;
                    temp.next= new ListNode(currentSum%10);
                }
                temp=temp.next;
                cur1=cur1.next;
            }
        }

        else if(cur1==null){
            currentSum=0;
            while(cur2!=null){
                if(carry>0){
                    currentSum=cur2.val+carry;
                }
                else{
                    currentSum=cur2.val;
                    carry=0;
                }
                if(currentSum<=9){
                    temp.next=new ListNode(currentSum);
                    carry=0;
                }

                else{
                    carry=currentSum/10;
                    temp.next= new ListNode(currentSum%10);
                }
                temp=temp.next;
                cur2=cur2.next;
            }
        }

        if(carry>0){
            temp.next= new ListNode(carry);
        }

        return result;
    }
}