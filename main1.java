//some bullshit

import java.util.*;
class main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int multiplicand = sc.nextInt();
        int multiplier = sc.nextInt();

        int product = 0;
        int multiplicandBits = Integer.toBinaryString(multiplicand).length();

        for (int i = 0; i < multiplicandBits; i++)   {
            int currentBit = (multiplicand & 0b1);
            if (currentBit == 1)   {
                product += multiplier;
            }
            multiplier <<= 1;
            multiplicand >>>= 1;
        }
        System.out.println(product);
    }
}
