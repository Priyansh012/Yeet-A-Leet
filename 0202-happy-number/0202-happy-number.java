class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int loopCheckSum=0;
        int currentSum;

        if(n==1 || n==7)
            return true;
        
        while(n!=1){
            currentSum=0;
            while(n!=0){
                int digit=n%10;
                currentSum +=digit*digit;
                n=n/10;
            }

            if(!set.add(currentSum))
                return false;
            
            n=currentSum;
        }

        return true;
    }
}