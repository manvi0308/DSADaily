package twopointers;

import java.util.*;
public class LongestSubStringWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            if (map.containsKey(current)) {
                left = Math.max(left, map.get(current) + 1);
            }
            map.put(current, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String s = "abba";
        LongestSubStringWithoutRepeatingChars ls = new LongestSubStringWithoutRepeatingChars();
        System.out.println(ls.lengthOfLongestSubstring(s));
    }
}
