package hardqs;

import java.util.*;

public class WordLadder {
    class Pair{
        String word;
        int transformations;

        public Pair(String word, int transformations) {
            this.word = word;
            this.transformations = transformations;
        }
    }
    public  int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        Queue<Pair> queue = new LinkedList<>();
        for (String s: wordList){
            set.add(s); // for O(1) lookups
        }
        if(!set.contains(beginWord))
            return -1;
        // initial setup
        queue.add(new Pair(beginWord, 1));

        while (!queue.isEmpty()){
            Pair currPair = queue.peek();
            String currWord = currPair.word;
            int transformations = currPair.transformations;
            if (currWord.equals(endWord))
                return transformations;
            for (int i = 0; i < currWord.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch+=1){
                    char[] charArray = currWord.toCharArray();
                    charArray[i] = ch;
                    String newWord = new String(charArray);

                    if (set.contains(newWord)){
                        set.remove(newWord);
                        queue.add(new Pair(newWord, transformations + 1));
                    }
                }
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(
                Arrays.asList("dot", "dog", "lot", "log", "cog")
        );
        WordLadder wordLadder = new WordLadder() ;
        System.out.println((wordLadder.ladderLength(beginWord, endWord, wordList)));
    }
}
