class Solution {
    public int countPoints(String rings) {
        int [] R= new int[10];
        int [] G= new int[10];
        int [] B= new int[10];
        int a;
        int count=0;
        int n=rings.length();

        for(int i=0;i<n;i=i+2){
            a=rings.charAt(i+1)-'0';
            if(rings.charAt(i)== 'R')
                R[a]++;
            else if(rings.charAt(i)== 'G')
                G[a]++;
            else if(rings.charAt(i)== 'B')
                B[a]++;
        }

        for(int i=0;i<10;i++){
            if(R[i]>0 && G[i]>0 && B[i]>0)
                count++;
        }

        return count;
    }
}