package blind75;

import java.util.HashMap;

public class ValidAnagrams {
    public static boolean isValid(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i),
                    hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            if (!hashMap.containsKey(t.charAt(i)))
                return false;
            else{
                int freq = hashMap.get(t.charAt(i));
                if (freq == 0) {
                    hashMap.remove(t.charAt(i));
                    return false;
                }
                hashMap.put(t.charAt(i), freq - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nggaram";
        System.out.println(isValid(s, t));
    }
}
