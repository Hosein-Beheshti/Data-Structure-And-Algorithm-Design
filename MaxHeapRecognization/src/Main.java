import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        Integer[] arr_nums = new Integer[num];
        for(int i = 0 ; i < num ; i++)
        {
            arr_nums[i] = scan.nextInt();
        }
        int count = 0;
        boolean maxHeap = true;
        for(int i = 0 ; i < arr_nums.length ; i++)
        {
            if(i == 1)
                count = 1;
            if(i % 2 == 0 && i!=0 && i!=1)
                count++;
            // System.out.println(count);
            if(arr_nums[i] > arr_nums[i - count] && i != 0) {
                //   System.out.println(arr_nums[i] + " " + arr_nums[i - count]);
                System.out.println("NO");
                maxHeap = false;
                break;
            }
        }
        if (maxHeap)
            System.out.println("YES");

    }
}