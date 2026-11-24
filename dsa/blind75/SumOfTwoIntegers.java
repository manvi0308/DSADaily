package blind75;

public class SumOfTwoIntegers {
    public static int getSum(int a, int b){
        while (b != 0){
            final int carry = a & b;
            a ^= b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 6;
        int res = getSum(a, b);
        System.out.println(res);
    }
}
