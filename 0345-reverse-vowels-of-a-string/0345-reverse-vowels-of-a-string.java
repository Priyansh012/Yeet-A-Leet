class Solution {
    public String reverseVowels(String s) {
        List<Character> vowelsList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        vowelsList.add('a');
        vowelsList.add('e');
        vowelsList.add('i');
        vowelsList.add('o');
        vowelsList.add('u');

        int i=0, j=s.length()-1;
        boolean flagI, flagJ;
        char temp;
        while(i<j){
            if(vowelsList.contains(Character.toLowerCase(s.charAt(i)))){
                flagI=true;
            }
            else{
                i++;
                flagI=false;
            }

            if(vowelsList.contains(Character.toLowerCase(s.charAt(j)))){
                flagJ=true;
            }
            else{
                j--;
                flagJ=false;
            }

            if(flagI && flagJ){
                temp=s.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                flagI=flagJ=false;
                j--;
                i++;
            }

        }
        return sb.toString();
    }
}

/* Better approach with the two pointers
 run two while loops inside the main while loop to find the vowels from both the ends
 then swap them
public class Solution {
public String reverseVowels(String s) {
    if(s == null || s.length()==0) return s;
    String vowels = "aeiouAEIOU";
    char[] chars = s.toCharArray();
    int start = 0;
    int end = s.length()-1;
    while(start<end){
        
        while(start<end && !vowels.contains(chars[start]+"")){
            start++;
        }
        
        while(start<end && !vowels.contains(chars[end]+"")){
            end--;
        }
        
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
        
        start++;
        end--;
    }
    return new String(chars);
}
*/