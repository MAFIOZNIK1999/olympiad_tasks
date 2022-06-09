package task3;

import java.math.BigInteger;

/*
The factorial of n also equals the product of n with the next smaller factorial
n! = 1 * 2 * 3 * ... * (n - 2) * (n - 1) * n
 */

public class Factorial {
    public static BigInteger factorial(int num) {
        if (num > 1) {
            return factorial(num - 1).multiply(BigInteger.valueOf(num));
        }
        return BigInteger.ONE;
    }
}
