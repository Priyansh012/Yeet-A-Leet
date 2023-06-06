//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//BFS
class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        Queue<ArrayList<String>> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        int n=wordList.length;

        for(int i=0;i<n;i++){
            wordSet.add(wordList[i]);
        }
        
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        int level=0;
        
        ArrayList<ArrayList<String>> ans = new ArrayList<ArrayList<String>>();
        
        while(!q.isEmpty()){
            ArrayList<String> currentList = q.poll();
            
            //erase all the words thats been used in the previous level for transformation
            if(currentList.size()>level){
                level+=1;
                for(String it : usedOnLevel){
                    wordSet.remove(it);
                }
            }
            
            String word= currentList.get(currentList.size()-1);
            if(word.equals(targetWord)){
                if(ans.size()==0)
                    ans.add(currentList);
                else if(ans.get(0).size()==currentList.size())
                    ans.add(currentList);
                    
            }
            
            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z'; ch++){
                    char replacedCharArray [] = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);
                    
                    //if new combination exist in set then add the word into the currentList
                    //and push the currentlist into the queue 
                    if(wordSet.contains(replacedWord)){
                        currentList.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(currentList);
                        q.add(temp);
                        //to keep track on the words to be removed which are used at this level
                        //kinda marking them visited
                        //so that later on they can be removed from the set
                        usedOnLevel.add(replacedWord);
                        currentList.remove(currentList.size()-1);
                    }
                }
            }
            
            
            
        }
        
        return ans;
        
    }
}