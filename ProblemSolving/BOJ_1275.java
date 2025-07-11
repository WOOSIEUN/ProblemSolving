import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1275 {
    static class SegmentTree {
    private long[] tree;

    public SegmentTree(int N, int[] value) {
        double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
        tree = new long [(int) Math.pow(2, treeHeight + 1) + 1];
        init(value, 1, 1, N);
    }

    private long init(int[] value, int cur, int start, int end) {
        if (start == end) {
            return tree[cur] = value[start];
        }

        int mid = (start + end) / 2;
        return tree[cur] = init(value, cur * 2, start, mid) + init(value, cur * 2 + 1, mid + 1, end);
    }

    private long query(int from, int to, int cur, int start, int end) {
        if (to < start || end < from) {
            return 0;
        }

        if (from <= start && end <= to) {
            return tree[cur];
        }

        int mid = (start + end) / 2;
        return query(from, to, cur * 2, start, mid) + query(from, to, cur * 2 + 1, mid + 1, end);
    }

    private long update(int idx, long value, int cur, int start, int end) {
        if (idx < start || end < idx) {
            return tree[cur];
        }

        if (start == end) {
            return tree[cur] = value;
        }

        int mid = (start + end) / 2;
        return tree[cur] = update(idx, value, cur * 2, start, mid) + update(idx, value, cur * 2 + 1, mid + 1, end);
    }
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] values = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < values.length; i++) {
            values[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(N, values);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(tree.query(Math.min(x, y), Math.max(x, y), 1, 1, N)).append("\n");
            tree.update(a, b, 1, 1, N);
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
