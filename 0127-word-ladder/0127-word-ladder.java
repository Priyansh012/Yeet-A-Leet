class Pair{
    String word;
    int level;

    Pair(String _word, int _level){
        this.word=_word;
        this.level=_level;
    }
}

//BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        Set<String> wordSet = new HashSet<>();
        int n=wordList.size();

        for(int i=0;i<n;i++){
            wordSet.add(wordList.get(i));
        }

        wordSet.remove(beginWord);

        while(!q.isEmpty()){
            String word= q.peek().word;
            int level=q.peek().level;
            q.poll();

            if(word.equals(endWord))
                return level;

            for(int i=0;i<word.length();i++){
                for(char ch='a'; ch<='z'; ch++){
                    char replacedCharArray [] = word.toCharArray();
                    replacedCharArray[i]=ch;
                    String replacedWord = new String(replacedCharArray);

                    //if new combination exist in set then remove from set and push it on queue
                    if(wordSet.contains(replacedWord)){
                        wordSet.remove(replacedWord);
                        q.add(new Pair(replacedWord, level+1));
                    }
                }
            }
        }

        return 0;
    }
}