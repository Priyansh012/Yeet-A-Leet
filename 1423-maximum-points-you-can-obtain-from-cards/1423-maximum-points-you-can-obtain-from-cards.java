class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int left=0, right=n-k;
        int total=0;
        for(int i=right;i<n;i++){
            total+=cardPoints[i];
        }
        int res=total;

        while(right<n){
            total+=(cardPoints[left]-cardPoints[right]);
            res=Math.max(res,total);
            left+=1;
            right+=1;
        }

        return res;
    }
}