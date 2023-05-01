class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int temp=capacity;
        int steps=0;
        int n=plants.length;
        int flag=0;
        for(int i=0;i<n;i++){
            if(plants[i]<=temp){
                temp=temp-plants[i];
                if(flag==0)
                    steps++;
                else{
                    steps=steps+i+1;
                    flag=0;
                }    
                
            }
            else{
                temp=capacity;
                steps=steps+i;
                i=i-1;
                flag=1;
            }
        }

        return steps;
    }
}