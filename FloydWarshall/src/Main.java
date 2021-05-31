import java.util.Scanner;

public class Main {

    static int resDist[];
    static int dist[][];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int graph[][] = new int[V][V];
        resDist = new int[V];
        dist = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = 0;
            }
        }


        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }

        int n = scanner.nextInt();
        int finalRes[] = new int[n];
        int v1 = 0, v2 = 0, val = 0;
        for (int i = 0; i < n; i++) {
            int res = 0;
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            val = scanner.nextInt();
            if (val < graph[v1 - 1][v2 - 1]) {
                graph[v1 - 1][v2 - 1] = val;
                graph[v2 - 1][v1 - 1] = val;
                int max = 0 ;

                floydWarshall(graph, V , false,v1 - 1 , v2 - 1);

                for (int i2 = 0; i2 < V; i2++) {

                    for (int j = i2; j < V; j++) {
                        finalRes[i] += dist[i2][j];
                    }
                }
            } else {
                if (i == 0) {
                    floydWarshall(graph, V , true , 0 , 0);
                    for (int i2 = 0; i2 < V; i2++) {

                        for (int j = i2; j < V; j++) {
                            finalRes[i] += dist[i2][j];
                        }
                    }

                } else {
                    finalRes[i] = finalRes[i - 1];
                }
            }

        }
        for (int i = 0; i < n; i++)
            System.out.print(finalRes[i] + " ");
//        for (int i = 0; i < V; i++) {
//
//            for (int j = 0; j < V; j++) {
//
//                System.out.print(dist[i][j] + " ");
//            }
//            System.out.println("");
//        }


    }

    static void floydWarshall(int graph[][], int V,boolean first, int k1 , int k2) {
        //  System.out.println("k1 = " + k1);

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];


        for (int k = 0; k < V; k++) {
            // if(first == false)
            // if(k == k1 || k == k2 )
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

                }
            }
        }
    }
}
