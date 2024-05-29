class Solution {
    int mergeSort(int arr[], int low, int high)
    {   
        int count=0;
        //base case
        if(low>=high)
            return count;
        int mid=(low+high)/2;
        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        //function for count Reverse Pairs before merging each subarrays
        count+=countPairs(arr, low, mid, high);
        merge(arr,low,mid,high);

        return count;
    }
    
    int countPairs(int arr [], int low, int mid, int high){
        int right=mid+1;
        int count=0;
        for(int i=low;i<=mid;i++){
            while(right<=high && (long)arr[i]> (long)(2*(long)arr[right])){
                right++;
            }

            count=count+(right-(mid+1));
        }
        return count;
    }
    void merge(int arr[], int low, int mid, int high)
    {
        List<Integer> temp= new ArrayList<Integer>();
        int left=low;
        int right=mid+1;
        
        while(left<=mid && right<=high){
            if(arr[left]<=arr[right]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
            }
        }
        
        while(left<=mid){
            temp.add(arr[left]);
            left++;
        }
        
        while(right<=high){
            temp.add(arr[right]);
            right++;
        }
        
        for(int i=low; i<=high;i++){
            arr[i]=temp.get(i-low);
        }
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    //Brute Force
    // public int reversePairs(int[] nums) {
    //     int count=0;
    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             long valueI=(long) nums[i];
    //             long valueJ=(long) nums[j];
    //             long twiceValue= (long)(2*valueJ);
    //             if(valueI>twiceValue){
    //                 count+=1;
    //             }
    //         }
    //     }

    //     return count;
    // }
}