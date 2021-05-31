import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static ArrayList<List<Integer>> graphArray;
    // static ArrayList<List<Integer>> hospitalArray ;
    static int length;
    static int[] lengthArray;
    static boolean find;
    static int counter = 0;
    static int min;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int verticesNumber = scanner.nextInt();
        int hospitalNumber = scanner.nextInt();
        int edgesNumber = scanner.nextInt();
        graphArray = new ArrayList<List<Integer>>(verticesNumber + 1);
        List<List<List<Integer>>> hospitalArray = new ArrayList<List<List<Integer>>>(verticesNumber + 1);
        lengthArray = new int[verticesNumber];
        int[] hospitalsNumArray = new int[hospitalNumber];
        int[] minimum = new int[verticesNumber + 1];
        boolean[] isH = new boolean[verticesNumber+1];


        for (int i = 0; i < verticesNumber + 1; i++) {
            graphArray.add(new ArrayList<Integer>());
            hospitalArray.add(new ArrayList<List<Integer>>());
        }


        for (int i = 0; i < verticesNumber + 1; i++) {
            graphArray.get(i).add(0);
            graphArray.get(i).add(1);
            graphArray.get(i).add(i);
        }
        for (int i = 1; i < hospitalNumber + 1; i++) {
            int num = scanner.nextInt();
            graphArray.get(num).set(0, 1);
            hospitalsNumArray[i - 1] = num;
            isH[num] = true;

        }
        for (int i = 0; i < edgesNumber; i++) {
            int v1, v2;
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            graphArray.get(v1).add(v2);
            graphArray.get(v2).add(v1);
        }

        if (false) {
            // System.out.println("Enter to verticesNumber < hospitalNumber * 2");
            for (int i = 0; i < hospitalNumber; i++) {
                boolean[] visited = new boolean[verticesNumber + 1];
                ArrayList<ArrayList<Integer>> tempArray = new ArrayList<ArrayList<Integer>>(verticesNumber + 1);
                for (int i1 = 0; i1 < verticesNumber + 1; i1++) {
                    tempArray.add(new ArrayList<Integer>());
                }
                int hNum = hospitalsNumArray[i];
                minimum[hNum] = 0;

                for (int j = 1; j < verticesNumber + 1; j++) {
                    if (j == 1) {
                        visited[hNum] = true;
                        for (int k = 3; k < graphArray.get(hNum).size(); k++) {

                            tempArray.get(j).add(graphArray.get(hNum).get(k));
                            if (i == 0) {
                                minimum[graphArray.get(hNum).get(k)] = j;
                                //  System.out.println("i == 1 , j == 1 minimum added" + "j = " + j + "min = " + graphArray.get(hNum).get(k) );
                            }
                            if (i > 0 && minimum[graphArray.get(hNum).get(k)] > j) {
                                minimum[graphArray.get(hNum).get(k)] = j;
                                // System.out.println("i == 1 , j == 1 minimum added" + "j = " + j + "min = " + graphArray.get(hNum).get(k) );

                            }
                            visited[graphArray.get(hNum).get(k)] = true;

                        }
                    } else {
                        for (int l = 0; l < tempArray.get(j - 1).size(); l++) {
                            for (int k = 3; k < graphArray.get(tempArray.get(j - 1).get(l)).size(); k++) {
                                //  System.out.println("graphArray.get(hNum).get(k) = " + graphArray.get(hNum).get(k));
                                if (graphArray.get(tempArray.get(j - 1).get(l)).get(k) != hNum && !visited[graphArray.get(tempArray.get(j - 1).get(l)).get(k)]) {
                                    tempArray.get(j).add(graphArray.get(tempArray.get(j - 1).get(l)).get(k));
                                    if (i == 0) {
                                        minimum[graphArray.get(tempArray.get(j - 1).get(l)).get(k)] = j;
                                        // System.out.println("i == 1 , j > 1 minimum added" + "j = " + j + "min = " + graphArray.get(tempArray.get(j - 1).get(l)).get(k) );

                                    }
                                    if (i > 0 && minimum[graphArray.get(tempArray.get(j - 1).get(l)).get(k)] > j)
                                        minimum[graphArray.get(tempArray.get(j - 1).get(l)).get(k)] = j;
                                    //  System.out.println("i > 1 , j > 1 minimum added" + "j = " + j + "min = " + graphArray.get(tempArray.get(j - 1).get(l)).get(k) );

                                }
                                visited[graphArray.get(tempArray.get(j - 1).get(l)).get(k)] = true;

                            }
                        }
                    }
                }


//                for (List<Integer> row : tempArray) {
//                    System.out.println(row);
//                   // System.out.println(tempArray.indexOf(new ArrayList(new Integer( 2)).get(2)));
//                }
                // hospitalArray.add(tempArray);

            }
            for (int i = 1; i < verticesNumber + 1; i++) {
                System.out.print(minimum[i] + " ");
            }

        }

        //**********************************************

        else {


            for (int i = 1; i < verticesNumber + 1; i++) {
                boolean findedMin = false;
                boolean[] visited = new boolean[verticesNumber + 1];
                visited[i] = true;
                boolean isHospital = false;
                if(!isH[i])
                {


                    ArrayList<ArrayList<Integer>> tempArray = new ArrayList<ArrayList<Integer>>(verticesNumber + 1);
                    for (int i1 = 0; i1 < verticesNumber + 1; i1++) {
                        tempArray.add(new ArrayList<Integer>());
                    }


                    for (int j = 1; j < verticesNumber + 1; j++) {
                        if (findedMin)
                            break;
                        if (j == 1) {
                            for (int k = 3; k < graphArray.get(i).size(); k++) {

                                //  System.out.println(graphArray.get(i).get(k));
                                if (!findedMin) {
                                    tempArray.get(j).add(graphArray.get(i).get(k));
                                    // for (int i2 = 0; i2 < hospitalNumber; i2++) {
                                    //  System.out.println(findedMin);
                                    //   int hNum = hospitalsNumArray[i2];
                                    //   System.out.println("h = " + hNum);
                                    if (isH[graphArray.get(i).get(k)]) {
//                                                System.out.println("fiiiiiiiind1");
//                                                System.out.println(" i = " + i);
                                        findedMin = true;
                                        minimum[i] = j;
                                        break;
                                    }

//                                        for (int i3 = 1; i3 < verticesNumber + 1; i3++) {
//                                          //  System.out.print(minimum[i3] + " ");
//                                        }
                                    visited[graphArray.get(i).get(k)] = true;
                                }
                            }
                        } else if(j > 1) {
                            if(!findedMin) {
//                                    System.out.println(findedMin);
//                                    System.out.println("hi");
                                for (int l = 0; l < tempArray.get(j - 1).size(); l++) {
                                    if(findedMin)
                                        break;
                                    for (int k = 3; k < graphArray.get(tempArray.get(j - 1).get(l)).size(); k++) {
                                        if (findedMin)
                                            break;
                                        if (graphArray.get(tempArray.get(j - 1).get(l)).get(k) != i && !visited[graphArray.get(tempArray.get(j - 1).get(l)).get(k)] && !findedMin) {
                                            tempArray.get(j).add(graphArray.get(tempArray.get(j - 1).get(l)).get(k));
                                            if (!findedMin) {
//                                                    for (int i2 = 0; i2 < hospitalNumber; i2++) {
                                                //int hNum = hospitalsNumArray[i2];
                                                if (!findedMin)
                                                    if (isH[graphArray.get(tempArray.get(j - 1).get(l)).get(k)]) {
                                                        findedMin = true;
                                                        minimum[i] = j;
//                                                                System.out.println("minimum = " + j);
                                                        break;
                                                    }
                                            }
                                        }
                                        visited[graphArray.get(tempArray.get(j - 1).get(l)).get(k)] = true;

                                    }
                                }
                            }
                        }

                        //for (List<Integer> row : tempArray)
//                System.out.println(row);
//                        System.out.println("***");

                    }
                    if(!findedMin)
                    {
                        minimum[i] = verticesNumber;
                    }
                }
            }
            for (int i = 1; i < verticesNumber + 1; i++) {
                System.out.print(minimum[i] + " ");

            }
        }
        if (1 == 2)
            for (int i = 1; i <= verticesNumber; i++) {
                min = 0;
                counter = i;
                find = false;

                for (int j = 1; j <= verticesNumber; j++) {
                    graphArray.get(j).set(1, 1);
                }

//            for (List<Integer> row : graphArray)
//                System.out.println(row);

                length = 1;
                if (graphArray.get(i).get(0) == 1) {
                    // System.out.println("  finded " + i);

                } else {
                    //  if(graphArray.get(i).get(1) == 1)
//                for(int k = 2 ; k < graphArray.get(i).size() ; k++) {
//                    for(int j = 1 ; j <= verticesNumber ; j++)
//                    {
//                        graphArray.get(j).set(1,1 );
//                    }
//                    find(graphArray.get(i).get(k));
//                  //  System.out.println("leeeength" + min);
//                }
                    // find(i);

                    //   System.out.println(" finded " + i);
                }
                //  lengthArray[i - 1] = length;

            }
        //*****************************

