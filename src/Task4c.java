
import java.util.Scanner;

public class Task4c {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean ans = true;

        //---------------write your code BELOW this line only!--------------

        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int sum=1;

        for (int i=1;i<n;i++){
            sum *= a;
            sum = sum%n;

        }
        if (sum != 1){
            ans = false;
        }


        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);

		scanner.close();
    }
}