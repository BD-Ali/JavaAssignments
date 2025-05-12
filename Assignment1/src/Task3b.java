
import java.util.Scanner;


public class Task3b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n > 0) {
            ans = 1;
            int counter = 1;
            for (int i = 1; i <= n; i++) {
                ans *= 2;
                counter++;

                if (counter >= 31)
                {
                    ans = ans%k;
                    counter +=30;
                }
                if ( n<30)
                {
                    ans = ans%k;
                }
            }
        }

        else {
            ans +=1%k;
        }

        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}