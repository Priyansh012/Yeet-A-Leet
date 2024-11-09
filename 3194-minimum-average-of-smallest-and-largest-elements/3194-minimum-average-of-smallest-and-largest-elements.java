class Solution {
    public double minimumAverage(int[] nums) {
        int left=0, right=nums.length-1;
        List<Integer> noms = new ArrayList<>(nums.length);
        double result = Double.MAX_VALUE;
        for(int i:nums){
            noms.add(i);
        }

        Collections.sort(noms);
        while(left<right){
            result=Math.min(result,(double)(noms.get(left)+noms.get(right))/2);
            left++;
            right--;
        }


        return result;
        
    }
}