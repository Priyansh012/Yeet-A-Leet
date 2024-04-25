class Solution {
    //Bruteforce
    /*public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int result [] = new int [nums1.length];
        Arrays.fill(result,-1);

        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i], i);
        }

        for(int i=0;i<nums2.length;i++){
            if(!map.containsKey(nums2[i]))
                continue;
            for(int j=i+1;j<nums2.length;j++){
                if(nums2[j]>nums2[i]){
                    int index=map.get(nums2[i]);
                    result[index]=nums2[j];
                    break;
                }
            }
        } 

        return result;   
    }*/

    //Optimal approach
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int result [] = new int [nums1.length];
        Arrays.fill(result,-1);
        
        for(int i=0;i<nums1.length;i++){
            map.put(nums1[i], i);
        }

        Stack<Integer> monoStack = new Stack<>();

        for(int i=0;i<nums2.length;i++){
            int cur=nums2[i];
            //maintaining decreasing monostack which means
            // every time the current element is greater than the stack top,
            //keep on poping until the current is not greater than top of stack
            // so in this way, the new element added to the stack will always be 
            // lesser than the previous stack top and thus maintains the decreasing monostack
            //property
            while(!monoStack.isEmpty() && cur>monoStack.peek()){
                int pop=monoStack.pop();
                if(map.containsKey(pop)){
                    int index=map.get(pop);
                    result[index]=cur;
                }
            }
            monoStack.push(cur);
        }

        return result;
    }
}