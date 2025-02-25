class Solution {
    public String largestNumber(int[] nums) {
        // Convert numbers to string
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom sorting: If (x + y) > (y + x), x should come first
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: If the largest number is "0", return "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Build result string
        StringBuilder result = new StringBuilder();
        for (String num : strNums) {
            result.append(num);
        }

        return result.toString();
    }
}