class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        int n= s.length();

        if(n%2!=0)
            return false;

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            }

            else{
                if(st.isEmpty())
                    return false;
                char remove = st.pop();
            
                if((c==')' && remove!='(') || (c=='}' && remove!='{') || (c==']' && remove!='['))
                    return false;
            }
        
        }   

        if(st.isEmpty())
            return true;
        
        return false;
    }
}