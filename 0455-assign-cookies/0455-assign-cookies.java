class Solution {
    public int findContentChildren(int[] g, int[] s) {
       Arrays.sort(g);
       Arrays.sort(s);

       int childCount=0;
       int i=0;

       while(childCount<g.length && i<s.length){
            if(s[i]>=g[childCount])
                childCount+=1;
            i++;
       }

       return childCount;
    }
}