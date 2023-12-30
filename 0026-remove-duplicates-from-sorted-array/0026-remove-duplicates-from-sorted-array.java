class Solution {
    //BruteForce
    /*public int removeDuplicates(int[] nums) {
        List<Integer> numsList = new ArrayList<>();
        int left=0;
        int right=0;
        if(nums.length==1)
            return 1;
        
        right+=1;
        while(right<nums.length){
            if(nums[left]!=nums[right]){
                numsList.add(nums[left]);
                left=right;
            }
            else{
                left+=1;
            }
            right+=1;
        }
        numsList.add(nums[right-1]);

        for(int i=0;i<numsList.size();i++){
            nums[i]=numsList.get(i);
        }
        return numsList.size();
    }*/

    //Better
    /*public int removeDuplicates(int[] nums) {
        int left=0;
        int right=0;
        int count=1;
        if(nums.length==1)
            return 1;
        
        right+=1;
        while(right<nums.length){
            if(nums[left]!=nums[right]){
                nums[left+1]=nums[right];
                if(left+1 !=right)
                    nums[right]=-101;
                left+=1;
                count+=1;
            }
            right+=1;
            
        }

        return count;
    }*/

    //Optimal
    public int removeDuplicates(int[] arr) {
        int i=0;
        for(int j=1;j<arr.length;j++){
            if(arr[i]!=arr[j]){
                i++;
                arr[i]=arr[j];
            }
        }
        return i+1;
        
    }

}