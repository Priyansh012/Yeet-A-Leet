class Solution {

    public boolean isNumeric(String s){
        try{
            Integer.parseInt(s);
            return true;

        }catch (NumberFormatException e){
            return false;
        }
    } 


    public int calPoints(String[] operations) {
        List<Integer> records = new ArrayList<>();
        int sum=0;
        int temp=0;
        for(int i=0;i<operations.length;i++){
            if(isNumeric(operations[i])){
                temp=Integer.valueOf(operations[i]);
                records.add(temp);
                sum+=temp;
            }
            else if(operations[i].equals("C")){
                records.remove(records.size()-1);
                sum-=temp;
                if(!records.isEmpty())
                    temp=records.get(records.size()-1);
            }
            else if(operations[i].equals("D")){
                records.add(temp*2);
                sum+=temp*2;
                temp=temp*2;
            }

            else{
                int prevTwoSum=records.get(records.size()-1)+records.get(records.size()-2);
                records.add(prevTwoSum);
                temp=prevTwoSum;
                sum+=prevTwoSum;
            }

            System.out.println(sum);
        }

        System.out.println(records.toString());
        return sum;
    }
}