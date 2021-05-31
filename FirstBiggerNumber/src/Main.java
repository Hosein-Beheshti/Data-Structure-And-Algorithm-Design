import java.util.ArrayList;
import java.util.Scanner;

//finding first bigger number with bigger index.
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        Integer[] arr_nums = new Integer[num];
        for(int i = 0 ; i < num ; i++)
        {
            arr_nums[i] = scan.nextInt();
        }

        for(int i = 0 ; i < arr_nums.length ; i++)
        {
            boolean replace = false ;
            for(int j = i+1 ; j < arr_nums.length ; j++)
            {

                if(arr_nums[j] > arr_nums[i]) {
                    arr_nums[i] = arr_nums[j];
                    replace = true ;
                    break;
                }
            }
            if(!replace)
                arr_nums[i] = -1;

            System.out.print(arr_nums[i] + " ");
        }


    }
}
