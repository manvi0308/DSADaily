package strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChars {
    static int longestSubString(String s){
        // a = abcabcbb
        //
        // O/P -> abc
        /*
        {A,0}, {B, 1}, {C, 2}
        at i = 0, and j = 3, A
        i will be moved x steps ahead, this x will be determined by
        hMap.get('A')
         */
        if (s.isEmpty() || s.length() == 1)
            return s.length();
        if (s.length() == 2)
            return (s.charAt(0) == s.charAt(1)) ? 2 : 1;
        int n = s.length();
        int left = 0;
        int ans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++){
            if (set.contains(s.charAt(right))){
                while (left < right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(s.charAt(right));
            ans = Math.max(ans, (right - left + 1));
        }
        return ans;
    }
}
