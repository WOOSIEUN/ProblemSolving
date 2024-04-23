import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10999_LazyPropagation {
	static class SegmentTree {
		private long[] tree, lazy;
		
		public SegmentTree(int N, long[] values) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new long [(int) Math.pow(2, treeHeight + 1)];
			lazy = new long [(int) Math.pow(2, treeHeight + 1)];
			init(values, 1, 1, N);
		}

		private long init(long[] values, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = values[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = init(values, cur * 2, start, mid) + init(values, cur * 2 + 1, mid + 1, end);
		}

		private long pSum(int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);
			
			if (to < start || end < from) {
				return 0;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return pSum(from, to, cur * 2, start, mid) + pSum(from, to, cur * 2 + 1, mid + 1, end);	
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
			return tree[cur] = update(diff, from, to, cur * 2, start, mid) + update(diff, from, to, cur * 2 + 1, mid + 1, end);
		}

		private void propagate(int start, int end, int cur) {
			if (lazy[cur] == 0){
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] values = new long [N + 1];
		for (int i = 1; i <= N; i++) {
			values[i] = Long.parseLong(br.readLine());
		}

        SegmentTree segmentTree = new SegmentTree(N, values);
        
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				long d = Long.parseLong(st.nextToken());
				segmentTree.update(d, b, c, 1, 1, N);
			} else {
				sb.append(segmentTree.pSum(b, c, 1, 1, N)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
