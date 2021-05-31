import java.util.*;
public class Main {
    private int dist[];
    private Set<Integer> settled;
    private PriorityQueue<Node> pq;
    private int V;
    List<List<Node> > adj;

    public Main(int V)
    {
        this.V = V;
        dist = new int[V];
        settled = new HashSet<Integer>();
        pq = new PriorityQueue<Node>(V, new Node());
    }

    public void dijkstra(List<List<Node> > adj, int src)
    {
        this.adj = adj;

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;

        pq.add(new Node(src, 0));
        dist[src] = 0;
        while (settled.size() != V) {

            int u = pq.remove().node;

            settled.add(u);

            e_Neighbours(u);
        }
    }


    private void e_Neighbours(int u)
    {
        int edgeDistance = -1;
        int newDistance = -1;

        for (int i = 0; i < adj.get(u).size(); i++) {
            Node v = adj.get(u).get(i);

            if (!settled.contains(v.node)) {
                edgeDistance = v.cost;
                newDistance = dist[u] + edgeDistance;

                if (newDistance < dist[v.node])
                    dist[v.node] = newDistance;

                pq.add(new Node(v.node, dist[v.node]));
            }
        }
    }

    public static void main(String arg[])
    {
        int source = 0;
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt() + 1;
        int m = scanner.nextInt();

        List<List<Node> > adj = new ArrayList<List<Node> >();

        for (int i = 0; i < V; i++) {
            List<Node> item = new ArrayList<Node>();
            adj.add(item);
        }
        int[] cost = new int[V];
        for (int i = 0; i < V - 1; i++) {
            cost[i] = scanner.nextInt();
            adj.get(0).add(new Node(i + 1, cost[i]));

        }
        int v1, v2, val;
        for (int i = 0; i < m ; i++) {
            v1 = scanner.nextInt();
            v2 = scanner.nextInt();
            val = scanner.nextInt();
            adj.get(v2).add(new Node(v1 , val*2));
            adj.get(v1).add(new Node(v2 , val*2));


        }

        Main dpq = new Main(V);
        dpq.dijkstra(adj, source);

        for (int i = 1; i < dpq.dist.length; i++)
            System.out.print(dpq.dist[i] + " ");
    }
}
class Node implements Comparator<Node> {
    public int node;
    public int cost;

    public Node()
    {
    }

    public Node(int node, int cost)
    {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compare(Node node1, Node node2)
    {
        if (node1.cost < node2.cost)
            return -1;
        if (node1.cost > node2.cost)
            return 1;
        return 0;
    }
}
