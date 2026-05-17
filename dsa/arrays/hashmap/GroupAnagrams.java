package arrays.hashmap;

import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String s : strs){
            char[] chArray = s.toCharArray();
            Arrays.sort(chArray);
            String sortedWord = new String(chArray);
            if (!hashMap.containsKey(sortedWord)){
                    hashMap.put(sortedWord, new ArrayList<>());
            }
            hashMap.get(sortedWord).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }
}
