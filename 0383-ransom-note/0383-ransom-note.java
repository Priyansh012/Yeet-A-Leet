class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> magCharsToCount = new HashMap<Character, Integer>();
        HashMap<Character, Integer> ranCharsToCount = new HashMap<Character, Integer>();
        for(int i=0;i<magazine.length();i++){
            magCharsToCount.put(magazine.charAt(i), magCharsToCount.getOrDefault(magazine.charAt(i),0)+1);
        }

        for(int i=0;i<ransomNote.length();i++){
            ranCharsToCount.put(ransomNote.charAt(i), ranCharsToCount.getOrDefault(ransomNote.charAt(i),0)+1);
        }

        for(int i=0;i<ransomNote.length();i++){
            if((!magCharsToCount.containsKey(ransomNote.charAt(i))) || (magCharsToCount.get(ransomNote.charAt(i))<ranCharsToCount.get(ransomNote.charAt(i))))
                return false;
        }

        return true;        
    }
}

//Optimal Solution
// class Solution {
//     public boolean canConstruct(String ransomNote, String magazine) {
// 		if (ransomNote.length() > magazine.length()) return false;
//         int[] alphabets_counter = new int[26];
        
//         for (char c : magazine.toCharArray())
//             alphabets_counter[c-'a']++;

//         for (char c : ransomNote.toCharArray()){
//             if (alphabets_counter[c-'a'] == 0) return false;
//             alphabets_counter[c-'a']--;
//         }
//         return true;
//     }
// }