class Solution {
    public String reformatNumber(String number) {
        String newNumber = number.replaceAll("[- ]", "");
        StringBuilder sb = new StringBuilder(newNumber);
        StringBuilder result = new StringBuilder();
        int n=sb.length();

        while(n>4){
            result.append(sb.substring(0, 3));
            sb.delete(0,3);
            result.append("-");
            n=sb.length();
        }

        if(n==4){
           result.append(sb.substring(0, 2));
           result.append("-");
           result.append(sb.substring(2)); 
        }

        else{
            result.append(sb.substring(0));
        }

        return result.toString();
    }
}