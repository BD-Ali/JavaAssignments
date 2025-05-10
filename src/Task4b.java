
import java.util.Scanner;

public class Task4b {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int ans = 0;

        //---------------write your code BELOW this line only!--------------


        int Max = scanner.nextInt();
        if (Max>=0) {
        int[] AllN = new int[Max];
            for (int n = 2; n <= Max; n++) {
                boolean isPrime = true;
                for (int Pindex = 0; Pindex < ans &&
                        AllN[Pindex] * AllN[Pindex] <= n &&
                        isPrime; Pindex++) {

                    if (n % AllN[Pindex] == 0) {
                        isPrime = false;
                    }
                }

                if (isPrime) {
                    AllN[ans] = n;
                    ans++;
                }
            }
        }





        //---------------write your code ABOVE this line only!--------------

        System.out.println(ans);
        scanner.close();
    }

}