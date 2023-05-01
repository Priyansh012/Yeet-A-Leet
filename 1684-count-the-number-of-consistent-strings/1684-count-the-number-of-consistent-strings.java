class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        ArrayList<Character> list = new ArrayList<Character>();
        int n=words.length;
        int flag=0;
        int count=0;
        for(int i=0;i<allowed.length();i++){
            list.add(allowed.charAt(i));
        }

        for(int i=0;i<n;i++){
            flag=0;
            for(int j=0;j<words[i].length();j++){
                if(!list.contains(words[i].charAt(j))){
                    flag=1;
                    break;
                }
            }
            if(flag==0)
                count++;
        }

        return count;
    }
}

//My Solution
// public int countConsistentStrings(String allowed, String[] words) {
//         int counter = 0;
//         for (String s : words) {
//             boolean isValid = true;
//             for (char ch : s.toCharArray()) {
//                 if (!allowed.contains(String.valueOf(ch))) {
//                     isValid = false;
//                 }
//             }
//             if (isValid) counter++;
//         }

//         return counter;
//     }
