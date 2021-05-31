import java.util.Scanner;

public class Main {

    static int swapnum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];

        for (int i = 0 ; i < size ; i++)
        {
            arr[i] = scanner.nextInt();
        }

        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(arr, size, i);

        for (int i = size - 1 ; i >= 0 ; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
        System.out.println(swapnum);


    }
    static void heapify(int arr[], int size, int i)
    {

        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if (l < size && arr[l] > arr[largest])
            largest = l;

        if (r < size && arr[r] > arr[largest])
            largest = r;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            swapnum++;

            heapify(arr, size, largest);
        }
    }
}
