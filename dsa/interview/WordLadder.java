package interview;

import java.util.*;

public class WordLadder {
    /*
        GRAPH PROBLEM
       1) EACH WORD IS A NODE
       2) THERE IS AN EDGE BETWEEN TWO WORDS IF THEY DIFFER BY EXACTLY ONE CHARACTER
        hot ---> dot

       3) Shortest path sequence form begin word to end word
       4) BFS Comes up as a natural choce, since it mentions shortest path and BFS traverss
       level by level, so its guaranteed that the first time i am reaching a node is via the shortest path


      FINDING NEIGHBORS EFFICIENTLY

      1) L --> 26, 26, 26, ...... Lth character
      No of checks = 26 * L

      For each word, I will try replacing each charater with a to z and check if the new character
      exists in the word dictionary


      VISITED SET

      AS AND WHEN I VISIT ONE WORD, I WILL REMOVE THAT WORD FROM DICTIONARY, WE CAN OPTIMIZE THIS TO USE
      SET, TO HAVE O(1) LOOKUPS

     */

    class Pair{
        String word;
        int transformations;

        public Pair(String word, int transformations) {
            this.word = word;
            this.transformations = transformations;
        }
    }
    public int wordDict(String beginWord, String endWord, List<String> wordDict){
        Set<String> set = new HashSet<>(wordDict);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));

        // set may not contain the begin word, but in java even if word is not present
        // the method will not throw an exception, just return false
        set.remove(beginWord);
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            String word = pair.word;

            if (word.equals(endWord))
                return pair.transformations;
            for(int i = 0; i < word.length(); i++){
                for (char ch ='a'; ch <= 'z'; ch++){
                    char[] repCharArray = word.toCharArray();
                    repCharArray[i] = ch;
                    String repWord = new String(repCharArray);

                    if (set.contains(repWord)){
                        set.remove(repWord);
                        queue.add(new Pair(repWord, pair.transformations  + 1) );
                    }
                }
            }
        }
    return 0;
    }
}
