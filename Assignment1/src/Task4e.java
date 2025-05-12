
import java.util.Scanner;

public class Task4e {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------

        ans = false;
        int ans1 = 0;
        int n = scanner.nextInt();


        for (int i = 1;i < 5; i++) {
            int a = (int) (Math.random() * (n - 1)) + 1;
            int sum = 1;

            for (int j = 1; j < n; j++) {
                sum = (sum * a) % n;
            }
            if (sum == 1) {
                ans = true;
            }
        }

        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
		scanner.close();
    }
}