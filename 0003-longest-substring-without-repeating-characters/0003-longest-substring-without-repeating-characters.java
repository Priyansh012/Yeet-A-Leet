class Solution {

    //Bruteforce
    /*public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> characterToCount = new HashMap<Character, Integer>();
        int left;
        int max=0;
        int count;
        int n=s.length();
        int right;
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        for(left=0;left<n-1;left++){
            characterToCount.put(s.charAt(left),1);
            count=1;
            right=left+1;
            while(!characterToCount.containsKey(s.charAt(right))){
                characterToCount.put(s.charAt(right),1);
                count++;
                right++;
                if(right>n-1)
                    break;
            }
            if(max<count)
                max=count;
            characterToCount.clear();
        }

        return max;
    }*/

    //Better
   /* public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0, count=0, max=0;
        int n=s.length();
        HashMap<Character, Integer> characterIndex = new HashMap<Character, Integer>();

        if(n==1)
            return 1;
        while(left<=right && right<n){
            if(!characterIndex.containsKey(s.charAt(right))){
                characterIndex.put(s.charAt(right), right);
                count+=1;
            }

            else{
                left=characterIndex.get(s.charAt(right))+1;
                count=right-left+1;
                characterIndex.put(s.charAt(right), right);
            }
            max=Math.max(count, max);
            right+=1;
        }

        return max;
    }*/

    //Optimal with slight tweak
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0, max=0;
        int n=s.length();
        HashMap<Character, Integer> characterIndex = new HashMap<Character, Integer>();

        while(right<n){
            if(characterIndex.containsKey(s.charAt(right))){
                //slide left
                left=Math.max(characterIndex.get(s.charAt(right))+1, left);
            }

            //put unique elements from the substring into the map
            characterIndex.put(s.charAt(right), right);
            //update max by comparing current length of substring with the old max
            max=Math.max(max, right-left+1);

            right+=1;

        }

        return max;
    }
}