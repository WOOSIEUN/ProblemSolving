import java.io.*;
import java.util.StringTokenizer;

public class BOJ_6218 {

    static abstract class SegmentTree {
        int[] tree;

        public SegmentTree(int N, int[] value) {
            double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
            tree = new int [(int) Math.pow(2, treeHeight + 1)];
            init(value, 1, 0, N - 1);
        }

        abstract void init(int[] value, int cur, int start, int end);
    }

    static class MinSegmentTree extends SegmentTree {
        public MinSegmentTree(int N, int[] value) {
            super(N, value);
        }

        void init(int[] value, int cur, int start, int end) {
            if (start == end) {
                tree[cur] = value[start];
                return;
            }

            int mid = (start + end) / 2;
            init(value, cur * 2, start, mid);
            init(value, cur * 2 + 1, mid + 1, end);

            if (tree[cur * 2] < tree[cur * 2 + 1]) {
                tree[cur] = tree[cur * 2];
            } else {
                tree[cur] = tree[cur * 2 + 1];
            }
        }

        int query(int from, int to, int cur, int start, int end) {
            if (to < start || end < from) {
                return Integer.MAX_VALUE;
            }

            if (from <= start && end <= to) {
                return tree[cur];
            }

            int mid = (start + end) / 2;
            int left = query(from, to, cur * 2, start, mid);
            int right = query(from, to, cur * 2 + 1, mid + 1, end);
            return Math.min(left, right);
        }
    }

    static class MaxSegmentTree extends SegmentTree {
        public MaxSegmentTree(int N, int[] value) {
            super(N, value);
        }

        void init(int[] value, int cur, int start, int end) {
            if (start == end) {
                tree[cur] = value[start];
                return;
            }

            int mid = (start + end) / 2;
            init(value, cur * 2, start, mid);
            init(value, cur * 2 + 1, mid + 1, end);

            if (tree[cur * 2] > tree[cur * 2 + 1]) {
                tree[cur] = tree[cur * 2];
            } else {
                tree[cur] = tree[cur * 2 + 1];
            }
        }

        int query(int from, int to, int cur, int start, int end) {
            if (to < start || end < from) {
                return -1;
            }

            if (from <= start && end <= to) {
                return tree[cur];
            }

            int mid = (start + end) / 2;
            int left = query(from, to, cur * 2, start, mid);
            int right = query(from, to, cur * 2 + 1, mid + 1, end);
            return Math.max(left, right);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] value = new int[N];
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        MinSegmentTree minSegmentTree = new MinSegmentTree(N, value);
        MaxSegmentTree maxSegmentTree = new MaxSegmentTree(N, value);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) - 1;
            int B = Integer.parseInt(st.nextToken()) - 1;
            sb.append(maxSegmentTree.query(A, B, 1, 0, N - 1) - minSegmentTree.query(A, B, 1, 0, N - 1)).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
