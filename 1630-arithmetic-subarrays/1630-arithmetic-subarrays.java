class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m=l.length;
        List<Boolean> result = new ArrayList<Boolean>();
        for(int i=0;i<m;i++){
            ArrayList<Integer> list = new ArrayList<Integer>();
            int seqFlag=0;
            int n=r[i]+1;
            for(int j=l[i];j<n;j++){
                list.add(nums[j]);
            }
            Collections.sort(list);
            int delta=Math.abs(list.get(1))-Math.abs(list.get(0));
            for(int k=1;k<list.size()-1;k++){
                seqFlag=0;
                if((Math.abs(list.get(k+1))-Math.abs(list.get(k)))!=delta){
                    seqFlag=1;
                    result.add(false);
                    break;
                }
            }
            if(seqFlag==0){
                result.add(true);
            }
        }  

        return result; 
    }
}