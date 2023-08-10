class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long val=(long)m*k;
        int n=bloomDay.length;
        
        //impossible case
        if(val>n)
            return -1;
        
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;

        //find min and max from array
        for(int i=0;i<n;i++){
            mini=Math.min(bloomDay[i], mini);
            maxi=Math.max(bloomDay[i], maxi);
        }

        //apply binary search
        int low=mini, high=maxi;
        while(low<=high){
            int mid=(low+high)/2;
            //call poss to check if its possible to make m bouq from the garden
            if(possible(bloomDay, mid, m,k))
                high=mid-1;
            else
                low=mid+1;
        }

        return low;
    }

    public boolean possible(int [] arr, int day, int m, int k){
        int n=arr.length;
        int count=0;
        int noOfBoq=0;

        for(int i=0;i<n;i++){
            if(arr[i]<=day){
                count+=1;
            }
            else{
                noOfBoq+=(count/k);
                count=0;
            }
        }
        noOfBoq+=(count/k);
        return noOfBoq>=m;
    }
}