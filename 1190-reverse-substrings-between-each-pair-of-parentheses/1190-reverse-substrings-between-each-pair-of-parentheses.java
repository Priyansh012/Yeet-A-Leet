class Solution {

    //Bruteforce O(n^2)
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                st.push(sb.length());
            }

            else if(s.charAt(i)==')'){
                int startIndex = st.pop();
                reverse(startIndex, sb.length()-1, sb);
            }

            else{
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    void reverse(int start, int end, StringBuilder sb){
        while(start<end){
            Character temp=sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}