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

 //Bruteforce O(N^2)
// class Solution {
//     public int[] nextLargerNodes(ListNode head) {
//         ListNode cur=head;
//         List<Integer> result = new ArrayList<>();
//         while(cur!=null){
//             ListNode tempHead=cur.next;
//             int max=cur.val;
//             while(tempHead!=null){
//                 if(tempHead.val>max){
//                     max=tempHead.val;
//                     break;
//                 }
//                 tempHead=tempHead.next;
//             }
//             max=(max==cur.val)?0:max;
//             result.add(max);
//             cur=cur.next;
//         }

//         int[] arr = new int[result.size()];
//         for (int i = 0; i < result.size(); i++) {
//             arr[i] = result.get(i);
//         }
//         return arr;
//     }
// }


//Optimal O(N)
//convert linkedlist to array and take it like monotonic stack(next largerst element in an array)
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        
        int n = values.size();
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && values.get(stack.peek()) < values.get(i)) {
                answer[stack.peek()] = values.get(i);
                stack.pop();
            }
            stack.add(i);
        }
        return answer;
    }
}