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
        Queue<Pair> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }
        queue.add(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!queue.isEmpty()) {
            Pair pair = queue.poll();
            String word = pair.word;
            if(word.equals(endWord))
                return pair.transformations;
            // in the current word, we will try for each letter/char of word
            // with every possible char and check if its a valid word as per wordList.

            for(int i = 0; i < word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char[] repCharArray = word.toCharArray();
                    repCharArray[i] = ch;
                    String repWord = new String(repCharArray);
                    if(set.contains(repWord)) {
                        set.remove(repWord);
                        queue.add(new Pair(repWord, pair.transformations+1));
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
