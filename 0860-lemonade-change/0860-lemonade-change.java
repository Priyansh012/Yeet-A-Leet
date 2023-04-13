class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives=0;
        int tens=0;

        for(int bill:bills){
            if(bill==5)
                fives+=1;
            
            else if(bill==10){
                tens+=1;
                fives-=1;
            }

            //if customer gives 20 dollar bill then 2 scenarios
            else if(tens>0){
                tens-=1;
                fives-=1;
            }
            else{
                fives-=3;
            }

            if(fives<0)
            return false;
        }
        
        return true;
    }
}