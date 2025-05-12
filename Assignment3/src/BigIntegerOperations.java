import java.math.BigInteger;
import java.util.Random;

public class BigIntegerOperations {
    //Task 2.1
    //Assumes n!=null
    //Returns the sum of positive integers smaller than n
    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum = null;
        // ---------------write your code BELOW this line only! ------------------
        if (n!=null) {
            sum = BigInteger.ZERO;
            int value = n.intValue();
            for (int i = 1; i < value; i++) {
                sum = sum.add(n.subtract(BigInteger.ONE));
                n = n.subtract(BigInteger.ONE);
            }
        }
        else throw new IllegalArgumentException();
        // ---------------write your code ABOVE this line only! ------------------
        return sum;
    }

    //Task 2.2
    //Assumes n>=0
    //prints n pseudo-random numbers
    public static void printRandoms(int n){
        // ---------------write your code BELOW this line only! ------------------
        if (n>=0)
           for (int i = 0; i < n; i++){
            System.out.println(new Random().nextInt());
           }
        else
            throw new IllegalArgumentException();
        // ---------------write your code ABOVE this line only! ------------------
    }

    //Task 2.3
    // Assumes n!=null and n>=0
    //Returns true iff n is a prime number
    public static boolean isPrime(BigInteger n){
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if (n!= null && n.intValue()>=0) {
            if (n.intValue() >= 2)
                for (int i = 2; ans && i * i <= n.intValue(); i++) {
                    if (n.intValue() % i == 0)
                        ans = false;
                }
            else ans = false;
        }
        else throw new IllegalArgumentException();

        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    //Task 2.4
    //Assumes n>1
    //Returns a randomly chosen prime number, smaller than 2^n
    public static BigInteger randomPrime(int n){
        BigInteger myRand = null;
        // ---------------write your code BELOW this line only! ------------------
        if (n>=0) {
            Random rand = new Random();
            BigInteger RND = new BigInteger(n, rand);
            if (isPrime(RND))
                myRand = RND;
            else
                myRand = randomPrime(n);
        }
        else throw new IllegalArgumentException();
        // ---------------write your code ABOVE this line only! ------------------
        return myRand;
    }

    //Task 2.5
    // No assumptions
    //Returns false if primes==null, or is not sorted, or includes duplicates, or includes a composite number
    public static boolean isValidPrimesArray(BigInteger[] primes) {
        boolean isValid = true; // Assume the array is valid initially
        // ---------------write your code BELOW this line only! ------------------
        if (primes != null )
            for (int i = 0; i < primes.length; i++) {
                if (!isPrime(primes[i]))
                    isValid = false;
                else if (i < primes.length - 1 && primes[i].intValue() >= primes[i + 1].intValue())
                    isValid = false;
            }
        else isValid = false;

        // ---------------write your code ABOVE this line only! ------------------
        return isValid;
    }


    //Task 2.6
    //Assumes primes != null, n !=null, and n>1. 'primes' is sorted, and includes only unique prime numbers.
    //Returns true iff n can be expressed as a product of prime numbers from primes
    public static boolean canFactorizeToTarget(BigInteger[] primes, BigInteger n) {
        boolean ans = true;
        // ---------------write your code BELOW this line only! ------------------
        if (n == null || n.compareTo(BigInteger.ONE) <= 0 || !isValidPrimesArray(primes))
            throw new IllegalArgumentException();
        else
            ans = canFactorizeToTarget(primes, n,0);
        // ---------------write your code ABOVE this line only! ------------------
        return ans;
    }

    public static boolean canFactorizeToTarget(BigInteger[] primes, BigInteger n, int StartChecking) {
        for (int i = StartChecking; i < primes.length; i++) {
            while(n.mod(primes[i]).equals(BigInteger.ZERO)) {
                n = n.divide(primes[i]);
                if (n.equals(BigInteger.ONE))// if its finally divided by all prime factorials
                    return true;
                if (canFactorizeToTarget(primes, n, i))//recursion that sends to the function the index we stopped at to continue from
                    return true;
            }
        }
        return false;
    }

    //Task 2.7
    //Assumes primes != null, n !=null, and n>1. 'primes' is sorted, and includes only unique prime numbers.
    //If n can be expressed as a product of prime numbers from primes, it prints the numbers in the factorization
    public static void printFactorization(BigInteger[] primes, BigInteger n) {
        // ---------------write your code BELOW this line only! ------------------
        if (!isValidPrimesArray(primes) || n!=null || n.compareTo(BigInteger.ONE)>0) {
            printFactorization(primes, n,"",0);
        }
        else throw new IllegalArgumentException();

        // ---------------write your code ABOVE this line only! ------------------
    }

    public static void printFactorization(BigInteger[] primes, BigInteger n,String ans,int k) {
        if (n.equals(BigInteger.ONE))
            System.out.println(ans.substring(1)); //prints prime factorials if the n successfully divided by them
        else {
            for (int i = k; i < primes.length; i++) {
                if (n.mod(primes[i]).equals(BigInteger.ZERO)) {
                    ans = ans + "," + primes[i];//saves the prime num that divides the n in ans
                    printFactorization(primes, n.divide(primes[i]), ans, i);//recursion that sends the saved prime num and the index we stopped at to continue checking
                }
            }
        }
    }

}
