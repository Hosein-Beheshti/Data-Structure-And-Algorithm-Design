import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input;
        int n = 0;
        int l = 0, r = 0;
        input = scan.next();
        n = scan.nextInt();
        int count = 1;
        int count1 = 1;

        // int[] arrCount = new int[10000];
        int countAdress;

        int[][] arr = new int[n][2];
        boolean[] arrBool = new boolean[n];

        //scan
        for (int i = 0; i < n; i++) {
            l = scan.nextInt();
            r = scan.nextInt();
            arr[i][0] = l - 1;
            arr[i][1] = r - 1;
        }
        //***
        for (int i = 0; i < n; i++) {
            arrBool[i] = false;
            if (Math.abs(arr[i][1] - arr[i][0]) >= 1) {
                for (int j = arr[i][0]; j < arr[i][1]; j++) {
                    if (arrBool[i])
                        break;

                    if(input.charAt(j) == input.charAt(j+1))
                        arrBool[i] = true;

                    if(j+2 <= arr[i][1])
                        if(input.charAt(j) == input.charAt(j+2) )
                            arrBool[i] = true;

                    countAdress = j;
//                    for (int k = j + 1; k <= arr[i][1]; k++) {
//                        if (arrBool[i])
//                            break;
//
//                        if (input.charAt(j) == input.charAt(k)) {
//                           // System.out.println("countAdress = " + countAdress + "k = " + k );
//
//                            if (Math.abs(countAdress - k) <= 2) {
//                                arrBool[i] = true;
//                                break;
//                            }
//                            countAdress = k;
//                        }
//
//
//                        // System.out.println(Arrays.toString(arrCount));
//                    }
                }
            }
        }

        //print
        for(int i = 0 ; i < n ; i++)
        {
            if(arrBool[i])
                System.out.println("Yes");
            else
                System.out.println("No");
        }

    }
}