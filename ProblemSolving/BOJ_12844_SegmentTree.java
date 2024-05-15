import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_12844_SegmentTree {
	static class SegmentTree {
		private int[] tree, lazy;
		
		public SegmentTree(int N, int[] values) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1)];
			lazy = new int [(int) Math.pow(2, treeHeight + 1)];
						
			init(values, 1, 0, N - 1);
		}
		
		private int init(int[] values, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = values[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = init(values, cur * 2, start, mid) ^ init(values, cur * 2 + 1, mid + 1, end);
		}

		private int query(int from, int to, int cur, int start, int end) {
			propagate(start, end, cur);
			
			if (to < start || end < from) {
				return 0;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return query(from, to, cur * 2, start, mid) ^ query(from, to, cur * 2 + 1, mid + 1, end);	
		}
		
		private int update(int diff, int from, int to, int cur, int start, int end) {
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
			return tree[cur] = update(diff, from, to, cur * 2, start, mid) ^ update(diff, from, to, cur * 2 + 1, mid + 1, end);
		}

		private void propagate(int start, int end, int cur) {
			if (lazy[cur] == 0){
				return;
			}

			if (start != end) {
				lazy[cur * 2] ^= lazy[cur];
				lazy[cur * 2 + 1] ^= lazy[cur];
			}
			
			tree[cur] ^= lazy[cur] * ((end - start + 1) % 2);
			lazy[cur] = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] sequence = new int [N];        
	    st = new StringTokenizer(br.readLine());
	    for(int i = 0; i < N; i++) {
		    sequence[i] = Integer.parseInt(st.nextToken());
	    }

		SegmentTree segmentTree = new SegmentTree(N, sequence);

		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			
			if (cmd == 1) {
				int k = Integer.parseInt(st.nextToken());
				segmentTree.update(k, i, j, 1, 0, N - 1);
			} else {
				sb.append(segmentTree.query(i, j, 1, 0, N - 1)).append("\n");
			}
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}