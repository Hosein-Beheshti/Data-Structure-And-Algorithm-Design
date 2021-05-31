import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> arrayOfNumbers = new ArrayList();
        int n = 0;
        n = scanner.nextInt();
        int function;
        int number;
        int[] res = new int[n];

        for(int i = 0 ; i < n ; i++)
        {
            function = scanner.nextInt();
            number = scanner.nextInt();
            if(function == 1)
            {
                //Add to Array
                addToArray(arrayOfNumbers,number );
                //  System.out.println("added");
                res[i] = resNumber(arrayOfNumbers);


            }
            else if(function == 2)
            {
                //Remove from array
                removeFromArray(arrayOfNumbers,number );
                //   System.out.println("removed");
                res[i] = resNumber(arrayOfNumbers);

            }
//            for (int number1 : arrayOfNumbers) {
//                System.out.println(" array " + number1);
//            }
        }
        // System.out.println("answer");
        for (int i = 0 ; i < n ; i++)
        {
            System.out.println(res[i]);
        }


    }
    public static void addToArray(ArrayList<Integer> arrayList,int num)
    {
        arrayList.add(num);
    }
    public static void removeFromArray(ArrayList<Integer> arrayList,int num)
    {

//        for (int number1 : arrayList) {
//            System.out.println("number = " + number1);
//        }
//        arrayList.remove(new Integer(num));

        Iterator i = arrayList.iterator();
        int in;
        while (i.hasNext()) {
            in = (Integer) i.next();
            if (in == num) {
                i.remove();
            }
        }
    }
    public static int resNumber(ArrayList<Integer> arrayList)
    {
        if(arrayList.size() == 1)
            return arrayList.get(0);
        //find average
        // int[] arrbigger = new int[100000];
        double average = 0;
        for (int number1 : arrayList) {
            average += number1;
        }
        average = average / arrayList.size();
        // System.out.println(average);
//*******************************************************
        //  System.out.println("Average = " + average);
        int min = 0 ;
        boolean kk = false;
        for (int number1 : arrayList) {

            // System.out.print("number = " + number1);
            if (number1 >= average) {
                if(!kk)
                {
                    min = number1;
                    kk = true;
                }
                else
                if(min > number1)
                    min = number1;
            }
        }
//            for (int i = 0; i < count ; i++) {
//                if (min > arrbigger[i]) {
//                    min = arrbigger[i];
//                }
//            }
        //  System.out.println(" min = " + min);

        return min;

    }
}