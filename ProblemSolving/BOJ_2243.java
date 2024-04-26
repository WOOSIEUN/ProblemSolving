import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2243 {
	static class SegmentTree {
		private int[] tree;
		
		public SegmentTree(int N) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1)];
		}

		private int query(int target, int cur, int start, int end) {
			if (start == end) {
				update(-1, start, 1, 1, SIZE);
				return start;
			}
			
			int mid = (start + end) / 2;
			if (target <= tree[cur * 2]) {
				return query(target, cur * 2, start, mid);
			} else {
				return query(target - tree[cur * 2], cur * 2 + 1, mid + 1, end);
			}
		}
		
		private int update(int diff, int idx, int cur, int start, int end) {
			if (idx < start || end < idx) {
				return tree[cur];
			}
			
			if (start == end) {
				return tree[cur] += diff;
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = update(diff, idx, cur * 2, start, mid) + update(diff, idx, cur * 2 + 1, mid + 1, end);	
		}
	}
	
	static final int SIZE = 1_000_000;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
        SegmentTree segmentTree = new SegmentTree(SIZE);

		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (a == 1) {
				sb.append(segmentTree.query(b, 1, 1, SIZE)).append("\n");
			} else {
				int c = Integer.parseInt(st.nextToken());
				segmentTree.update(c, b, 1, 1, SIZE);
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}