import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14427 {
	static class SegmentTree {
		int[] tree, values;
		
		public SegmentTree(int N, int[] values) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1) + 1];
			this.values = values;
			init(1, 1, N);
		}

		int init(int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = start;
			}
			
			int mid = (start + end) / 2;
			int left = init(cur * 2, start, mid);
			int right = init(cur * 2 + 1, mid + 1, end);
			return tree[cur] = getMinIdx(left, right);		
		}

		int getRootNode() {
			return tree[1];
		}
		
		int update(int idx, int cur, int start, int end) {
			if (idx < start || end < idx) {
				return tree[cur];
			}
			
			if (start == end) {
				return tree[cur] = idx;
			}
			
			int mid = (start + end) / 2;
			int left = update(idx, cur * 2, start, mid);
			int right = update(idx, cur * 2 + 1, mid + 1, end);
			return tree[cur] = getMinIdx(left, right);
		}
		
		private int getMinIdx(int left, int right) {
			if (values[left] == values[right]) {
				return Math.min(left, right);
			} else if (values[left] < values[right]) {
				return left;
			} else {
				return right;
			}
		}

		public void updateValue(int idx, int value) {
			values[idx] = value;
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
			
			if (cmd == 1) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				segmentTree.updateValue(a, b);
				segmentTree.update(a, 1, 1, N);
			} else {
				sb.append(segmentTree.getRootNode()).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}