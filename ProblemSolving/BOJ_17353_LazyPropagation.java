import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_17353_LazyPropagation {
	static class SegmentTree {
		private long[] tree, lazy;

		public SegmentTree(int N, long[] values) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new long[(int) Math.pow(2, treeHeight + 1)];
			lazy = new long[(int) Math.pow(2, treeHeight + 1)];
			init(values, 1, 1, N);
		}

		private long init(long[] values, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = values[start] - values[start - 1];
			}

			int mid = (start + end) / 2;
			return tree[cur] = init(values, cur * 2, start, mid) + init(values, cur * 2 + 1, mid + 1, end);
		}

		private long query(int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);

			if (to < start || end < from) {
				return 0;
			}

			if (from <= start && end <= to) {
				return tree[cur];
			}

			int mid = (start + end) / 2;
			return query(from, to, cur * 2, start, mid) + query(from, to, cur * 2 + 1, mid + 1, end);
		}

		private long update(long diff, int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);

			if (to < start || end < from) {
				return tree[cur];
			}

			if (from <= start && end <= to) {
				lazy[cur] += diff;
				propagate(start, end, cur);
				return tree[cur];
			}

			int mid = (start + end) / 2;
			return tree[cur] = update(diff, from, to, cur * 2, start, mid)
					+ update(diff, from, to, cur * 2 + 1, mid + 1, end);
		}

		private void propagate(int start, int end, int cur) {
			if (lazy[cur] == 0) {
				return;
			}

			if (start != end) {
				lazy[cur * 2] += lazy[cur];
				lazy[cur * 2 + 1] += lazy[cur];
			}

			tree[cur] += lazy[cur] * (end - start + 1);
			lazy[cur] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		long[] shootingStars = new long [N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			shootingStars[i] = Integer.parseInt(st.nextToken());
		}
		
		SegmentTree segmentTree = new SegmentTree(N, shootingStars);

		int Q = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int q = 0; q < Q; q++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int L = Integer.parseInt(st.nextToken());
				int R = Integer.parseInt(st.nextToken());
				segmentTree.update(1, L, R, 1, 1, N);
				segmentTree.update(-(R - L + 1), R + 1, R + 1, 1, 1, N);
			} else {
				int X = Integer.parseInt(st.nextToken());
				sb.append(segmentTree.query(1, X, 1, 1, N)).append('\n');
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
