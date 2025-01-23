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
import java.math.BigInteger;

class Solution {
    public ListNode doubleIt(ListNode head) {
        ListNode node = head;
        StringBuffer sb = new StringBuffer();
        
        while (node != null) {
            sb.append(node.val);
            node = node.next;
        }

        BigInteger num = new BigInteger(sb.toString());
        
        num = num.multiply(BigInteger.valueOf(2));

        String result = num.toString();

        ListNode lastNode = new ListNode(result.charAt(result.length() - 1) - '0');
        ListNode currentNode = lastNode;

        for (int i = result.length() - 2; i >= 0; i--) {
            ListNode temp = new ListNode(result.charAt(i) - '0');
            temp.next = currentNode;
            currentNode = temp;
        }

        return currentNode;  
    }
}
