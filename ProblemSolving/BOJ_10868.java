import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_10868 {
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
		int min;
		
		public MinSegmentTree(int N, int[] value) {
			super(N, value);
		}
		
		void initMin() {
			min = Integer.MAX_VALUE;
		}
		
		int getMin() {
			return min;
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
		
		void query(int from, int to, int cur, int start, int end) {
			if (to < start || end < from) {
				return;
			}
			
			if (from <= start && end <= to) {
				min = Math.min(min, tree[cur]);
				return;
			}
			
			int mid = (start + end) / 2;
			query(from, to, cur * 2, start, mid);
			query(from, to, cur * 2 + 1, mid + 1, end);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int [N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		MinSegmentTree minSegmentTree = new MinSegmentTree(N, arr);
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			
			minSegmentTree.initMin();
			minSegmentTree.query(a, b, 1, 0, N - 1);
			
			sb.append(minSegmentTree.getMin()).append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
