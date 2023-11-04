class Solution {
    public boolean canBeEqual(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        sb.append(s1);
        for(int i=0;i<2;i++){
            char temp=sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i+2));
            sb.setCharAt(i+2, temp);
            if(sb.toString().equals(s2))
                return true;
        }

        for(int i=0;i<2;i++){
            char temp=sb.charAt(i);
            sb.setCharAt(i, sb.charAt(i+2));
            sb.setCharAt(i+2, temp);
            if(sb.toString().equals(s2))
                return true;
        }
        return false;
    }
}