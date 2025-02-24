class Solution {
    public int myAtoi(String s) {
        //edge case for empty string
        int index=0, total=0, sign=1;
        if(s.length()==0)
            return 0;

        //remove white space
        while(index<s.length() && s.charAt(index)==' ')
            index+=1;
        
        //edge case if only whitespace are passed
        if(index==s.length())
            return 0;

        if(s.charAt(index)=='-' || s.charAt(index)=='+'){
            sign=s.charAt(index)=='-'?-1:1;
            index++;
        }

        while(index<s.length())
        {
            int digit=s.charAt(index)-'0';

            //if digit is not a whole number
            //end becaue non-digit char is encountered
            if(digit<0 || digit>9)
                break;
            
            //32-bit boundary check
            if(Integer.MAX_VALUE/10 <total || 
            (Integer.MAX_VALUE/10== total && Integer.MAX_VALUE % 10 < digit))
                return sign==1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            
            //multiply by 10 so that digits are separated by unit values
            total=total*10+digit;
            index++;
        }
            
        return total*sign;
    }
}