import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<List<Integer>> treeArray ;
    static int dec;
    static  int[] decrease;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int verticesNumber = scanner.nextInt();
        int helpNumber = scanner.nextInt();
        treeArray  = new ArrayList<List<Integer>>(verticesNumber + 1);
        decrease = new int[verticesNumber];
        //int[][][] arrayOfNumbers = new int[verticesNumber + 1][verticesNumber + 1][1];
        for(int i = 0; i < verticesNumber +1 ; i++)  {
            treeArray.add(new ArrayList<Integer>());
        }

        for(int i = 0 ; i < verticesNumber +1 ; i++)
        {
            treeArray.get(i).add(1);
            treeArray.get(i).add(i);
        }
        for(int i = 0 ; i < verticesNumber - 1 ; i++)
        {
            int v1 , v2;
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            treeArray.get(v1).add(v2);
            treeArray.get(v2).add(v1);

        }
        //System.out.println("helper");
        for(int i = 0 ; i < helpNumber ; i++)
        {
            dec =0;
            int v1 , v2;
            int calumeIndex = 0;
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();

            // calumeIndex = treeArray.indexOf(v1);
            // System.out.println(calumeIndex);
            if(treeArray.get(v1).get(0) == 1)
                remove(v1,v2 ,i);
//            System.out.println(dec);
            decrease[i] = dec;
//            System.out.println(".....");
//                for(int j = 1 ; j < treeArray.get(v1).size()  ; j++)
//            {
//                int rowValue = treeArray.get(v1).get(j);
//                if(treeArray.get(v1).get(j) != v2 && treeArray.get(rowValue).get(0) == 1)
//                {
//
//                    treeArray.get(rowValue).set(0, 0);
//                    dec++;
//                }
//            }

        }
//        for (List<Integer> row : treeArray)
//            System.out.println(row);

        int res = verticesNumber;
        for (int i = 0 ; i < helpNumber ; i++)
        {
            res -= decrease[i];
            System.out.println(res);
        }
    }
    public static void remove(int v1 , int v2,int i)
    {

        //    if(treeArray.get(v1).get(0) == 1)
        for(int j = 1 ; j < treeArray.get(v1).size()  ; j++)
        {
            int rowValue = treeArray.get(v1).get(j);
            if(treeArray.get(v1).get(j) != v2 && treeArray.get(rowValue).get(0) == 1)
            {

                treeArray.get(rowValue).set(0, 0);
                dec++;
                // System.out.println(dec);
                remove(rowValue,v2,i );

            }

        }

    }

}
