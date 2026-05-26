package strings;

import java.util.Arrays;

public class ReorganizeString {
    public String reorganizeString(String s) {
        int[] charFrequency = new int[26];
        int maxFrequency = 0;
        for (char c : s.toCharArray()){
            int index = c - 'a';
            charFrequency[index]++;
            maxFrequency = Math.max(maxFrequency, charFrequency[index]);
        }

        int stringLength = s.length();
        if (maxFrequency > (stringLength + 1)/2)
            return "";

        int uniqueCharCount = 0;
        for (int frequency : charFrequency){
            if (frequency > 0)
                uniqueCharCount++;
        }
        /*
        A 2d array like
        [ 1, 3] where 1 denotes the first character i.e. b, and 3 denotes the frequency
         */
        int[][] charData = new int[uniqueCharCount][2];
        int dataIndex = 0;
        for (int i = 0; i < 26; i++){
            if (charFrequency[i] > 0){
                charData[0][dataIndex] = i;
                charData[1][dataIndex] = charFrequency[i];
                dataIndex++;
            }
        }

        System.out.println(Arrays.toString(charData));
        Arrays.sort(charData, (a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder(s);
        int position = 0;
        for (int[] charInfo : charData){
            int charIndex = charInfo[0];
            int frequency = charInfo[1];

            while (frequency > 0){
                sb.setCharAt(position, (char) ('a' + charIndex));
                position += 2; // skip one position

                if (position >= stringLength)
                    position = 1;
                frequency--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "aaabbc";
        ReorganizeString rs = new ReorganizeString();
        System.out.println(rs.reorganizeString(s));
    }
}
