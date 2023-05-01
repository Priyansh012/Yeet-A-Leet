class Solution {
    public String removeOccurrences(String s, String part) {
        int n=s.length();
        StringBuilder sb = new StringBuilder(s);
        int pos;
        for(int i=0;i<n;i++)
        {   
            pos=sb.indexOf(part);
            if(pos<0)
                return sb.toString();
            sb.replace(pos,pos+part.length(),"");
        }

        return sb.toString();
    }
}