class Solution {
    public int maximum69Number (int num) {
        String temp = Integer.toString(num);

        for(int i=0;i<temp.length();i++){
            if(temp.charAt(i)=='6'){
                temp=temp.substring(0, i) + '9'+ temp.substring(i + 1);
                break;
            }
        }
        return Integer.valueOf(temp);
    }
}