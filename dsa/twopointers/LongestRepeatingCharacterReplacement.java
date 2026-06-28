package twopointers;

public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {

        int[] charFrequency = new int[26];

        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add current character into window
            int currentCharIndex = s.charAt(right) - 'A';
            charFrequency[currentCharIndex]++;

            // Track highest frequency character in current window
            maxFrequency = Math.max(maxFrequency, charFrequency[currentCharIndex]);

            int windowSize = right - left + 1;
            // If window becomes invalid, shrink it
            while ( windowSize - maxFrequency > k) {

                int leftCharIndex = s.charAt(left) - 'A';
                charFrequency[leftCharIndex]--;

                left++;
                windowSize = right - left + 1;
            }

            // Update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s= "AABABBA";
        int k = 1;
        LongestRepeatingCharacterReplacement lcr = new LongestRepeatingCharacterReplacement();
        System.out.println(lcr.characterReplacement(s, k));
    }
}