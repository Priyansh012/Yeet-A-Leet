class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        //sb.append("1");
        for(int i=0;i<n;i++){
            int j=0;
            int count=1;
            String temp=sb.toString();
            sb.setLength(0);
            while(j<temp.length()){
                char c=temp.charAt(j);
                j++;
                while(j<temp.length() && c==temp.charAt(j)){
                    count++;
                    j++;
                }
                //sb.setLength(0);
                sb.append((char)(count+'0'));
                sb.append(c);
                count=1;
            }
            if(temp.length()==0)
                sb.append("1");
            System.out.println(sb.toString());
        }
        return sb.toString();
    }
}