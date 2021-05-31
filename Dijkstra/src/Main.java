import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();

        int dist[] = new int[V];
        int graph[][] = new int[V][V];
        Boolean W_Select[] = new Boolean[V];
        for(int i = 0 ; i < V ; i++)
        {
            for(int j = 0 ; j < V ; j++)
            {
                graph[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            W_Select[i] = false;
        }
        dist[0] = 0;

        for (int i = 0; i < V-1; i++)
        {
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            for (int v = 0; v < V; v++)
                if (W_Select[v] == false && dist[v] <= min)
                {
                    min = dist[v];
                    min_index = v;
                }
            int u = min_index;
            W_Select[u] = true;

            for (int v = 0; v < V; v++)
                if (!W_Select[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        graph[u][v] < dist[v])
                    dist[v] =  graph[u][v];
        }
        int res = 0 ;
        for(int i = 0 ; i < V ; i++)
        {
            res += dist[i];
        }
        System.out.println(res);

    }
}
