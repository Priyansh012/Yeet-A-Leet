class Solution {
    public int distinctIntegers(int n) {
        Set<Integer> set = new HashSet<>();
        int x=n;
        set.add(n);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=x;j++){
                if(x%j==1)
                    set.add(j);
            }
            x=x-1;            
        }

        return set.size();
    }
}