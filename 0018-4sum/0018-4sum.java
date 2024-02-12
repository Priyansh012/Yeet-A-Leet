class Solution {
    //Bruteforce 
    //TLE
    /*public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> result = new HashSet<>();
        int n=nums.length;
        int sum;
        if(nums.length<4)
            return new ArrayList<>();
        
        for(int i=0;i<n;i++){
            for(int j=i+1; j<n; j++){
                for(int k=j+1; k<n;k++){
                    for(int l=k+1;l<n; l++){
                        if(nums[i]+nums[j]+nums[k]+nums[l]==target){
                            List<Integer> quadruplets = new ArrayList<>();
                            quadruplets.add(nums[i]);
                            quadruplets.add(nums[j]);
                            quadruplets.add(nums[k]);
                            quadruplets.add(nums[l]);
                            Collections.sort(quadruplets);
                            result.add(quadruplets);
                        }
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(result);
        return res;
        
    }*/

    //Optimal
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //keep i & j as constants and do two pointers approach for k and l
        //then move i and j after every iteration but check if nums[i]!=nums[i-1]
        //same for nums[j] that is done to remove the duplicate element checks in a sorted array
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<n;j++){
                if(j>(i+1) && nums[j]==nums[j-1]){
                    continue;
                }
                // two pointers
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum=nums[i];
                    sum+=nums[j];
                    sum+=nums[k];
                    sum+=nums[l];
                    if(sum==target){
                        List<Integer> quadruplet= new ArrayList<>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[k]);
                        quadruplet.add(nums[l]);
                        result.add(quadruplet);
                        k++;
                        l--;
                        //skip duplicates for nums[k]
                        while(k<l && nums[k]==nums[k-1]){
                            k++;
                        }
                        //skip duplicates for nums[l]
                        while(k<l && nums[l]==nums[l+1]){
                            l--;
                        }
                    }
                    //increase k since its a sorted array
                    else if(sum<target){
                        k++;
                    }

                    //decrease l(sum>target) since its a sorted array
                    else{
                        l--;
                    }
                }

            }
        }       
        return result;
    }
}