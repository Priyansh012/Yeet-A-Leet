class Solution {
    public List<List<Integer>> generate(int numRows) {
ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        int temp;
        for(int i=0;i<numRows;i++){
            ArrayList<Integer> curList = new ArrayList<Integer>();
            for(int j=0;j<i+1;j++){
                if(j==0 || j==i)
                    curList.add(1);
                else{
                    temp=result.get(i-1).get(j-1)+result.get(i-1).get(j);
                    curList.add(temp);
                }
            }
            result.add(curList);
            //curList.clear();
        }

        return result;

    }
}