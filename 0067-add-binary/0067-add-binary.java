class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res= new StringBuilder();
        StringBuilder A= new StringBuilder(a);
        StringBuilder B = new StringBuilder(b);
        int carry=0, digitA=0, digitB=0, total=0;
        String tempAns="";
        A=A.reverse();
        B=B.reverse();
        
        for(int i=0;i<Math.max(A.length(), B.length()); i++){
            digitA= i<A.length()? A.charAt(i)-'0': 0;
            digitB= i<B.length()? B.charAt(i)-'0': 0;
            total = digitA+digitB+carry;
            tempAns= Integer.toString(total%2);
            res.insert(0,tempAns);
            carry=total/2;
        }
        if(carry!=0)
            res.insert(0,"1");
        
        return res.toString();
        
    }
}