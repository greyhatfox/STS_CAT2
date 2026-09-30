//karatsuba ----take your time----

import java.math.*;
import java.util.*;

public class main3 {
    public static BigInteger karatsuba(BigInteger x, BigInteger y) {
        int n = Math.max(x.bitLength(), y.bitLength());

        if (n <= 2000) {
            return x.multiply(y);
        }

        int half = (n + 32) / 64 * 32;

        BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);
        BigInteger xLow = x.and(mask);
        BigInteger yLow = y.and(mask);
        BigInteger xHigh = x.shiftRight(half);
        BigInteger yHigh = y.shiftRight(half);

        BigInteger z0 = karatsuba(xLow,yLow);
        BigInteger z1 = karatsuba(xLow.add(xHigh), yLow.add(yHigh));
        BigInteger z2 = karatsuba(xHigh, yHigh);

        BigInteger result = z2.shiftLeft(2*half).add(z1.subtract(z2).subtract(z0).shiftLeft(half)).add(z0);
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BigInteger x = sc.nextBigInteger();
        BigInteger y = sc.nextBigInteger();

        BigInteger result = karatsuba(x, y);

        System.out.println(result);
    }
}

/*
import java.util.*;

public class Main {

    public static int karatsuba(int x, int y) {

        if (x < 10 || y < 10) {
            return x * y;
        }

        int m = Math.max(getNumDigits(x), getNumDigits(y));
        int halfM = m / 2;

        int powerOf10 = (int) Math.pow(10, halfM);

        int a = x / powerOf10;
        int b = x % powerOf10;

        int c = y / powerOf10;
        int d = y % powerOf10;

        int ac = karatsuba(a, c);
        int bd = karatsuba(b, d);
        int abcd = karatsuba(a + b, c + d);

        int result = ac * (int) Math.pow(10, 2 * halfM) + (abcd - ac - bd) * powerOf10 + bd;

        return result;
    }

    private static int getNumDigits(int x) {

        if (x == 0) {
            return 1;
        }

        int count = 0;

        while (x > 0) {
            count++;
            x /= 10;
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner s1 = new Scanner(System.in);

        System.out.print("Enter number-1: ");
        int x = s1.nextInt();

        System.out.print("Enter number-2: ");
        int y = s1.nextInt();

        int product = karatsuba(x, y);

        System.out.println(x + " * " + y + " = " + product);
    }
}

*/