//        for (List<Integer> row : graphArray)
//            System.out.println(row);

//            int res = verticesNumber;
//            for (int i = 0; i < verticesNumber; i++) {
//                System.out.print(lengthArray[i] + " ");
//            }
    }


    public static void find(int i) {
        //  System.out.println("hi" + find);
        //    if(treeArray.get(v1).get(0) == 1)
        //  if(!find)
        for (int j = 2; j < graphArray.get(i).size(); j++) {
            int rowValue = graphArray.get(i).get(j);
            if (graphArray.get(rowValue).get(1) == 1) {
                //  System.out.println(rowValue);

                if (graphArray.get(rowValue).get(0) == 1) {
//                    System.out.println("findeeed length = " + length);
//                    System.out.println("i = "+ counter);
//                    System.out.println("find = " + find);
                    if (!find) {
                        min = length;
                    }
                    if (length < min && find) {
                        min = length;
                    }

                    lengthArray[counter - 1] = min;
                    find = true;
                    return;
                }

                graphArray.get(rowValue).set(1, 0);
                length++;
                //System.out.println("i = " + rowValue);
                if (rowValue != counter)
                    find(rowValue);
                length--;
                //  System.out.println("recersive row  = " + rowValue);


                if (rowValue != counter)
                    graphArray.get(rowValue).set(1, 1);
//
//                for (List<Integer> row : graphArray)
//                    System.out.println(row);

                // System.out.println("j = " + j);
                //                for(int k = 1 ; k <= graphArray.get(i).size() ; k++)
//                    {
//                        graphArray.get(j).set(k,1 );
//                    }
                //                if(graphArray.get(rowValue).get(0) == 1) {
//                    System.out.println("find");
//                    return;
//                }

            }

        }

    }

}
