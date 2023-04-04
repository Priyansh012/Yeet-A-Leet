//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			System.out.println(obj.atoi(str));
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String str) {
	    int result=0;
	    boolean negativeFlag=false;
	    int start;
	    int curValue;
	    
	    if(str.charAt(0)=='-'){
	        negativeFlag=true;
	        start=1;
	    }
	    else{
	        start=0;
	    }
	    
	    for(int i=start; i<str.length();i++){
	        curValue=str.charAt(i)-'0';
	        if(curValue>=0 && curValue<=9){
	            result=result*10+curValue;
	        }
	        else
	            return -1;
	    }
	    
	    if(negativeFlag)
	        return -1*result;
	   
	    return result;
    }
}


/*If inbuilt functions are allowed*/
/*class Solution
{
    int atoi(String str) {
	// Your code here
	    if(!str.matches("-?[1-9]\\d*|0"))
	        return -1;
	    
	    return Integer.valueOf(str);
    }
}*/