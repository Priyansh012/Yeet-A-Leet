class Solution {

    //Bruteforce-- expect TLE
    //TC-O(N)
    /*public double myPow(double x, int n) {
        double ans=1D;
        long newN=(long) n;
        newN=Math.abs(newN);
        for(long i=0;i<newN;i++){
            ans=ans*x;
        }

        if(n<0)
            return 1/ans;
        return ans;
    }*/

    //Optimal solution
    //TC: O(logN)
    public double myPow(double x, int n) {
        double ans=1D;
        long newN=(long) n;
        newN=Math.abs(newN);

        while(newN>0){
            if(newN%2==0){
                //basically 2^10 can be written as (2*2)^5
                //where x=2 is multiplied by itself whilst
                // n=10 is reduced or basically divided by 2 
                x=x*x;
                newN=newN/2;
            }
            else{
                //basically 4^5 can be written as 4*(4^4)
                //where x=4 is getting multiplied by x^(n-1)
                ans=ans*x;
                newN=newN-1;
            }
        }
        if(n<0)
            return 1/ans;
        
        return ans;
    }
}