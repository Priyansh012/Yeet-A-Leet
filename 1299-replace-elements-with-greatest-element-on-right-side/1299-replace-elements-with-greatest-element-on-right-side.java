class Solution {
    public int[] replaceElements(int[] arr) {
        int n=arr.length;
        if(n==1)
        {
            arr[0]=-1;
            return arr;
        }

        else{
            for(int i=0;i<n-1;i++){
                arr[i]=max(i+1,arr);
            }
            arr[n-1]=-1;
        } 
        return arr;
    }

    public int max(int index, int arr[])
    {
        int max=Integer.MIN_VALUE;
        for(int i=index;i<arr.length;i++){
            if(arr[i]>max)
                max=arr[i];
        }

        return max;
    }
}


//Optimal Solution
// Replace Elements with Greatest Element on Right Side

  /*  public int[] replaceElements(int[] arr) {
        int maxSoFar = arr[arr.length - 1]; //take last element in array as maxVal
        arr[arr.length - 1] = -1;
		//start array traversal from right to left
        for(int i = arr.length - 2; i > -1; i--){
            int currVal = arr[i];
            arr[i] = maxSoFar;
            maxSoFar = Math.max(maxSoFar, currVal);
			//keep updating maxRight element encountered so far
        }
        return arr;
    }*/