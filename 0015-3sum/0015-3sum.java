class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int left,right;
        HashSet<List<Integer>> outer = new HashSet<List<Integer>>();
        int sum;
        int n=nums.length;
        if(n==0) return new ArrayList<>(outer);
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            left=i+1;
            right=n-1;
            while(left<right){
                sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                	outer.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;               
               }
                else if(sum<0)
                    left++;
                else if(sum>0)
                    right--;
            }
        }
        return outer.stream().collect(Collectors.toList());
        }
    }

//Optimal Solution
//         public  List<List<Integer>> threeSum(int[] nums) {
//         Set<List<Integer>> res  = new HashSet<>();
//         if(nums.length==0) return new ArrayList<>(res);
//         Arrays.sort(nums);
//         for(int i=0; i<nums.length-2;i++){
//             int j =i+1;
//            int  k = nums.length-1;
//             while(j<k){
//                 int sum = nums[i]+nums[j]+nums[k];
//                 if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
//                 else if (sum >0) k--;
//                 else if (sum<0) j++;
//             }

//         }
//         return new ArrayList<>(res);

//     }