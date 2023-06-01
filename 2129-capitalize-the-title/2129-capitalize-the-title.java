class Solution {
    public String capitalizeTitle(String title) {
        String temp [] = title.split(" ");
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<temp.length;i++){
            temp[i]=temp[i].toLowerCase();
            if(temp[i].length()>2)
                temp[i]=temp[i].substring(0,1).toUpperCase()+temp[i].substring(1);
            sb.append(temp[i]);
            if(i<temp.length-1)
                sb.append(" ");

        }

        return sb.toString();
    }
}