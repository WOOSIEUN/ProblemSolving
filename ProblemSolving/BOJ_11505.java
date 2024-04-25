import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11505 {
	static class SegmentTree {
		private final int MOD;
		private long[] tree;
		
		public SegmentTree(int N, int[] values) {
			this.MOD = 1_000_000_007;
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new long [(int) Math.pow(2, treeHeight + 1)];
			init(values, 1, 1, N);
		}
		
		private long init(int[] values, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = values[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = init(values, cur * 2, start, mid) * init(values, cur * 2 + 1, mid + 1, end) % MOD;
		}

		private long query(int left, int right, int cur, int start, int end) {
			if (right < start || end < left) {
				return 1;
			}
			
			if (left <= start && end <= right) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return query(left, right, cur * 2, start, mid) * query(left, right, cur * 2 + 1, mid + 1, end) % MOD;
		}
		
		private long update(int value, int idx, int cur, int start, int end) {
			if (idx < start || end < idx) {
				return tree[cur];
			}
			
			if (start == end) {
				return tree[cur] = value;
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = update(value, idx, cur * 2, start, mid) * update(value, idx, cur * 2 + 1, mid + 1, end) % MOD;	
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] values = new int [N + 1];
		for (int i = 1; i < N + 1; i++) {
			values[i] = Integer.parseInt(br.readLine());
		}
		
        SegmentTree segmentTree = new SegmentTree(N, values);
        
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				segmentTree.update(c, b, 1, 1, N);
			} else {
				sb.append(segmentTree.query(b, c, 1, 1, N)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}