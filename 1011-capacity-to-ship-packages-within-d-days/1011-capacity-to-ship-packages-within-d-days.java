class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int max=0;
        int sum=0;

        for(int val: weights){
            sum+=val;
            max=Math.max(max,val);
        }

        if(n==days)
            return max;
        
        int low=max;
        int high=sum;
        int ans=0;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(isPossible(weights,mid,days,n)){
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }

        return ans;
    }

    public boolean isPossible(int weights [], int mid,int days, int n){
        int curDay=1;
        int curSum=0;
        for(int i=0;i<n;i++){
            curSum+=weights[i];

            if(curSum>mid){
                curDay+=1;
                curSum=weights[i];
            }
        }

        return (curDay<=days);
    }
}