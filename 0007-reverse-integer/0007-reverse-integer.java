class Solution {
    public int reverse(int x) {
        int revNum=0;
        int lastDigit=0;
        while(x!=0){
            lastDigit=x%10;
            x=x/10;
            if(revNum>(Integer.MAX_VALUE/10))
                return 0;
            if(revNum<(Integer.MIN_VALUE/10))
                return 0;
            revNum=revNum*10 + lastDigit;
        }

        return revNum;
    }
}