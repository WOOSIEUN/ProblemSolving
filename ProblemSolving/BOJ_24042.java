import java.io.*;
import java.util.*;

public class BOJ_24042 {
    static class Node implements Comparable<Node>{
        int to;
        long dist;

        public Node(int to, long dist) {
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Node node) {
            return Long.compare(this.dist, node.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList [N + 1];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int time = 0; time < M; time++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[a].add(new Node(b, time));
            graph[b].add(new Node(a, time));
        }

        long[] dist = dijkstra(0, graph, M);

        bw.write(String.valueOf(dist[N - 1]));
        br.close();
        bw.close();
    }

    private static long[] dijkstra(int start, List<Node>[] graph, int M) {
        long[] dist = new long[graph.length];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.to] < cur.dist) {
                continue;
            }

            for (Node next : graph[cur.to]) {
                long nextDist = cur.dist + ((next.dist - cur.dist) % M + M) % M + 1;
                if (dist[next.to] > nextDist) {
                    dist[next.to] = nextDist;
                    pq.add(new Node(next.to, nextDist));
                }
            }
        }

        return dist;
    }
}
