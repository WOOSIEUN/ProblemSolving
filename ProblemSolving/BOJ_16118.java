import java.io.*;
import java.util.*;

public class BOJ_16118 {
    static class Node implements Comparable<Node> {
        int to, type;
        long weight;

        public Node(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        public Node(int to, long weight, int type) {
            this.to = to;
            this.weight = weight;
            this.type = type;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.weight, node.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long weight = Long.parseLong(st.nextToken());
            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        long[] moonlightFoxDist = getMoonlightFoxDist(1, graph);
        long[] moonlightWolfDist = getMoonlightWolfDist(1, graph);

        int ans = 0;
        for (int i = 2; i <= N; i++) {
            if (moonlightFoxDist[i] > moonlightWolfDist[i]) {
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static long[] getMoonlightFoxDist(int start, List<Node>[] graph) {
        long[] dist = new long [graph.length];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.to] < cur.weight) {
                continue;
            }

            for (Node next : graph[cur.to]) {
                long newWeight = cur.weight + next.weight * 2;
                if (dist[next.to] > newWeight) {
                    dist[next.to] = newWeight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }

        return dist;
    }

    private static long[] getMoonlightWolfDist(int start, List<Node>[] graph) {
        final int EVEN = 0, ODD = 1;
        long[][] dist = new long [2][graph.length];
        Arrays.fill(dist[EVEN], Long.MAX_VALUE);
        Arrays.fill(dist[ODD], Long.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0, EVEN));
        dist[EVEN][start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nextType = 1 - cur.type;

            if (dist[cur.type][cur.to] < cur.weight) {
                continue;
            }

            for (Node next : graph[cur.to]) {
                long newWeight = cur.weight + next.weight * (cur.type == EVEN ? 1 : 4);
                if (dist[nextType][next.to] > newWeight) {
                    dist[nextType][next.to] = newWeight;
                    pq.add(new Node(next.to, dist[nextType][next.to], nextType));
                }
            }
        }

        long[] result = new long[dist[0].length];
        for (int i = 1; i < dist[0].length; i++) {
            result[i] = Math.min(dist[0][i], dist[1][i]);
        }

        return result;
    }
}
