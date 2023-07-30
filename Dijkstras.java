import java.util.*;

class Pair {
    int Dist;
    int Node;

    Pair(int x, int y) {
        Dist = x;
        Node = y;
    }
}

class Dijkstras {
    public static int[] dijkstraShortestPath(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.Dist - y.Dist);
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = (int) (1e9);
        }
        distance[s] = 0;
        pq.add(new Pair(0, s));
        while (!pq.isEmpty()) {
            int dis = pq.peek().Dist;
            int node = pq.peek().Node;
            pq.remove();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (dis + edgeWeight < distance[adjNode]) {
                    distance[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(distance[adjNode], adjNode));
                }
            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices (V): ");
        int V = scanner.nextInt();

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges (E): ");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (vertex1 vertex2 weight): ");
        for (int i = 0; i < E; i++) {
            int vertex1 = scanner.nextInt();
            int vertex2 = scanner.nextInt();
            int weight = scanner.nextInt();
            adj.get(vertex1).add(new ArrayList<>(Arrays.asList(vertex2, weight)));
            adj.get(vertex2).add(new ArrayList<>(Arrays.asList(vertex1, weight))); // Assuming an undirected graph
        }

        System.out.print("Enter the source vertex (s): ");
        int sourceVertex = scanner.nextInt();

        scanner.close();

        int[] shortestDistances = dijkstraShortestPath(V, adj, sourceVertex);

        // Print the shortest distances from the source vertex to all other vertices
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from " + sourceVertex + " to vertex " + i + " is: " + shortestDistances[i]);
        }
    }
}




//Time Compleity = ElogV;