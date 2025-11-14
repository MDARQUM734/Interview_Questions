class Solution {

    class Edge {
        int dest, wt;
        public Edge(int d, int w) {
            this.dest = d;
            this.wt = w;
        }
    }

    class Pair implements Comparable<Pair> {
        int node, dist;
        public Pair(int n, int d) {
            this.node = n;
            this.dist = d;
        }
        public int compareTo(Pair p) {
            return this.dist - p.dist;
        }
    }

    public int countPaths(int n, int[][] roads) {
        int MOD = (int)(1e9 + 7);
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) graph[i] = new ArrayList<>();

        for(int[] r : roads) {
            graph[r[0]].add(new Edge(r[1], r[2]));
            graph[r[1]].add(new Edge(r[0], r[2]));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.dist;

            if (d > dist[u]) continue;

            for(Edge e : graph[u]) {
                int v = e.dest;
                long newDist = dist[u] + e.wt;
                if (newDist < dist[v]) {
                    dist[v] = newDist;
                    ways[v] = ways[u] % MOD; 
                    pq.add(new Pair(v, (int) newDist));
                }
                else if (newDist == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}