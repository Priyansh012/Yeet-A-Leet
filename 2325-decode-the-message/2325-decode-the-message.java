class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char [] msg= message.toCharArray();
        int letter=97;
        int temp=0;
        key=key.replace(" ","");
        System.out.println(key);
        for(int i=0;i<key.length();i++){
            if(!map.containsKey(key.charAt(i))){
                map.put(key.charAt(i), letter);
                letter=letter+1;
            }
        }
        System.out.print(map);
        for(int i=0;i<msg.length;i++){
            if(msg[i]!=' '){
                temp= map.get(msg[i]);
                msg[i] = (char) temp;
            }
        }
        return String.copyValueOf(msg);
    }
}