package task1;

/*
In combinatorial mathematics, the Catalan numbers are a sequence of natural
numbers that occur in various counting problems, often involving recursively defined objects.
C[n] = C[k] * C[n-k-1]
 */

public class CatalanNumber {
    public int catalan(int number) {
        int result = 0;
        if (number > 1) {
            for (int i = 0; i < number; i++) {
                result += catalan(i)
                        * catalan(number - i - 1);
            }
            return result;
        }
        return 1;
    }
}
