import java.math.BigInteger;

public class PrintFibonacci {

    public static void main(String[] args) {

        for (int i = 1; i <= 200; i++) {

            System.out.println("Fibonacci.of(" + i + ") == " + Fibonacci.of(i));
        }
    }
}

class Fibonacci {

    public static BigInteger of(int n) {

        if (n <= 2)
            return BigInteger.ONE;
        BigInteger x = BigInteger.ONE;;
        BigInteger y = BigInteger.ONE;
        BigInteger temp;
        for (int i = 0; i < n - 2; i++) {

            temp = y;
            y = x.add(y);
            x = temp;
        }
        return y;
    }
}
