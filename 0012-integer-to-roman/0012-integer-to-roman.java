class Solution {
    public String intToRoman(int num) {
        int Intvalues [] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String Romvalues [] = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX","V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();  
        for(int i=0;i<Intvalues.length;i++)   
        {  
            while(num >= Intvalues[i]){
                num-=Intvalues[i];
                roman.append(Romvalues[i]);
            }
            
        }
        
        return roman.toString();
    }
}
    