import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14438 {
	static class SegmentTree {
		int[] tree;
		
		public SegmentTree(int N, int[] values) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1) + 1];
			init(values, 1, 1, N);
		}

		int init(int[] values, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = values[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = Math.min(init(values, cur * 2, start, mid), init(values, cur * 2 + 1, mid + 1, end));
		}

		int query(int from, int to, int cur, int start, int end) {
			if (to < start || end < from) {
				return Integer.MAX_VALUE;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return Math.min(query(from, to, cur * 2, start, mid), query(from, to, cur * 2 + 1, mid + 1, end));	
		}
		
		int update(int value, int idx, int cur, int start, int end) {
			if (idx < start || end < idx) {
				return tree[cur];
			}
			
			if (start == end) {
				return tree[cur] = value;
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = Math.min(update(value, idx, cur * 2, start, mid), update(value, idx, cur * 2 + 1, mid + 1, end));	
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] values = new int [N + 1];
		values[0] = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			values[i] = Integer.parseInt(st.nextToken());
		}

        SegmentTree segmentTree = new SegmentTree(N, values);
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				segmentTree.update(b, a, 1, 1, N);
			} else {
				sb.append(segmentTree.query(a, b, 1, 1, N)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}