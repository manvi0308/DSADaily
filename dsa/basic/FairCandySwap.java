package basic;

import java.util.HashSet;

public class FairCandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes){
        /*
        x -> no of candies that alice must give to bob
        y -> no of candies that bob must give to alice

        In the end, what we want is
        alice - x + y = bob - y + x

        Rearranging
        alice - x + y = bob + x - y
        alice - bob = x  - y  - y + x
        alice - bob = 2( x - y )
        x - y = (alice - bob)/2

        alice -> [1, 2, 5]
        bob -> [2, 4]

        diff = ( 8 - 6 )/2 = 2/2 = 1
        x - y = 1
        x = 5, 5 - y = 1
        y = 4
         */
        int aliceTotal= 0, bobTotal=0;
        for (int i = 0; i < aliceSizes.length; i++){
            aliceTotal+=aliceSizes[i];
        }
        for (int i = 0; i < bobSizes.length; i++){
            bobTotal+=bobSizes[i];
        }
        int diff = (aliceTotal - bobTotal)/2;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < bobSizes.length; i++){
            set.add(bobSizes[i]);
        }
        for (int i = 0; i < aliceSizes.length; i++){
            int target = aliceSizes[i] - diff;
            if (set.contains(target)){
                return new int[]{aliceSizes[i], target};
            }
        }

        throw new IllegalArgumentException();
    }
}
