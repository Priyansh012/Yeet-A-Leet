class Solution {
    public String sortSentence(String s) {
        String arr[] = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j].contains(Integer.toString(i+1))){
                    result.append(arr[j].substring(0,arr[j].length()-1));
                    if(i<=arr.length-2){
                        result.append(" ");
                    }
                    break;
                }
            }
        }
        return result.toString();
    }
}