
import java.util.Scanner;

public class Task4d {

    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	int ans = 0;

        //---------------write your code BELOW this line only!--------------


        int n = scanner.nextInt();
        boolean aad = true;
        int sum=1;

        while (aad) {
            double a = (int) (Math.random()*(n-1))+1;
            ans++;
            for (int i = 1; i < n; i++) {
                sum *= a;
                sum = sum % n;

            }
            if (sum != 1) {
                aad = false;
            }
        }
    	
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}