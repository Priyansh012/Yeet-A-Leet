class Solution {
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack();
        Stack<String> strStack = new Stack();
        String str = "";
        int num=0;

        for(char c: s.toCharArray()){
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            else if(c=='['){
                strStack.push(str);
                countStack.push(num);
                num=0;
                str="";
            }
            else if(c==']'){
                int repeatTimes=countStack.pop();
                StringBuilder temp= new StringBuilder(strStack.pop());
                for(int i=0;i<repeatTimes;i++){
                    temp.append(str);
                }
                str=temp.toString();
            }

            else{
                str+=c;
            }
        }

        return str;
    }
}