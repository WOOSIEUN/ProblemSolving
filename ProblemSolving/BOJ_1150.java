import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1150 {
    static class Node {
        int left, right, cost;

        public Node(int left, int right, int cost) {
            this.left = left;
            this.right = right;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));

        int prev = Integer.parseInt(br.readLine());
        Node[] company = new Node[N + 2];
        for (int i = 1; i < N; i++) {
            int location = Integer.parseInt(br.readLine());
            company[i] = new Node(i - 1, i + 1, location - prev);
            queue.add(new Node(i, i + 1, company[i].cost));
            prev = location;
        }

        company[0] = new Node(0, 0, 0);
        company[N] = new Node(N - 1, N + 1, 0);
        company[N + 1] = new Node(0, 0, 0);

        int ans = 0;
        for (int i = 0; i < K;) {
            Node cur = queue.poll();
            int curLeft = cur.left;
            int curRight = cur.right;

            if (isInMap(cur, N) && curRight == company[curLeft].right && curLeft == company[curRight].left) {
                ans += cur.cost;
                if (++i >= K) break;

                int newLeft = company[curLeft].left;
                int newRight = company[curRight].right;

                cur.left = newLeft;
                cur.right = newRight;

                company[newLeft].cost = company[newLeft].cost + company[curRight].cost - cur.cost;
                cur.cost = company[newLeft].cost;

                queue.add(cur);

                company[newLeft].right = newRight;
                company[newRight].left = newLeft;
            }
        }

        bw.write(String.valueOf(ans));
        br.close();
        bw.close();
    }

    private static boolean isInMap(Node cur, int N) {
        return 0 < cur.left && cur.right <= N;
    }
}
