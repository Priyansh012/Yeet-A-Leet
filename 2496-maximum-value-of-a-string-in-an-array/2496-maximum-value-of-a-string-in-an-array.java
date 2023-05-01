class Solution {
    public int maximumValue(String[] strs) {
        int max=Integer.MIN_VALUE;
        int n=strs.length;
        int value;
        for(int i=0;i<n;i++){
            if(strs[i].matches("^[0-9]+$"))
            {
                value=Integer.parseInt(strs[i]);
                max=(value>max) ? value:max;                
            }
            else{
                value=strs[i].length();
                max=(value>max) ? value:max;
            }            
        }

        return max;
    }
}


//Optimal Solution
// class Solution {
//     public int maximumValue(String[] strs) {
//         int ans = 0;
//         for (String s : strs) {
//             ans = Math.max(ans, x(s));
//         }
//         return ans;
//     }

//     private int x(String s) {
//         for (int i = 0; i < s.length(); ++i) {
//             if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
//                 return s.length();
//             }
//         }
//         return Integer.parseInt(s);
//     }
// }
