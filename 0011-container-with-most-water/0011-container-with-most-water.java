class Solution {
    public int maxArea(int[] height) {
        int left=0, right=height.length-1;
        int water=0;
        while(left<right){
            int currentWater=(right-left)*Math.min(height[left], height[right]);
            water=Math.max(water, currentWater);
            if(height[left]<=height[right])
                left+=1;
            
            else
                right-=1;
        }

        return water;
    }
}