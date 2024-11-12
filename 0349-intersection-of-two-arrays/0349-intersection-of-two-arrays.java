class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        int left=0, right=0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while(left!=nums1.length && right!=nums2.length){
            if(nums1[left]==nums2[right]){
                result.add(nums1[left]);
                left++;
                right++;
            }
            else if(nums1[left]<nums2[right]){
                left++;
            }

            else if(nums2[right]<nums1[left]){
                right++;
            }
        }
        int[] ans = new int[result.size()];
        int k = 0;
        for (Integer num : result) {
            ans[k++] = num;
        }
        return ans;
    }
}