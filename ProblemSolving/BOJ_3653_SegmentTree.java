import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3653_SegmentTree {
	static class SegmentTree {
		int[] tree;
		
		public SegmentTree(int N, int[] value) {
			double treeHeight = Math.ceil((Math.log(N) / Math.log(2)));
			tree = new int [(int) Math.pow(2, treeHeight + 1)];
			init(value, 1, 0, N - 1);
		}

		int init(int[] value, int cur, int start, int end) {
			if (start == end) {
				return tree[cur] = value[start];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = init(value, cur * 2, start, mid) + init(value, cur * 2 + 1, mid + 1, end);		
		}
		
		int query(int from, int to, int cur, int start, int end) {
			if (to < start || end < from) {
				return 0;
			}
			
			if (from <= start && end <= to) {
				return tree[cur];
			}
			
			int mid = (start + end) / 2;
			return tree[cur] = query(from, to, cur * 2, start, mid) + query(from, to, cur * 2 + 1, mid + 1, end);	
		}
		
		int update(int idx, int value, int cur, int start, int end) {
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
	
	static int[] movie, movieIdx;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int arrLen = n + m;
			
			movie = new int [arrLen];
			movieIdx = new int [n];
			for (int i = 0; i < n; i++) {
				movie[m + i] = 1;
				movieIdx[i] = m + i;
			}

            SegmentTree segmentTree = new SegmentTree(arrLen, movie);
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int movie = Integer.parseInt(st.nextToken()) - 1;
				sb.append(segmentTree.query(0, movieIdx[movie] - 1, 1, 0, arrLen - 1)).append(" ");
				
				segmentTree.update(movieIdx[movie], 0, 1, 0, arrLen - 1);
				movieIdx[movie] = m - i - 1;
				segmentTree.update(movieIdx[movie], 1, 1, 0, arrLen - 1);
			}
			
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		br.close();
		bw.close();
	}
}
