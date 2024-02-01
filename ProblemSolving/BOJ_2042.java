import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2042 {
	static class SegmentTree {
		long[] tree;
		
		public SegmentTree(int N, long[] value) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new long [(int) Math.pow(2, treeHeight + 1)];
			init(value, 1, 0, N - 1);
		}
		
		long init(long[] value, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = value[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = init(value, cur * 2, start, mid) + init(value, cur * 2 + 1, mid + 1, end);		
		}
		
		long query(int from, int to, int cur, int start, int end) {
			if (to < start || end < from) {
				return 0;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return query(from, to, cur * 2, start, mid) + query(from, to, cur * 2 + 1, mid + 1, end);
		}
		
		long update(int idx, long value, int cur, int start, int end) {
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
	
	static int[] movieIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[] arr = new long [N];
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		SegmentTree segmentTree = new SegmentTree(N, arr);
		
		while (M > 0 || K > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken()) - 1;
			long c = Long.parseLong(st.nextToken());
			
			if (a == 1) {
				M--;
				segmentTree.update(b, c, 1, 0, N - 1);				
			} else {
				K--;
				sb.append(segmentTree.query(b, (int) c - 1, 1, 0, N - 1)).append("\n");				
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
