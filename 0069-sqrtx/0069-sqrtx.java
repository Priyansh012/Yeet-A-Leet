class Solution {
    public int mySqrt(int x) {
        int left=0, right=x;
        if(x==0)
            return 0;
        if(x==1)
            return 1;

        while(left<right){
            int mid=left+(right-left)/2;
            //condition for our binary search template
            if ((long) mid * mid <= x)
                left=mid+1;
            else
                right=mid;
        }

        return left-1;
    }
}