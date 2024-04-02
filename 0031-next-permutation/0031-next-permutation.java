class Solution {
    //Bruteforce solution will be
    //1) Generate all the permutations via recursion and store it(N!)
    //2) Then do a linear search to find the current array in the list of permutation(N)
    //3) Return the next permutation after finding the current array in the list of permutation(1)
    //TC: O(N!N)

    //Optimal
    public void nextPermutation(int[] nums) {
        //find the breakpoint index through which the dip appears
        //start from n-2 because we cant compare nth element with anyone else
        int n=nums.length;
        int breakpointIndex=-1;
        for(int i=n-2; i>=0;i--){
            if(nums[i]<nums[i+1]){
                breakpointIndex=i;
                break;
            }
        }

        //array is at its highest permutation so the next permutation will be the lowest permutation
        //so sort the array in reverse
        if(breakpointIndex==-1){
            //write reverse logic
            reverse(nums, 0);
        }
        //Replace the breakpoint index's element with the next highest element number(which will be in the increasing order from the back)
        else{
            for(int i=n-1;i>=breakpointIndex;i--){
                if(nums[i]>nums[breakpointIndex]){
                    swap(nums, i, breakpointIndex);
                    break;
                }
            }
            //sort in reverse order, the elements from the breakpoint to n
            reverse(nums, breakpointIndex+1);
        }
        
    }

    public void swap(int [] nums, int a, int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public void reverse(int[] arr, int a) {
        int start = a;
        int end = arr.length-1;
        
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}