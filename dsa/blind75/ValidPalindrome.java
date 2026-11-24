package blind75;

public class ValidPalindrome {
    public static boolean isPalindrome(String s){
        // conversion
        s = s.toLowerCase();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++){
            if ( !Character.isLetterOrDigit(s.charAt(i)) ){
                continue;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());

        int left = 0, right = sb.length() - 1;
        while (left <= right){
            if (sb.charAt(left) != sb.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
