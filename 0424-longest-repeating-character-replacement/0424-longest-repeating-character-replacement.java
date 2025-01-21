class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        int left = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            // Update maxFrequency to store the highest frequency of any character in the current window
            maxFrequency = Math.max(maxFrequency, map.get(c));

            // If the remaining characters to be replaced exceed k, shrink the window
            while ((right - left + 1) - maxFrequency > k) {
                char l = s.charAt(left);
                map.put(l, map.get(l) - 1);
                left++;
            }

            // Update the result to reflect the maximum window size seen so far
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}