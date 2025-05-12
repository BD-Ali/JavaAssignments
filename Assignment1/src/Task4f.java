
import java.util.Scanner;

public class Task4f {

    public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------

        boolean aad = false;
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        while (!aad) {
            ans = (int) (Math.random() * (y - x + 1)) + x;
            if (ans>1) {
                boolean IsPrime = true;
                for (int i = 1;i < 5; i++) {
                    int a = (int) (Math.random() * (ans - 1)) + 1;
                    int sum = 1;

                    for (int j = 1; j < ans; j++) {
                        sum = (sum*a)%ans;
                    }
                    if (sum != 1) {
                        IsPrime = false;
                    }
                }
                if (IsPrime) {
                    aad = true;
                }
            }
        }
        
        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);

		scanner.close();
    }
}