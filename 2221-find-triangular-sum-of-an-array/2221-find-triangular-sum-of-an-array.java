class Solution {
   	 public int triangularSum(int[] nums) {
	        int n=nums.length;
	        if (n==1)
	            return nums[0];
	        for(int i=0;i<n-2;i++){
	            int newN=n-(i+1);
	            int newNums [] = new int[newN];
	            for(int j=0;j<newN;j++){
	            	newNums[j]=(nums[j]+nums[j+1])%10;
	            }
	            nums=Arrays.copyOfRange(newNums, 0, newN);
	        }
	        return (nums[0]+nums[1])%10;
	    }
}

/* Optimal approach
class Solution {
    public int triangularSum(int[] nums) {
        return find(nums,nums.length);
    }
    
    public int find(int[] a, int n){
        if(n == 1)
            return a[0];
            
        for(int i=0;i<n-1;i++){
            a[i] = (a[i] + a[i+1])%10; 
        }
        return find(a,n-1);
    }
}
*/