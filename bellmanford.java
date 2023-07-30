import java.util.*;

class bellmanford {
    public static int[] bellmanFordShortestPath(int V, ArrayList<ArrayList<Integer>> adj, int s) {
        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[s] = 0;

        // Relax all edges V - 1 times
        for (int i = 1; i < V; i++) {
            for (int node = 0; node < V; node++) {
                for (int j = 0; j < adj.get(node).size(); j += 2) {
                    int adjNode = adj.get(node).get(j);
                    int edgeWeight = adj.get(node).get(j + 1);
                    if (distance[node] != Integer.MAX_VALUE && distance[node] + edgeWeight < distance[adjNode]) {
                        distance[adjNode] = distance[node] + edgeWeight;
                    }
                }
            }
        }

        // Check for negative cycles
        for (int node = 0; node < V; node++) {
            for (int j = 0; j < adj.get(node).size(); j += 2) {
                int adjNode = adj.get(node).get(j);
                int edgeWeight = adj.get(node).get(j + 1);
                if (distance[node] != Integer.MAX_VALUE && distance[node] + edgeWeight < distance[adjNode]) {
                    // Graph contains a negative cycle
                    throw new RuntimeException("Graph contains a negative cycle");
                }
            }
        }

        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices (V): ");
        int V = scanner.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges (E): ");
        int E = scanner.nextInt();

        System.out.println("Enter the edges (from to weight): ");
        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
            adj.get(from).add(to);
            adj.get(from).add(weight);
        }

        System.out.print("Enter the source vertex (s): ");
        int sourceVertex = scanner.nextInt();

        scanner.close();

        int[] shortestDistances = bellmanFordShortestPath(V, adj, sourceVertex);

        // Print the shortest distances from the source vertex to all other vertices
        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from " + sourceVertex + " to vertex " + i + " is: " + shortestDistances[i]);
        }
    }
}
